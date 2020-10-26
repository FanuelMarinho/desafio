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

import br.com.desafio.algorithms.controller.NumerosMultiplosController;
import br.com.desafio.algorithms.dto.MultiplosResultDto;
import br.com.desafio.algorithms.dto.NumerosMultiplosDto;
import br.com.desafio.algorithms.service.NumerosMutiplosService;

@WebMvcTest(NumerosMultiplosController.class)
public class NumerosMultiplosControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NumerosMutiplosService service;

    @Test
    public void testSaoMultiplos() throws Exception {
        when(service.calcular(any(NumerosMultiplosDto.class))).thenReturn(new MultiplosResultDto("São múltiplos"));
        mockMvc.perform(post("/api/multiplos")
            .contentType(MediaType.APPLICATION_JSON)
            .content(" {\"a\": 2, \"b\": 2}")
            .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("São múltiplos")));
    }

    @Test
    public void testNaoSaoMultiplos() throws Exception {
        when(service.calcular(any(NumerosMultiplosDto.class))).thenReturn(new MultiplosResultDto("Não são múltiplos"));
        mockMvc.perform(post("/api/multiplos")
            .contentType(MediaType.APPLICATION_JSON)
            .content(" {\"a\": 2, \"b\": 2}")
            .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("Não são múltiplos")));
    }
}