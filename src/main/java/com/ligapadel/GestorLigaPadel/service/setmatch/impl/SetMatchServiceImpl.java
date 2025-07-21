package com.ligapadel.GestorLigaPadel.service.setmatch.impl;

import com.ligapadel.GestorLigaPadel.dto.request.setmatch.SetMatchCreateDTO;
import com.ligapadel.GestorLigaPadel.dto.request.setmatch.SetMatchDTO;
import com.ligapadel.GestorLigaPadel.entity.SetMatch;
import com.ligapadel.GestorLigaPadel.repository.MatchRepository;
import com.ligapadel.GestorLigaPadel.repository.SetMatchRepository;
import com.ligapadel.GestorLigaPadel.service.setmatch.SetMatchService;
import com.ligapadel.GestorLigaPadel.mapper.setmatch.SetMatchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SetMatchServiceImpl implements SetMatchService {
    @Autowired
    private SetMatchRepository setMatchRepository;
    @Autowired
    private MatchRepository matchRepository;
    @Autowired
    private SetMatchMapper setMatchMapper;

    public List<SetMatchDTO> findAll() {
        return setMatchRepository.findAll().stream().map(setMatchMapper::toDTO).collect(Collectors.toList());
    }

    public SetMatchDTO getById(Long id) {
        return setMatchRepository.findById(id)
                .map(setMatchMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("SetMatch no encontrado"));
    }

    public SetMatchDTO create(SetMatchCreateDTO dto) {
        SetMatch set = new SetMatch();
        set.setNumSet(dto.getNumSet());
        set.setGameLocal(dto.getGameLocal());
        set.setGameVisit(dto.getGameVisit());
        set.setMatch(matchRepository.findById(dto.getMatchId()).orElse(null));
        return setMatchMapper.toDTO(setMatchRepository.save(set));
    }

    public void delete(Long id) {
        setMatchRepository.deleteById(id);
    }
}
