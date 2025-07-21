package com.ligapadel.GestorLigaPadel.dto.request.categoria;

public class CategoriaCreateDTO {
    private String nombre;
    private int orden;
    private Long faseId;

    // Constructor vacío
    public CategoriaCreateDTO() {}

    // Constructor
    public CategoriaCreateDTO(String nombre, int orden, Long faseId) {
        this.nombre = nombre;
        this.orden = orden;
        this.faseId = faseId;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getOrden() { return orden; }
    public void setOrden(int orden) { this.orden = orden; }

    public Long getFaseId() { return faseId; }
    public void setFaseId(Long faseId) { this.faseId = faseId; }
}
