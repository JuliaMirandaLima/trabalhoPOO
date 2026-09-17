package br.edu.ifpr.enemquiz.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import br.edu.ifpr.enemquiz.model.Questao;
import br.edu.ifpr.enemquiz.model.RespostaEnemApi;

// Essa classe eh a unica responsavel por falar com a API do ENEM.
// O RestClient eh a forma mais simples do Spring de fazer requisicoes HTTP
// (ele ja converte o JSON da resposta pra objeto Java sozinho).
@Service
public class EnemApiService {

    private final RestClient restClient = RestClient.create("https://api.enem.dev/v1");

    // busca "quantidade" questoes da prova de um determinado "ano"
    public List<Questao> buscarQuestoes(int ano, int quantidade) {
        RespostaEnemApi resposta = restClient.get()
                .uri("/exams/{ano}/questions?limit={quantidade}", ano, quantidade)
                .retrieve()
                .body(RespostaEnemApi.class);

        return resposta.getQuestoes();
    }

}
