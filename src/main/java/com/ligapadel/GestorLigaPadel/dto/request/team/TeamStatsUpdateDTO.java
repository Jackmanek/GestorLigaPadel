package com.ligapadel.GestorLigaPadel.dto.request.team;

public class TeamStatsUpdateDTO {
    private int puntos;
    private int partidosJugados;
    private int victorias;
    private int derrotas;
    private int noJugado;
    private int noPresentado;
    private int mediaSets;
    private int mediaJuegos;

    // Constructor vacío
    public TeamStatsUpdateDTO() {}

    // Constructor completo
    public TeamStatsUpdateDTO(int puntos, int partidosJugados, int victorias,
                              int derrotas, int noJugado, int noPresentado,
                              int mediaSets, int mediaJuegos) {
        this.puntos = puntos;
        this.partidosJugados = partidosJugados;
        this.victorias = victorias;
        this.derrotas = derrotas;
        this.noJugado = noJugado;
        this.noPresentado = noPresentado;
        this.mediaSets = mediaSets;
        this.mediaJuegos = mediaJuegos;
    }

    // Getters y Setters
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
}
