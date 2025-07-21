package com.ligapadel.GestorLigaPadel.dto.request.team;

public class TeamCreateDTO {
    private String name;
    private Long categoriaId;

    // Constructor vacío
    public TeamCreateDTO() {}

    // Constructor
    public TeamCreateDTO(String name, Long categoriaId) {
        this.name = name;
        this.categoriaId = categoriaId;
    }

    // Getters y Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Long getCategoriaId() { return categoriaId; }
    public void setCategoriaId(Long categoriaId) { this.categoriaId = categoriaId; }
}
