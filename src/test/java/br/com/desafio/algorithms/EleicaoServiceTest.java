package br.com.desafio.algorithms;

import br.com.desafio.algorithms.dto.DadosParaVotacaoDto;
import br.com.desafio.algorithms.dto.EleicaoResultDto;
import br.com.desafio.algorithms.service.EleicaoService;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class EleicaoServiceTest {

    @Test
    public void testeIgualDezesseis() {
        EleicaoService service = new EleicaoService();
        DadosParaVotacaoDto dto = new DadosParaVotacaoDto(2006, 1990);        
        EleicaoResultDto dtoResult = service.validarAnoVotacao(dto);
        assertThat(dtoResult.getMensagem()).isEqualTo("Você poderá votar esse ano");
    }

    @Test
    public void testeMenosDezesseis() {
        EleicaoService service = new EleicaoService();
        DadosParaVotacaoDto dto = new DadosParaVotacaoDto(2006, 1998);        
        EleicaoResultDto dtoResult = service.validarAnoVotacao(dto);
        assertThat(dtoResult.getMensagem()).isEqualTo("Você não poderá votar esse ano");
    }

    @Test
    public void testeMaiorDezesseis() {
        EleicaoService service = new EleicaoService();
        DadosParaVotacaoDto dto = new DadosParaVotacaoDto(2006, 1980);        
        EleicaoResultDto dtoResult = service.validarAnoVotacao(dto);
        assertThat(dtoResult.getMensagem()).isEqualTo("Você poderá votar esse ano");
    }

}