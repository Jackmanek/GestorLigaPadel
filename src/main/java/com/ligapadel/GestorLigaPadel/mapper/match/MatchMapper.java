package com.ligapadel.GestorLigaPadel.mapper.match;

import com.ligapadel.GestorLigaPadel.dto.request.match.MatchDTO;
import com.ligapadel.GestorLigaPadel.entity.Match;
import org.springframework.stereotype.Component;

@Component
public class MatchMapper {
    public MatchDTO toDTO(Match match) {
        MatchDTO dto = new MatchDTO();
        dto.setId(match.getId());
        dto.setLocalTeamId(match.getLocal() != null ? match.getLocal().getId() : null);
        dto.setVisitorTeamId(match.getVisitor() != null ? match.getVisitor().getId() : null);
        dto.setJornadaId(match.getJornada() != null ? match.getJornada().getId() : null);
        dto.setFinalizado(match.isFinalizado());
        dto.setFecha(match.getFecha());
        return dto;
    }
}
