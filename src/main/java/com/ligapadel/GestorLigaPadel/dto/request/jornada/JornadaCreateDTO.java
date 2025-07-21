package com.ligapadel.GestorLigaPadel.dto.request.jornada;

public class JornadaCreateDTO {
    private int numJornada;
    private Long faseId;

    public JornadaCreateDTO() {
    }

    public JornadaCreateDTO(int numJornada, Long faseId) {
        this.numJornada = numJornada;
        this.faseId = faseId;
    }

    public int getNumJornada() {
        return numJornada;
    }

    public void setNumJornada(int numJornada) {
        this.numJornada = numJornada;
    }

    public Long getFaseId() {
        return faseId;
    }

    public void setFaseId(Long faseId) {
        this.faseId = faseId;
    }
}
