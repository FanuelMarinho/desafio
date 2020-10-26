package br.com.desafio.algorithms;

import br.com.desafio.algorithms.dto.MultiplosResultDto;
import br.com.desafio.algorithms.dto.NumerosMultiplosDto;
import br.com.desafio.algorithms.service.NumerosMutiplosService;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class NumerosMutiplosServiceTest {


    @Test
    public void testeSaoMultiplos() {
        NumerosMutiplosService service = new NumerosMutiplosService();
        MultiplosResultDto result = service.calcular(new NumerosMultiplosDto(2, 2));
        assertThat(result.getMensagem()).isEqualTo("São múltiplos");       
    }

    @Test
    public void testeNaoSaoMultiplos() {
        NumerosMutiplosService service = new NumerosMutiplosService();
        MultiplosResultDto result = service.calcular(new NumerosMultiplosDto(16, 2));
        assertThat(result.getMensagem()).isEqualTo("Não são múltiplos");       
    }
}