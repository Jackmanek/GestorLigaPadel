package com.ligapadel.GestorLigaPadel.dto.request.temporada;

import java.util.List;

public class TemporadaDTO {
    private Long id;
    private String nombre;
    private List<Long> faseIds;

    public TemporadaDTO() {}

    public TemporadaDTO(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public TemporadaDTO(Long id, String nombre, List<Long> faseIds) {
        this.id = id;
        this.nombre = nombre;
        this.faseIds = faseIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Long> getFaseIds() {
        return faseIds;
    }

    public void setFaseIds(List<Long> faseIds) {
        this.faseIds = faseIds;
    }
}
