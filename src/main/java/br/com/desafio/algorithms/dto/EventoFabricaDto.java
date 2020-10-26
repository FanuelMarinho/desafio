package br.com.desafio.algorithms.dto;

public class EventoFabricaDto {
    
    private int eventoEmSegundos;

    public EventoFabricaDto(int eventoEmSegundos) {
        this.eventoEmSegundos = eventoEmSegundos;
    }

    public EventoFabricaDto() {
    }

    public int getEventoEmSegundos() {
        return this.eventoEmSegundos;
    } 

}