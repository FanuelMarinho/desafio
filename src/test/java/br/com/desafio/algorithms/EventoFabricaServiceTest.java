package br.com.desafio.algorithms;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import br.com.desafio.algorithms.dto.EventoFabricaDto;
import br.com.desafio.algorithms.dto.EventoFabricaResultadoDto;
import br.com.desafio.algorithms.service.EventoFabricaService;

public class EventoFabricaServiceTest {

    @Test
    public void testeEventoUmaHora() {
        EventoFabricaService service = new EventoFabricaService();
        EventoFabricaResultadoDto result = service.expandirTempoDuracaoEvento(new EventoFabricaDto(3600));
        assertThat(result.getHoras()).isEqualTo(1);
        assertThat(result.getMinutos()).isEqualTo(0);
        assertThat(result.getSegundos()).isEqualTo(0);        
    }

    @Test    
    public void testeEventoUmaHoraEUmSegundo() {
        EventoFabricaService service = new EventoFabricaService();
        EventoFabricaResultadoDto result = service.expandirTempoDuracaoEvento(new EventoFabricaDto(3601));
        assertThat(result.getHoras()).isEqualTo(1);
        assertThat(result.getMinutos()).isEqualTo(0);
        assertThat(result.getSegundos()).isEqualTo(1);        
    }

    @Test
    public void testeEventoUmaHoraEUmMinuto() {
        EventoFabricaService service = new EventoFabricaService();
        EventoFabricaResultadoDto result = service.expandirTempoDuracaoEvento(new EventoFabricaDto(3660));
        assertThat(result.getHoras()).isEqualTo(1);
        assertThat(result.getMinutos()).isEqualTo(1);
        assertThat(result.getSegundos()).isEqualTo(0);        
    }
    
    @Test
    public void testeEventoUmaHoraEUmMinutoEUmSegundo() {
        EventoFabricaService service = new EventoFabricaService();
        EventoFabricaResultadoDto result = service.expandirTempoDuracaoEvento(new EventoFabricaDto(3661));
        assertThat(result.getHoras()).isEqualTo(1);
        assertThat(result.getMinutos()).isEqualTo(1);
        assertThat(result.getSegundos()).isEqualTo(1);        
    }

}