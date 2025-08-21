package com.ligapadel.GestorLigaPadel.mapper.team;

import com.ligapadel.GestorLigaPadel.dto.request.team.TeamCreateDTO;
import com.ligapadel.GestorLigaPadel.dto.request.team.TeamDTO;
import com.ligapadel.GestorLigaPadel.dto.request.team.TeamSummaryDTO;
import com.ligapadel.GestorLigaPadel.entity.Categoria;
import com.ligapadel.GestorLigaPadel.entity.Player;
import com.ligapadel.GestorLigaPadel.entity.Team;
import com.ligapadel.GestorLigaPadel.mapper.categoria.CategoriaMapper;
import com.ligapadel.GestorLigaPadel.mapper.player.PlayerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TeamMapper {

    @Autowired
    private PlayerMapper playerMapper;

    @Autowired
    private CategoriaMapper categoriaMapper;

    public TeamDTO toDTO(Team team) {
        if (team == null) {
            return null;
        }

        TeamDTO dto = new TeamDTO();
        dto.setId(team.getId());
        dto.setName(team.getName());
        dto.setPuntos(team.getPuntos());
        dto.setPartidosJugados(team.getPartidosJugados());
        dto.setVictorias(team.getVictorias());
        dto.setDerrotas(team.getDerrotas());
        dto.setNoJugado(team.getNoJugado());
        dto.setNoPresentado(team.getNoPresentado());
        dto.setMediaSets(team.getMediaSets());
        dto.setMediaJuegos(team.getMediaJuegos());

        // Mapear jugadores
        if (team.getPlayers() != null) {
            dto.setPlayers(team.getPlayers().stream()
                    .map(playerMapper::toDTO)
                    .collect(Collectors.toList()));
        }

        // Mapear categoría
        if (team.getCategoria() != null) {
            dto.setCategoria(categoriaMapper.toBasicDTO(team.getCategoria()));
        }

        return dto;
    }

    public TeamSummaryDTO toSummaryDTO(Team team) {
        if (team == null) {
            return null;
        }

        return new TeamSummaryDTO(
                team.getId(),
                team.getName(),
                team.getPuntos(),
                team.getPartidosJugados(),
                team.getVictorias(),
                team.getDerrotas(),
                team.getCategoria() != null ? team.getCategoria().getNombre() : null
        );
    }

    public Team toEntity(TeamCreateDTO createDTO, Categoria categoria, List<Player> players) {
        if (createDTO == null) {
            return null;
        }

        Team team = new Team();
        team.setName(createDTO.getName());
        team.setCategoria(categoria);
        team.setPlayers(players != null ? players : new ArrayList<>());
        team.setPuntos(0);
        team.setPartidosJugados(0);
        team.setVictorias(0);
        team.setDerrotas(0);
        team.setNoJugado(0);
        team.setNoPresentado(0);
        team.setMediaSets(0);
        team.setMediaJuegos(0);

        return team;
    }
}
