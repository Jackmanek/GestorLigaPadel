package com.ligapadel.GestorLigaPadel.service.fase;

import com.ligapadel.GestorLigaPadel.dto.request.fase.FaseCreateDTO;
import com.ligapadel.GestorLigaPadel.dto.request.fase.FaseDTO;
import com.ligapadel.GestorLigaPadel.dto.request.fase.FaseSummaryDTO;
import com.ligapadel.GestorLigaPadel.dto.request.fase.FaseUpdateDTO;

import java.util.List;
import java.util.Optional;

public interface FaseService {
    List<FaseDTO> getAllFases();
    List<FaseSummaryDTO> getAllFaseSummaries();
    Optional<FaseDTO> getFaseById(Long id);
    FaseDTO createFase(FaseCreateDTO dto);
    FaseDTO updateFase(Long id, FaseUpdateDTO dto);
    void deleteFase(Long id);
}
