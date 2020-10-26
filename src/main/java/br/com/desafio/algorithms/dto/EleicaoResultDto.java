package br.com.desafio.algorithms.dto;

public class EleicaoResultDto {

    private String mensagem;
    
    public EleicaoResultDto(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return this.mensagem;
    }
}