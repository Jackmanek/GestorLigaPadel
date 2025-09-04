package com.ligapadel.GestorLigaPadel.dto.request.jornada;

public class JornadaCreateDTO {
    private int numJornada;
    private Long faseId;
    private Long categoriaId;

    public JornadaCreateDTO() {
    }

    public JornadaCreateDTO(int numJornada, Long faseId, Long categoriaId) {
        this.numJornada = numJornada;
        this.faseId = faseId;
        this.categoriaId = categoriaId;
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

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }
}
