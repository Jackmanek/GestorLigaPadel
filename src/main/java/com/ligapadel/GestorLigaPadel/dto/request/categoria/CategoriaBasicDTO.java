package com.ligapadel.GestorLigaPadel.dto.request.categoria;

public class CategoriaBasicDTO {
    private Long id;
    private String nombre;
    private int orden;
    private String faseNombre;

    // Constructor vacío
    public CategoriaBasicDTO() {}

    // Constructor
    public CategoriaBasicDTO(Long id, String nombre, int orden, String faseNombre) {
        this.id = id;
        this.nombre = nombre;
        this.orden = orden;
        this.faseNombre = faseNombre;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getOrden() { return orden; }
    public void setOrden(int orden) { this.orden = orden; }

    public String getFaseNombre() { return faseNombre; }
    public void setFaseNombre(String faseNombre) { this.faseNombre = faseNombre; }
}
