package br.com.desafio.algorithms.service;

import org.springframework.stereotype.Service;

import br.com.desafio.algorithms.dto.MultiplosResultDto;
import br.com.desafio.algorithms.dto.NumerosMultiplosDto;

@Service
public class NumerosMutiplosService {

    public MultiplosResultDto calcular(NumerosMultiplosDto dto) {
        boolean saoMultiplos = ((dto.getA() % dto.getB()) == 0) && ((dto.getB() % dto.getA()) == 0);
        if (saoMultiplos) {
            return new MultiplosResultDto("São múltiplos");
        } else {
            return new MultiplosResultDto("Não são múltiplos");
        }

    }
}