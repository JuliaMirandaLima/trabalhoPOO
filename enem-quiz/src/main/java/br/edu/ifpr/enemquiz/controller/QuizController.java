package br.edu.ifpr.enemquiz.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.ifpr.enemquiz.model.Questao;
import br.edu.ifpr.enemquiz.service.EnemApiService;
import jakarta.servlet.http.HttpSession;

// Esse controller guarda o "estado do jogo" na sessao HTTP (HttpSession):
// a lista de questoes, qual questao a pessoa esta respondendo (indice) e
// quantas ela ja acertou. Assim nao precisa de banco de dados pra nada disso.
@Controller
public class QuizController {

    private final EnemApiService enemApiService;

    public QuizController(EnemApiService enemApiService) {
        this.enemApiService = enemApiService;
    }

    // tela inicial: escolher o ano da prova e a quantidade de questoes
    @GetMapping("/")
    public String inicio() {
        return "inicio";
    }

    // busca as questoes na API e comeca o quiz do zero
    @PostMapping("/iniciar")
    public String iniciar(@RequestParam int ano, @RequestParam int quantidade, HttpSession session) {
        List<Questao> questoes = enemApiService.buscarQuestoes(ano, quantidade);

        session.setAttribute("questoes", questoes);
        session.setAttribute("indice", 0);
        session.setAttribute("acertos", 0);

        return "redirect:/questao";
    }

    // mostra a questao atual (a que corresponde ao "indice" guardado na sessao)
    @SuppressWarnings("unchecked")
    @GetMapping("/questao")
    public String mostrarQuestao(HttpSession session, Model model) {
        List<Questao> questoes = (List<Questao>) session.getAttribute("questoes");
        Integer indice = (Integer) session.getAttribute("indice");

        if (questoes == null || indice == null) {
            return "redirect:/"; // ninguem iniciou um quiz ainda
        }

        if (indice >= questoes.size()) {
            return "redirect:/resultado"; // acabaram as questoes
        }

        Questao questaoAtual = questoes.get(indice);
        model.addAttribute("questao", questaoAtual);
        model.addAttribute("numero", indice + 1);
        model.addAttribute("total", questoes.size());

        return "questao";
    }

    // recebe a letra marcada no formulario e confere se acertou
    @SuppressWarnings("unchecked")
    @PostMapping("/responder")
    public String responder(@RequestParam String resposta, HttpSession session, Model model) {
        List<Questao> questoes = (List<Questao>) session.getAttribute("questoes");
        int indice = (Integer) session.getAttribute("indice");
        int acertos = (Integer) session.getAttribute("acertos");

        Questao questaoRespondida = questoes.get(indice);
        boolean acertou = questaoRespondida.getAlternativaCorreta().equalsIgnoreCase(resposta);

        if (acertou) {
            acertos++;
        }
        indice++;

        session.setAttribute("indice", indice);
        session.setAttribute("acertos", acertos);

        model.addAttribute("acertou", acertou);
        model.addAttribute("respostaCorreta", questaoRespondida.getAlternativaCorreta());
        model.addAttribute("acabou", indice >= questoes.size());

        return "feedback";
    }

    // tela final com o placar
    @SuppressWarnings("unchecked")
    @GetMapping("/resultado")
    public String resultado(HttpSession session, Model model) {
        Integer acertos = (Integer) session.getAttribute("acertos");
        List<Questao> questoes = (List<Questao>) session.getAttribute("questoes");

        if (acertos == null || questoes == null) {
            return "redirect:/";
        }

        model.addAttribute("acertos", acertos);
        model.addAttribute("total", questoes.size());

        return "resultado";
    }

}
