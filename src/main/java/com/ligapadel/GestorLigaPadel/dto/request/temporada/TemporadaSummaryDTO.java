package com.ligapadel.GestorLigaPadel.dto.request.temporada;

public class TemporadaSummaryDTO {
    private Long id;
    private String nombre;
    private int cantidadFases;

    public TemporadaSummaryDTO() {}

    public TemporadaSummaryDTO(Long id, String nombre, int cantidadFases) {
        this.id = id;
        this.nombre = nombre;
        this.cantidadFases = cantidadFases;
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

    public int getCantidadFases() {
        return cantidadFases;
    }

    public void setCantidadFases(int cantidadFases) {
        this.cantidadFases = cantidadFases;
    }
}
