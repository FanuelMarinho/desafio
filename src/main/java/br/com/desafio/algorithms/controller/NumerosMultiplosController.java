package br.com.desafio.algorithms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.algorithms.dto.MultiplosResultDto;
import br.com.desafio.algorithms.dto.NumerosMultiplosDto;
import br.com.desafio.algorithms.service.NumerosMutiplosService;

@RestController
@RequestMapping("/api/multiplos")
public class NumerosMultiplosController {

    @Autowired
    private NumerosMutiplosService service;

    @PostMapping    
    public ResponseEntity<MultiplosResultDto> calcularMultiplos(@RequestBody NumerosMultiplosDto dto){
        MultiplosResultDto result = service.calcular(dto);
        return ResponseEntity.ok(result);
    }

}