package com.ligapadel.GestorLigaPadel.dto.request.team;

import com.ligapadel.GestorLigaPadel.dto.request.categoria.CategoriaBasicDTO;
import com.ligapadel.GestorLigaPadel.entity.Categoria;

public class TeamBasicDTO {
    private Long id;
    private String name;
    private String categoria;

    public TeamBasicDTO() {
    }

    public TeamBasicDTO(Long id, String name, String categoria) {
        this.id = id;
        this.name = name;
        this.categoria = categoria;
    }
    public TeamBasicDTO(Long id, String name) {
        this.id = id;
        this.name = name;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
