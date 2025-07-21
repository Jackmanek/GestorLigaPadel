package com.ligapadel.GestorLigaPadel.dto.request.jornada;

public class JornadaDTO {
    private Long id;
    private int numJornada;
    private Long faseId;

    public JornadaDTO() {
    }

    public JornadaDTO(Long id, int numJornada, Long faseId) {
        this.id = id;
        this.numJornada = numJornada;
        this.faseId = faseId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
