package com.ligapadel.GestorLigaPadel.dto.request.fase;

public class FaseSummaryDTO {
    private Long id;
    private String nombre;
    private int orden;
    private String temporadaNombre;

    public FaseSummaryDTO() {}

    public FaseSummaryDTO(Long id, String nombre, int orden, String temporadaNombre) {
        this.id = id;
        this.nombre = nombre;
        this.orden = orden;
        this.temporadaNombre = temporadaNombre;
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

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public String getTemporadaNombre() {
        return temporadaNombre;
    }

    public void setTemporadaNombre(String temporadaNombre) {
        this.temporadaNombre = temporadaNombre;
    }
}
