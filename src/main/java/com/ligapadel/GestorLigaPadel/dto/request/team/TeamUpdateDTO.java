package com.ligapadel.GestorLigaPadel.dto.request.team;

public class TeamUpdateDTO {
    private String name;
    private int puntos;
    private int partidosJugados;
    private int victorias;
    private int derrotas;
    private int noJugado;
    private int noPresentado;
    private int mediaSets;
    private int mediaJuegos;
    private Long categoriaId;

    // Constructor vacío
    public TeamUpdateDTO() {}

    // Getters y Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

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

    public Long getCategoriaId() { return categoriaId; }
    public void setCategoriaId(Long categoriaId) { this.categoriaId = categoriaId; }
}
