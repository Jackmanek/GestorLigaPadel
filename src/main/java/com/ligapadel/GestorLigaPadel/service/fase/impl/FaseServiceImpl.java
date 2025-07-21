package com.ligapadel.GestorLigaPadel.service.fase.impl;

import com.ligapadel.GestorLigaPadel.dto.request.fase.FaseCreateDTO;
import com.ligapadel.GestorLigaPadel.dto.request.fase.FaseDTO;
import com.ligapadel.GestorLigaPadel.dto.request.fase.FaseSummaryDTO;
import com.ligapadel.GestorLigaPadel.dto.request.fase.FaseUpdateDTO;
import com.ligapadel.GestorLigaPadel.entity.Fase;
import com.ligapadel.GestorLigaPadel.entity.Temporada;
import com.ligapadel.GestorLigaPadel.mapper.fase.FaseMapper;
import com.ligapadel.GestorLigaPadel.repository.FaseRepository;
import com.ligapadel.GestorLigaPadel.repository.TemporadaRepository;
import com.ligapadel.GestorLigaPadel.service.fase.FaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class FaseServiceImpl implements FaseService {
    @Autowired
    private FaseRepository faseRepository;

    @Autowired
    private TemporadaRepository temporadaRepository;

    @Autowired
    private FaseMapper faseMapper;

    @Override
    public List<FaseDTO> getAllFases() {
        return faseRepository.findAll().stream()
                .map(faseMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<FaseSummaryDTO> getAllFaseSummaries() {
        return faseRepository.findAll().stream()
                .map(faseMapper::toSummaryDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<FaseDTO> getFaseById(Long id) {
        return faseRepository.findById(id)
                .map(faseMapper::toDTO);
    }

    @Override
    public FaseDTO createFase(FaseCreateDTO dto) {
        Fase fase = new Fase();
        fase.setNombre(dto.getNombre());
        fase.setOrden(dto.getOrden());

        if (dto.getTemporadaId() != null) {
            Temporada temporada = temporadaRepository.findById(dto.getTemporadaId())
                    .orElseThrow(() -> new IllegalArgumentException("Temporada no encontrada"));
            fase.setTemporada(temporada);
        }

        return faseMapper.toDTO(faseRepository.save(fase));
    }

    @Override
    public FaseDTO updateFase(Long id, FaseUpdateDTO dto) {
        Fase fase = faseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Fase no encontrada"));

        fase.setNombre(dto.getNombre());
        fase.setOrden(dto.getOrden());

        if (dto.getTemporadaId() != null) {
            Temporada temporada = temporadaRepository.findById(dto.getTemporadaId())
                    .orElseThrow(() -> new IllegalArgumentException("Temporada no encontrada"));
            fase.setTemporada(temporada);
        }

        return faseMapper.toDTO(faseRepository.save(fase));
    }

    @Override
    public void deleteFase(Long id) {
        if (!faseRepository.existsById(id)) {
            throw new IllegalArgumentException("Fase no encontrada");
        }
        faseRepository.deleteById(id);
    }
}
