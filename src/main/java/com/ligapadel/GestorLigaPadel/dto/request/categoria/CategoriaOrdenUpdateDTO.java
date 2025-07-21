package com.ligapadel.GestorLigaPadel.dto.request.categoria;

public class CategoriaOrdenUpdateDTO {
    private int orden;

    // Constructor vacío
    public CategoriaOrdenUpdateDTO() {}

    // Constructor
    public CategoriaOrdenUpdateDTO(int orden) {
        this.orden = orden;
    }

    // Getters y Setters
    public int getOrden() { return orden; }
    public void setOrden(int orden) { this.orden = orden; }
}
