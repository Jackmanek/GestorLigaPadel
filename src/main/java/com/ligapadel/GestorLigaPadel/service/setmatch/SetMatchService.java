package com.ligapadel.GestorLigaPadel.service.setmatch;

import com.ligapadel.GestorLigaPadel.dto.request.setmatch.SetMatchCreateDTO;
import com.ligapadel.GestorLigaPadel.dto.request.setmatch.SetMatchDTO;

import java.util.List;

public interface SetMatchService {
    List<SetMatchDTO> findAll();
    SetMatchDTO getById(Long id);
    SetMatchDTO create(SetMatchCreateDTO dto);
    void delete(Long id);
}
