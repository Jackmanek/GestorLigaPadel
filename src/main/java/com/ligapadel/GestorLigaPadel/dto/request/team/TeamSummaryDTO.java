package com.ligapadel.GestorLigaPadel.dto.request.team;

public class TeamSummaryDTO {
    private Long id;
    private String name;
    private int puntos;
    private int partidosJugados;
    private int victorias;
    private int derrotas;
    private String categoriaNombre;

    // Constructor vacío
    public TeamSummaryDTO() {}

    // Constructor
    public TeamSummaryDTO(Long id, String name, int puntos, int partidosJugados,
                          int victorias, int derrotas, String categoriaNombre) {
        this.id = id;
        this.name = name;
        this.puntos = puntos;
        this.partidosJugados = partidosJugados;
        this.victorias = victorias;
        this.derrotas = derrotas;
        this.categoriaNombre = categoriaNombre;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

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

    public String getCategoriaNombre() { return categoriaNombre; }
    public void setCategoriaNombre(String categoriaNombre) { this.categoriaNombre = categoriaNombre; }
}
