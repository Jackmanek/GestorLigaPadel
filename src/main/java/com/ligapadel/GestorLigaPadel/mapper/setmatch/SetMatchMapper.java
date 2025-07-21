package com.ligapadel.GestorLigaPadel.mapper.setmatch;

import com.ligapadel.GestorLigaPadel.dto.request.setmatch.SetMatchDTO;
import com.ligapadel.GestorLigaPadel.entity.SetMatch;
import org.springframework.stereotype.Component;

@Component
public class SetMatchMapper {
    public SetMatchDTO toDTO(SetMatch setMatch) {
        SetMatchDTO dto = new SetMatchDTO();
        dto.setId(setMatch.getId());
        dto.setNumSet(setMatch.getNumSet());
        dto.setGameLocal(setMatch.getGameLocal());
        dto.setGameVisit(setMatch.getGameVisit());
        dto.setMatchId(setMatch.getMatch() != null ? setMatch.getMatch().getId() : null);
        return dto;
    }
}
