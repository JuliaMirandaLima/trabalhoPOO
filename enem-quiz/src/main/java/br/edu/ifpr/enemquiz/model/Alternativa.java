package br.edu.ifpr.enemquiz.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// Representa uma alternativa dentro de uma questao (letra + enunciadoAlternativao).
// @JsonIgnoreProperties(ignoreUnknown = true) diz pro Jackson (quem transforma
// o JSON da API em objeto Java) ignorar os campos que a API manda e que a
// gente nao precisa usar aqui, em vez de dar erro.
@JsonIgnoreProperties(ignoreUnknown = true)
public class Alternativa {

    private String letra; // "A", "B", "C", "D" ou "E"
    private String enunciadoAlternativa;   // o enunciadoAlternativao da alternativa
    private String imagem;   // opcional: link de uma imagem da alternativa

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public String getEnunciadoAlternativa() {
        return enunciadoAlternativa;
    }

    public void setEnunciadoAlternativa(String enunciadoAlternativa) {
        this.enunciadoAlternativa = enunciadoAlternativa;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

}
