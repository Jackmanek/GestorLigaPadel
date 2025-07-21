package com.ligapadel.GestorLigaPadel.service.team;

import com.ligapadel.GestorLigaPadel.dto.request.team.TeamCreateDTO;
import com.ligapadel.GestorLigaPadel.dto.request.team.TeamDTO;
import com.ligapadel.GestorLigaPadel.dto.request.team.TeamSummaryDTO;
import com.ligapadel.GestorLigaPadel.dto.request.team.TeamUpdateDTO;

import java.util.List;
import java.util.Optional;

public interface TeamService {
    List<TeamDTO> getAllTeams();
    List<TeamSummaryDTO> getAllTeamsSummary();
    Optional<TeamDTO> getTeamById(Long id);
    List<TeamDTO> getTeamsByCategoria(Long categoriaId);
    TeamDTO createTeam(TeamCreateDTO teamCreateDTO);
    TeamDTO updateTeam(Long id, TeamUpdateDTO teamUpdateDTO);
    void deleteTeam(Long id);
    TeamDTO updateTeamStats(Long id, int puntos, int partidosJugados,
                            int victorias, int derrotas, int noJugado,
                            int noPresentado, int mediaSets, int mediaJuegos);
    List<TeamDTO> getTeamsByPuntos();
    boolean existsTeamByName(String name);
    boolean existsTeamByNameAndDifferentId(String name, Long id);

}
