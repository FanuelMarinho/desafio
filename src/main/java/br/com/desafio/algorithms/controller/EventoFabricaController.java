package br.com.desafio.algorithms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.algorithms.dto.EventoFabricaDto;
import br.com.desafio.algorithms.dto.EventoFabricaResultadoDto;
import br.com.desafio.algorithms.service.EventoFabricaService;


@RestController
@RequestMapping("/api/eventofabrica")
public class EventoFabricaController {

    @Autowired
    private EventoFabricaService eventoFabricaService;

    @PostMapping("/tempo")
    public ResponseEntity<EventoFabricaResultadoDto> calculaEventoFabricaEmDataFormatada(@RequestBody EventoFabricaDto dto) {
        EventoFabricaResultadoDto dtoResult = eventoFabricaService.expandirTempoDuracaoEvento(dto);
        return ResponseEntity.ok(dtoResult);
    }

}