package com.ligapadel.GestorLigaPadel.mapper.jornada;

import com.ligapadel.GestorLigaPadel.dto.request.jornada.JornadaDTO;
import com.ligapadel.GestorLigaPadel.entity.Jornada;
import org.springframework.stereotype.Component;

@Component
public class JornadaMapper {
    public JornadaDTO toDTO(Jornada jornada) {
        JornadaDTO dto = new JornadaDTO();
        dto.setId(jornada.getId());
        dto.setNumJornada(jornada.getNumJornada());
        dto.setFaseId(jornada.getFase() != null ? jornada.getFase().getId() : null);
        return dto;
    }
}
