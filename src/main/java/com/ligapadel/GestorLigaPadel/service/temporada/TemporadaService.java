package com.ligapadel.GestorLigaPadel.service.temporada;

import com.ligapadel.GestorLigaPadel.dto.request.temporada.TemporadaCreateDTO;
import com.ligapadel.GestorLigaPadel.dto.request.temporada.TemporadaDTO;
import com.ligapadel.GestorLigaPadel.dto.request.temporada.TemporadaSummaryDTO;
import com.ligapadel.GestorLigaPadel.dto.request.temporada.TemporadaUpdateDTO;

import java.util.List;
import java.util.Optional;

public interface TemporadaService {

    List<TemporadaDTO> getAllTemporadas();
    List<TemporadaSummaryDTO> getAllTemporadasSummary();
    Optional<TemporadaDTO> getTemporadaById(Long id);
    TemporadaDTO createTemporada(TemporadaCreateDTO dto);
    TemporadaDTO updateTemporada(Long id, TemporadaUpdateDTO dto);
    void deleteTemporada(Long id);
}
