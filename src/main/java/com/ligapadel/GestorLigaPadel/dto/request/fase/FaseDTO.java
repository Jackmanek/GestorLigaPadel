package com.ligapadel.GestorLigaPadel.dto.request.fase;

import com.ligapadel.GestorLigaPadel.dto.request.temporada.TemporadaDTO;

import java.util.List;

public class FaseDTO {
    private Long id;
    private String nombre;
    private int orden;
    private TemporadaDTO temporada;
    private List<Long> jornadaIds;
    private List<Long> teamIds;
    private List<Long> categoriaIds;

    public FaseDTO() {}

    public FaseDTO(Long id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }

    public FaseDTO(Long id, String nombre, int orden, TemporadaDTO temporada,
                   List<Long> jornadaIds, List<Long> teamIds, List<Long> categoriaIds) {
        this.id = id;
        this.nombre = nombre;
        this.orden = orden;
        this.temporada = temporada;
        this.jornadaIds = jornadaIds;
        this.teamIds = teamIds;
        this.categoriaIds = categoriaIds;
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

    public TemporadaDTO getTemporada() {
        return temporada;
    }

    public void setTemporada(TemporadaDTO temporada) {
        this.temporada = temporada;
    }

    public List<Long> getJornadaIds() {
        return jornadaIds;
    }

    public void setJornadaIds(List<Long> jornadaIds) {
        this.jornadaIds = jornadaIds;
    }

    public List<Long> getTeamIds() {
        return teamIds;
    }

    public void setTeamIds(List<Long> teamIds) {
        this.teamIds = teamIds;
    }

    public List<Long> getCategoriaIds() {
        return categoriaIds;
    }

    public void setCategoriaIds(List<Long> categoriaIds) {
        this.categoriaIds = categoriaIds;
    }
}
