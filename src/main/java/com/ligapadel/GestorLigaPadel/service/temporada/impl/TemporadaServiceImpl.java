package com.ligapadel.GestorLigaPadel.service.temporada.impl;


import com.ligapadel.GestorLigaPadel.dto.request.temporada.TemporadaCreateDTO;
import com.ligapadel.GestorLigaPadel.dto.request.temporada.TemporadaDTO;
import com.ligapadel.GestorLigaPadel.dto.request.temporada.TemporadaSummaryDTO;
import com.ligapadel.GestorLigaPadel.dto.request.temporada.TemporadaUpdateDTO;
import com.ligapadel.GestorLigaPadel.entity.Fase;
import com.ligapadel.GestorLigaPadel.entity.Temporada;
import com.ligapadel.GestorLigaPadel.mapper.temporada.TemporadaMapper;
import com.ligapadel.GestorLigaPadel.repository.TemporadaRepository;
import com.ligapadel.GestorLigaPadel.service.temporada.TemporadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class TemporadaServiceImpl implements TemporadaService {

    @Autowired
    private TemporadaRepository temporadaRepository;

    @Autowired
    private TemporadaMapper temporadaMapper;

    @Override
    public List<TemporadaDTO> getAllTemporadas() {
        return temporadaRepository.findAll().stream()
                .map(temporadaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<TemporadaSummaryDTO> getAllTemporadasSummary() {
        return temporadaRepository.findAll().stream()
                .map(temporadaMapper::toSummaryDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<TemporadaDTO> getTemporadaById(Long id) {
        return temporadaRepository.findById(id)
                .map(temporadaMapper::toDTO);
    }

    @Override
    public TemporadaDTO createTemporada(TemporadaCreateDTO dto) {
        Temporada temporada = new Temporada();
        temporada.setNombre(dto.getNombre());
        return temporadaMapper.toDTO(temporadaRepository.save(temporada));
    }

    @Override
    public TemporadaDTO updateTemporada(Long id, TemporadaUpdateDTO dto) {
        Temporada temporada = temporadaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Temporada no encontrada"));

        temporada.setNombre(dto.getNombre());
        return temporadaMapper.toDTO(temporadaRepository.save(temporada));
    }

    @Override
    public void deleteTemporada(Long id) {
        if (!temporadaRepository.existsById(id)) {
            throw new IllegalArgumentException("Temporada no encontrada");
        }
        temporadaRepository.deleteById(id);
    }
}
