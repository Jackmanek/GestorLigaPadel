package com.ligapadel.GestorLigaPadel.dto.request.temporada;

public class TemporadaCreateDTO {
    private String nombre;

    public TemporadaCreateDTO() {}

    public TemporadaCreateDTO(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
