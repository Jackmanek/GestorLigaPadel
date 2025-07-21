package com.ligapadel.GestorLigaPadel.service.match.impl;

import com.ligapadel.GestorLigaPadel.dto.request.match.MatchCreateDTO;
import com.ligapadel.GestorLigaPadel.dto.request.match.MatchDTO;
import com.ligapadel.GestorLigaPadel.entity.Match;
import com.ligapadel.GestorLigaPadel.mapper.match.MatchMapper;
import com.ligapadel.GestorLigaPadel.repository.JornadaRepository;
import com.ligapadel.GestorLigaPadel.repository.MatchRepository;
import com.ligapadel.GestorLigaPadel.repository.TeamRepository;
import com.ligapadel.GestorLigaPadel.service.match.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatchServiceImpl implements MatchService {
    @Autowired
    private MatchRepository matchRepository;
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private JornadaRepository jornadaRepository;
    @Autowired
    private MatchMapper matchMapper;

    public List<MatchDTO> findAll() {
        return matchRepository.findAll().stream().map(matchMapper::toDTO).collect(Collectors.toList());
    }

    public MatchDTO getById(Long id) {
        return matchRepository.findById(id).map(matchMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Match no encontrado"));
    }

    public MatchDTO create(MatchCreateDTO dto) {
        Match match = new Match();
        match.setLocal(teamRepository.findById(dto.getLocalTeamId()).orElse(null));
        match.setVisitor(teamRepository.findById(dto.getVisitorTeamId()).orElse(null));
        match.setJornada(jornadaRepository.findById(dto.getJornadaId()).orElse(null));
        match.setFinalizado(dto.isFinalizado());
        match.setFecha(dto.getFecha());
        return matchMapper.toDTO(matchRepository.save(match));
    }

    public void delete(Long id) {
        matchRepository.deleteById(id);
    }
}

