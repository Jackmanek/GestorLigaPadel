package com.ligapadel.GestorLigaPadel.dto.request.match;

import com.ligapadel.GestorLigaPadel.dto.request.team.TeamBasicDTO;
import com.ligapadel.GestorLigaPadel.entity.Categoria;

public class MatchBasicDTO {
    private Long id;
    private TeamBasicDTO local;
    private TeamBasicDTO visitor;
    private boolean finalizado;

    public MatchBasicDTO() {
    }

    public MatchBasicDTO(Long id, TeamBasicDTO local, TeamBasicDTO visitor, boolean finalizado) {
        this.id = id;
        this.local = local;
        this.visitor = visitor;
        this.finalizado = finalizado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TeamBasicDTO getLocal() {
        return local;
    }

    public void setLocal(TeamBasicDTO local) {
        this.local = local;
    }

    public TeamBasicDTO getVisitor() {
        return visitor;
    }

    public void setVisitor(TeamBasicDTO visitor) {
        this.visitor = visitor;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }
}
