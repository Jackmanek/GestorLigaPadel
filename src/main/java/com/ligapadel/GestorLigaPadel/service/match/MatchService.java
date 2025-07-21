package com.ligapadel.GestorLigaPadel.service.match;

import com.ligapadel.GestorLigaPadel.dto.request.match.MatchCreateDTO;
import com.ligapadel.GestorLigaPadel.dto.request.match.MatchDTO;

import java.util.List;

public interface MatchService {
    List<MatchDTO> findAll();
    MatchDTO getById(Long id);
    MatchDTO create(MatchCreateDTO dto);
    void delete(Long id);
}
