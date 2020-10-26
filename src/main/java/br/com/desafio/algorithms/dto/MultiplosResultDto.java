package br.com.desafio.algorithms.dto;

public class MultiplosResultDto {
    private String mensagem;
    
    public MultiplosResultDto(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return this.mensagem;
    }
}