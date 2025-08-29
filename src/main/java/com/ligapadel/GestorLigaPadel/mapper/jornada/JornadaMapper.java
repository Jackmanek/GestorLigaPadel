package com.ligapadel.GestorLigaPadel.mapper.jornada;

import com.ligapadel.GestorLigaPadel.dto.request.fase.FaseDTO;
import com.ligapadel.GestorLigaPadel.dto.request.jornada.JornadaDTO;
import com.ligapadel.GestorLigaPadel.dto.request.match.MatchBasicDTO;
import com.ligapadel.GestorLigaPadel.dto.request.match.MatchDTO;
import com.ligapadel.GestorLigaPadel.dto.request.team.TeamBasicDTO;
import com.ligapadel.GestorLigaPadel.dto.request.team.TeamDTO;
import com.ligapadel.GestorLigaPadel.dto.request.temporada.TemporadaDTO;
import com.ligapadel.GestorLigaPadel.entity.Categoria;
import com.ligapadel.GestorLigaPadel.entity.Fase;
import com.ligapadel.GestorLigaPadel.entity.Jornada;
import com.ligapadel.GestorLigaPadel.entity.Team;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JornadaMapper {

    public JornadaDTO toDTO(Jornada jornada) {
        Fase fase = jornada.getFase();
        List<MatchBasicDTO> matchDTOList = jornada.getMatches().stream()
                .map(m -> new MatchBasicDTO(
                        m.getId(),
                        new TeamBasicDTO(m.getLocal().getId(), m.getLocal().getName(), m.getLocal().getCategoria()),
                        new TeamBasicDTO(m.getVisitor().getId(), m.getVisitor().getName(), m.getVisitor().getCategoria()),
                        m.isFinalizado()
                ))
                .toList();

        return new JornadaDTO(
                jornada.getId(),
                jornada.getNumJornada(),
                new FaseDTO(
                        fase.getId(),
                        fase.getNombre(),
                        fase.getOrden(),
                        fase.getTemporada() != null ? new TemporadaDTO(fase.getTemporada().getId(), fase.getTemporada().getNombre()) : null,
                        fase.getJornadas().stream().map(Jornada::getId).toList(),
                        fase.getTeams().stream().map(Team::getId).toList(),
                        fase.getCategorias().stream().map(Categoria::getId).toList()
                        ),
                matchDTOList
        );

    }



}
