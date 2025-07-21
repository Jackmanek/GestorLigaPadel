package com.ligapadel.GestorLigaPadel.dto.request.fase;

public class FaseCreateDTO {
    private String nombre;
    private int orden;
    private Long temporadaId;

    public FaseCreateDTO() {}

    public FaseCreateDTO(String nombre, int orden, Long temporadaId) {
        this.nombre = nombre;
        this.orden = orden;
        this.temporadaId = temporadaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public Long getTemporadaId() {
        return temporadaId;
    }

    public void setTemporadaId(Long temporadaId) {
        this.temporadaId = temporadaId;
    }
}
