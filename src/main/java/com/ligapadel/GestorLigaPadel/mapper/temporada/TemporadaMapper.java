package com.ligapadel.GestorLigaPadel.mapper.temporada;

import com.ligapadel.GestorLigaPadel.dto.request.temporada.TemporadaDTO;
import com.ligapadel.GestorLigaPadel.dto.request.temporada.TemporadaSummaryDTO;
import com.ligapadel.GestorLigaPadel.entity.Temporada;
import com.ligapadel.GestorLigaPadel.entity.Fase;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class TemporadaMapper {

    public TemporadaDTO toDTO(Temporada temporada) {
        return new TemporadaDTO(
                temporada.getId(),
                temporada.getNombre(),
                temporada.getFases() != null ?
                        temporada.getFases().stream().map(Fase::getId).collect(Collectors.toList()) :
                        null
        );
    }

    public TemporadaSummaryDTO toSummaryDTO(Temporada temporada) {
        return new TemporadaSummaryDTO(
                temporada.getId(),
                temporada.getNombre(),
                temporada.getFases() != null ? temporada.getFases().size() : 0
        );
    }
}
