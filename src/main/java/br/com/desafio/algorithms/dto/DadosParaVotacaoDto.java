package br.com.desafio.algorithms.dto;

public class DadosParaVotacaoDto {

    private int anoAtual;
    private int anoNascimento;
    
    public DadosParaVotacaoDto(int anoAtual, int anoNascimento) {
        this.anoAtual = anoAtual;
        this.anoNascimento = anoNascimento;
    }

    public int getAnoAtual() {
        return this.anoAtual;
    }

    public int getAnoNascimento() {
        return this.anoNascimento;
    }
}