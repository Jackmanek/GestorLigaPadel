package com.ligapadel.GestorLigaPadel.dto.request.team;

import com.ligapadel.GestorLigaPadel.dto.request.categoria.CategoriaBasicDTO;
import com.ligapadel.GestorLigaPadel.dto.request.categoria.CategoriaDTO;
import com.ligapadel.GestorLigaPadel.dto.request.player.PlayerDTO;

import java.util.List;

public class TeamDTO {
    private Long id;
    private String name;
    private List<PlayerDTO> players;
    private int puntos;
    private int partidosJugados;
    private int victorias;
    private int derrotas;
    private int noJugado;
    private int noPresentado;
    private int mediaSets;
    private int mediaJuegos;
    //private CategoriaDTO categoria;
    private CategoriaBasicDTO categoria;

    // Constructor vacío
    public TeamDTO() {}

    public TeamDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Constructor completo
    public TeamDTO(Long id, String name, List<PlayerDTO> players, int puntos,
                   int partidosJugados, int victorias, int derrotas, int noJugado,
                   int noPresentado, int mediaSets, int mediaJuegos, CategoriaBasicDTO categoria) {
        this.id = id;
        this.name = name;
        this.players = players;
        this.puntos = puntos;
        this.partidosJugados = partidosJugados;
        this.victorias = victorias;
        this.derrotas = derrotas;
        this.noJugado = noJugado;
        this.noPresentado = noPresentado;
        this.mediaSets = mediaSets;
        this.mediaJuegos = mediaJuegos;
        this.categoria = categoria;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<PlayerDTO> getPlayers() { return players; }
    public void setPlayers(List<PlayerDTO> players) { this.players = players; }

    public int getPuntos() { return puntos; }
    public void setPuntos(int puntos) { this.puntos = puntos; }

    public int getPartidosJugados() { return partidosJugados; }
    public void setPartidosJugados(int partidosJugados) { this.partidosJugados = partidosJugados; }

    public int getVictorias() { return victorias; }
    public void setVictorias(int victorias) { this.victorias = victorias; }

    public int getDerrotas() { return derrotas; }
    public void setDerrotas(int derrotas) { this.derrotas = derrotas; }

    public int getNoJugado() { return noJugado; }
    public void setNoJugado(int noJugado) { this.noJugado = noJugado; }

    public int getNoPresentado() { return noPresentado; }
    public void setNoPresentado(int noPresentado) { this.noPresentado = noPresentado; }

    public int getMediaSets() { return mediaSets; }
    public void setMediaSets(int mediaSets) { this.mediaSets = mediaSets; }

    public int getMediaJuegos() { return mediaJuegos; }
    public void setMediaJuegos(int mediaJuegos) { this.mediaJuegos = mediaJuegos; }

    public CategoriaBasicDTO getCategoria() { return categoria; }
    public void setCategoria(CategoriaBasicDTO categoria) { this.categoria = categoria; }
}