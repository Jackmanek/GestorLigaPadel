package com.ligapadel.GestorLigaPadel.dto.request.match;

import java.time.LocalDateTime;

public class MatchCreateDTO {
    private Long localTeamId;
    private Long visitorTeamId;
    private Long jornadaId;
    private boolean finalizado;
    private LocalDateTime fecha;

    public MatchCreateDTO() {}

    public MatchCreateDTO(Long localTeamId, Long visitorTeamId, Long jornadaId, boolean finalizado, LocalDateTime fecha) {
        this.localTeamId = localTeamId;
        this.visitorTeamId = visitorTeamId;
        this.jornadaId = jornadaId;
        this.finalizado = finalizado;
        this.fecha = fecha;
    }

    public Long getLocalTeamId() {
        return localTeamId;
    }

    public void setLocalTeamId(Long localTeamId) {
        this.localTeamId = localTeamId;
    }

    public Long getVisitorTeamId() {
        return visitorTeamId;
    }

    public void setVisitorTeamId(Long visitorTeamId) {
        this.visitorTeamId = visitorTeamId;
    }

    public Long getJornadaId() {
        return jornadaId;
    }

    public void setJornadaId(Long jornadaId) {
        this.jornadaId = jornadaId;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}
