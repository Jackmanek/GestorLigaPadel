package com.ligapadel.GestorLigaPadel.mapper.fase;

import com.ligapadel.GestorLigaPadel.dto.request.fase.FaseDTO;
import com.ligapadel.GestorLigaPadel.dto.request.fase.FaseSummaryDTO;

import com.ligapadel.GestorLigaPadel.dto.request.temporada.TemporadaDTO;

import com.ligapadel.GestorLigaPadel.entity.Fase;
import com.ligapadel.GestorLigaPadel.entity.Categoria;
import com.ligapadel.GestorLigaPadel.entity.Jornada;
import com.ligapadel.GestorLigaPadel.entity.Team;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class FaseMapper {

    public FaseDTO toDTO(Fase fase) {
        return new FaseDTO(
                fase.getId(),
                fase.getNombre(),
                fase.getOrden(),
                fase.getTemporada() != null ? new TemporadaDTO(fase.getTemporada().getId(), fase.getTemporada().getNombre()) : null,
                fase.getJornadas() != null ? fase.getJornadas().stream().map(Jornada::getId).collect(Collectors.toList()) : null,
                fase.getTeams() != null ? fase.getTeams().stream().map(Team::getId).collect(Collectors.toList()) : null,
                fase.getCategorias() != null ? fase.getCategorias().stream().map(Categoria::getId).collect(Collectors.toList()) : null
        );
    }

    public FaseSummaryDTO toSummaryDTO(Fase fase) {
        return new FaseSummaryDTO(
                fase.getId(),
                fase.getNombre(),
                fase.getOrden(),
                fase.getTemporada() != null ? fase.getTemporada().getNombre() : null
        );
    }
}
