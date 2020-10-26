package br.com.desafio.algorithms.dto;

public class EventoFabricaResultadoDto {
    private int horas;
    private int minutos;
    private int segundos;

    public EventoFabricaResultadoDto(int horas, int minutos, int segundos) {
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public int getHoras() {
        return horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public int getSegundos() {
        return segundos;
    }


}