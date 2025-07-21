package com.ligapadel.GestorLigaPadel.dto.request.categoria;

import com.ligapadel.GestorLigaPadel.dto.request.fase.FaseDTO;
import com.ligapadel.GestorLigaPadel.dto.request.team.TeamDTO;

import java.util.List;

public class CategoriaDTO {
    private Long id;
    private String nombre;
    private int orden;
    private FaseDTO fase;
    private List<TeamDTO> teams;
    public CategoriaDTO() {}

    public CategoriaDTO(Long id, String nombre, int orden, FaseDTO fase, List<TeamDTO> teams) {
        this.id = id;
        this.nombre = nombre;
        this.orden = orden;
        this.fase = fase;
        this.teams = teams;
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

    public FaseDTO getFase() {
        return fase;
    }

    public void setFase(FaseDTO fase) {
        this.fase = fase;
    }

    public List<TeamDTO> getTeams() {
        return teams;
    }

    public void setTeams(List<TeamDTO> teams) {
        this.teams = teams;
    }
}
