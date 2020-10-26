package br.com.desafio.algorithms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.algorithms.dto.DadosParaVotacaoDto;
import br.com.desafio.algorithms.dto.EleicaoResultDto;
import br.com.desafio.algorithms.service.EleicaoService;

@RestController
@RequestMapping("/api/eleicao")
public class EleicaoController {

    @Autowired
    private EleicaoService service;

    @PostMapping("/idade")
    public ResponseEntity<EleicaoResultDto> validaIdadeParaVotar(@RequestBody DadosParaVotacaoDto dto){
        EleicaoResultDto result = service.validarAnoVotacao(dto);
        return ResponseEntity.ok(result);
    }

}