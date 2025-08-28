package com.ligapadel.GestorLigaPadel.dto.request.jornada;

import com.ligapadel.GestorLigaPadel.dto.request.fase.FaseDTO;
import com.ligapadel.GestorLigaPadel.dto.request.match.MatchBasicDTO;
import com.ligapadel.GestorLigaPadel.dto.request.match.MatchDTO;

import java.util.List;

public class JornadaDTO {
    private Long id;
    private int numJornada;
    private FaseDTO fase;
    private List<MatchBasicDTO> matches;

    public JornadaDTO() {
    }

    public JornadaDTO(Long id, int numJornada, FaseDTO fase, List<MatchBasicDTO> matches) {
        this.id = id;
        this.numJornada = numJornada;
        this.fase = fase;
        this.matches = matches;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumJornada() {
        return numJornada;
    }

    public void setNumJornada(int numJornada) {
        this.numJornada = numJornada;
    }

    public FaseDTO getFase() {
        return fase;
    }

    public void setFase(FaseDTO fase) {
        this.fase = fase;
    }

    public List<MatchBasicDTO> getMatches() {
        return matches;
    }

    public void setMatches(List<MatchBasicDTO> matches) {
        this.matches = matches;
    }
}
