package com.ligapadel.GestorLigaPadel.dto.request.categoria;

public class CategoriaSummaryDTO {
    private Long id;
    private String nombre;
    private int orden;
    private String faseNombre;
    private int totalEquipos;

    // Constructor vacío
    public CategoriaSummaryDTO() {}

    // Constructor
    public CategoriaSummaryDTO(Long id, String nombre, int orden, String faseNombre, int totalEquipos) {
        this.id = id;
        this.nombre = nombre;
        this.orden = orden;
        this.faseNombre = faseNombre;
        this.totalEquipos = totalEquipos;
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

    public int getTotalEquipos() { return totalEquipos; }
    public void setTotalEquipos(int totalEquipos) { this.totalEquipos = totalEquipos; }
}
