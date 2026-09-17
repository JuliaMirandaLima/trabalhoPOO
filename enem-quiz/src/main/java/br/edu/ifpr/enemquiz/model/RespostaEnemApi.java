package br.edu.ifpr.enemquiz.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// A API devolve um JSON no formato { "metadata": {...}, "questoes": [...] }.
// A gente so precisa da lista de questoes, entao o "metadata" e ignorado
// (por isso o @JsonIgnoreProperties(ignoreUnknown = true) na classe).
@JsonIgnoreProperties(ignoreUnknown = true)
public class RespostaEnemApi {

    private List<Questao> questoes;

    public List<Questao> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List<Questao> questoes) {
        this.questoes = questoes;
    }

}
