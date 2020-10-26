package br.com.desafio.algorithms;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;

import br.com.desafio.algorithms.controller.EleicaoController;
import br.com.desafio.algorithms.dto.DadosParaVotacaoDto;
import br.com.desafio.algorithms.dto.EleicaoResultDto;
import br.com.desafio.algorithms.service.EleicaoService;

@WebMvcTest(EleicaoController.class)
public class EleicaoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EleicaoService service;

    @Test
    public void retornaOkEPodeVotar() throws Exception {
        when(service.validarAnoVotacao(any(DadosParaVotacaoDto.class))).thenReturn(new EleicaoResultDto("Você poderá votar esse ano"));
        mockMvc.perform(post("/api/eleicao/idade")
            .contentType(MediaType.APPLICATION_JSON)
            .content(" {\"anoNascimento\" : 1990, \"anoAtual\" : 2007 }")
            .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("Você poderá votar esse ano")));
    }

    @Test
    public void retornaOkENaoPodeVotar() throws Exception {
        when(service.validarAnoVotacao(any(DadosParaVotacaoDto.class))).thenReturn(new EleicaoResultDto("Você não poderá votar esse ano"));
        mockMvc.perform(post("/api/eleicao/idade")
            .contentType(MediaType.APPLICATION_JSON)
            .content(" {\"anoNascimento\" : 1990, \"anoAtual\" : 2007 }")
            .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("Você não poderá votar esse ano")));
    }
}