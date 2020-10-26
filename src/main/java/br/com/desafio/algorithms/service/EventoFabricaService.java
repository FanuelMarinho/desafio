package br.com.desafio.algorithms.service;

import org.springframework.stereotype.Service;

import br.com.desafio.algorithms.dto.EventoFabricaDto;
import br.com.desafio.algorithms.dto.EventoFabricaResultadoDto;

@Service
public class EventoFabricaService {
    private static final int HORA_EM_SEGUNDOS = 3600;
    private static final int MINUTO_EM_SEGUNDOS = 60;

    public EventoFabricaResultadoDto expandirTempoDuracaoEvento(EventoFabricaDto dto) {
        int tarefaEmSegundos = dto.getEventoEmSegundos();
        int horas = tarefaEmSegundos / HORA_EM_SEGUNDOS;
        tarefaEmSegundos -= horas * HORA_EM_SEGUNDOS;
        
        int minutos = tarefaEmSegundos / MINUTO_EM_SEGUNDOS;
        tarefaEmSegundos -= minutos * MINUTO_EM_SEGUNDOS;
        int segundos = tarefaEmSegundos;

        EventoFabricaResultadoDto dtoResult = new EventoFabricaResultadoDto(horas, minutos, segundos);
        return dtoResult;
    }

}