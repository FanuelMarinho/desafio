package br.com.desafio.algorithms.service;

import org.springframework.stereotype.Service;

import br.com.desafio.algorithms.dto.DadosParaVotacaoDto;
import br.com.desafio.algorithms.dto.EleicaoResultDto;

@Service
public class EleicaoService {

    private static final int IDADE_MINIMA_PARA_VOTAR = 16;

    public boolean teste() {
        return true;
    }

    public EleicaoResultDto validarAnoVotacao(DadosParaVotacaoDto dto) {
        int idade = dto.getAnoAtual() - dto.getAnoNascimento();
        if(idade < IDADE_MINIMA_PARA_VOTAR) {
            return new EleicaoResultDto("Você não poderá votar esse ano");
        } else {
            return new EleicaoResultDto("Você poderá votar esse ano");
        }
    }     
}