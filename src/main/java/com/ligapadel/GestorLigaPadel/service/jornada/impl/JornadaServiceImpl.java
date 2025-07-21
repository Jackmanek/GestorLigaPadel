package com.ligapadel.GestorLigaPadel.service.jornada.impl;

import com.ligapadel.GestorLigaPadel.dto.request.jornada.JornadaCreateDTO;
import com.ligapadel.GestorLigaPadel.dto.request.jornada.JornadaDTO;
import com.ligapadel.GestorLigaPadel.entity.Jornada;
import com.ligapadel.GestorLigaPadel.mapper.jornada.JornadaMapper;
import com.ligapadel.GestorLigaPadel.repository.FaseRepository;
import com.ligapadel.GestorLigaPadel.repository.JornadaRepository;
import com.ligapadel.GestorLigaPadel.service.jornada.JornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JornadaServiceImpl implements JornadaService {
    @Autowired
    private JornadaRepository jornadaRepository;
    @Autowired
    private JornadaMapper jornadaMapper;
    @Autowired
    private FaseRepository faseRepository;

    public List<JornadaDTO> findAll() {
        return jornadaRepository.findAll().stream()
                .map(jornadaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public JornadaDTO create(JornadaCreateDTO dto) {
        Jornada j = new Jornada();
        j.setNumJornada(dto.getNumJornada());
        j.setFase(faseRepository.findById(dto.getFaseId()).orElse(null));
        return jornadaMapper.toDTO(jornadaRepository.save(j));
    }

    public JornadaDTO getById(Long id) {
        return jornadaRepository.findById(id).map(jornadaMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Jornada no encontrada"));
    }

    public void delete(Long id) {
        jornadaRepository.deleteById(id);
    }
}
