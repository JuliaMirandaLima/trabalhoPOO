package br.edu.ifpr.enemquiz.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// Representa uma questao, do jeito que a API do ENEM (api.enem.dev) devolve.
// Os nomes dos atributos aqui precisam ser IGUAIS aos nomes do JSON pra o
// Jackson conseguir preencher tudo sozinho (ex: "alternativaCorreta").
@JsonIgnoreProperties(ignoreUnknown = true)
public class Questao {

    private String titulo;
    private int id;
    private String disciplina;
    private int ano;
    private String enunciadoQuestao;              // enunciado da questao
    private List<String> imagem;          // imagens do enunciado (se tiver)
    private String alternativaCorreta;   // letra da alternativa correta: "A".."E"
    private String enunciadoPergunta;
    private List<Alternativa> alternativas;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getEnunciadoQuestao() {
        return enunciadoQuestao;
    }

    public void setEnunciadoQuestao(String enunciadoQuestao) {
        this.enunciadoQuestao = enunciadoQuestao;
    }

    public List<String> getImagem() {
        return imagem;
    }

    public void setImagem(List<String> imagem) {
        this.imagem = imagem;
    }

    public String getAlternativaCorreta() {
        return alternativaCorreta;
    }

    public void setAlternativaCorreta(String alternativaCorreta) {
        this.alternativaCorreta = alternativaCorreta;
    }

    public String getEnunciadoPergunta() {
        return enunciadoPergunta;
    }

    public void setEnunciadoPergunta(String enunciadoPergunta) {
        this.enunciadoPergunta = enunciadoPergunta;
    }

    public List<Alternativa> getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(List<Alternativa> alternativas) {
        this.alternativas = alternativas;
    }

}
