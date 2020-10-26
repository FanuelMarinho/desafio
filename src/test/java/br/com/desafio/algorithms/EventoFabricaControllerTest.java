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

import br.com.desafio.algorithms.controller.EventoFabricaController;
import br.com.desafio.algorithms.dto.EventoFabricaDto;
import br.com.desafio.algorithms.dto.EventoFabricaResultadoDto;
import br.com.desafio.algorithms.service.EventoFabricaService;

@WebMvcTest(EventoFabricaController.class)
public class EventoFabricaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EventoFabricaService service;

    @Test
    public void testeOKPost() throws Exception {
        when(service.expandirTempoDuracaoEvento(any(EventoFabricaDto.class))).thenReturn(new EventoFabricaResultadoDto(1, 0, 0));
        
        mockMvc.perform(post("/api/eventofabrica/tempo")
        .contentType(MediaType.APPLICATION_JSON)
        .content("  {\"eventoEmSegundos\" : 3600 } ")
        .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("\"horas\":1")));

    }

}