package com.ligapadel.GestorLigaPadel.service.team.impl;

import com.ligapadel.GestorLigaPadel.dto.request.team.TeamCreateDTO;
import com.ligapadel.GestorLigaPadel.dto.request.team.TeamDTO;
import com.ligapadel.GestorLigaPadel.dto.request.team.TeamSummaryDTO;
import com.ligapadel.GestorLigaPadel.dto.request.team.TeamUpdateDTO;
import com.ligapadel.GestorLigaPadel.entity.Categoria;
import com.ligapadel.GestorLigaPadel.entity.Team;
import com.ligapadel.GestorLigaPadel.mapper.team.TeamMapper;
import com.ligapadel.GestorLigaPadel.repository.CategoriaRepository;
import com.ligapadel.GestorLigaPadel.repository.TeamRepository;
import com.ligapadel.GestorLigaPadel.service.team.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private TeamMapper teamMapper;

    @Override
    @Transactional(readOnly = true)
    public List<TeamDTO> getAllTeams() {
        List<Team> teams = teamRepository.findAll();
        return teams.stream()
                .map(teamMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<TeamSummaryDTO> getAllTeamsSummary() {
        List<Team> teams = teamRepository.findAll();
        return teams.stream()
                .map(teamMapper::toSummaryDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TeamDTO> getTeamById(Long id) {
        return teamRepository.findById(id)
                .map(teamMapper::toDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TeamDTO> getTeamsByCategoria(Long categoriaId) {
        List<Team> teams = teamRepository.findByCategoriaId(categoriaId);
        return teams.stream()
                .map(teamMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TeamDTO createTeam(TeamCreateDTO teamCreateDTO) {
        // Validar que no exista un equipo con el mismo nombre
        if (existsTeamByName(teamCreateDTO.getName())) {
            throw new IllegalArgumentException("Ya existe un equipo con ese nombre");
        }

        // Buscar la categoría
        Categoria categoria = categoriaRepository.findById(teamCreateDTO.getCategoriaId())
                .orElseThrow(() -> new IllegalArgumentException("Categoría no encontrada"));

        // Crear el equipo
        Team team = new Team();
        team.setName(teamCreateDTO.getName());
        team.setCategoria(categoria);
        team.setPuntos(0);
        team.setPartidosJugados(0);
        team.setVictorias(0);
        team.setDerrotas(0);
        team.setNoJugado(0);
        team.setNoPresentado(0);
        team.setMediaSets(0);
        team.setMediaJuegos(0);

        Team savedTeam = teamRepository.save(team);
        return teamMapper.toDTO(savedTeam);
    }

    @Override
    public TeamDTO updateTeam(Long id, TeamUpdateDTO teamUpdateDTO) {
        Team team = teamRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Equipo no encontrado"));

        // Validar nombre único si se está cambiando
        if (teamUpdateDTO.getName() != null &&
                !teamUpdateDTO.getName().equals(team.getName()) &&
                existsTeamByName(teamUpdateDTO.getName())) {
            throw new IllegalArgumentException("Ya existe un equipo con ese nombre");
        }

        // Actualizar campos
        if (teamUpdateDTO.getName() != null) {
            team.setName(teamUpdateDTO.getName());
        }

        team.setPuntos(teamUpdateDTO.getPuntos());
        team.setPartidosJugados(teamUpdateDTO.getPartidosJugados());
        team.setVictorias(teamUpdateDTO.getVictorias());
        team.setDerrotas(teamUpdateDTO.getDerrotas());
        team.setNoJugado(teamUpdateDTO.getNoJugado());
        team.setNoPresentado(teamUpdateDTO.getNoPresentado());
        team.setMediaSets(teamUpdateDTO.getMediaSets());
        team.setMediaJuegos(teamUpdateDTO.getMediaJuegos());

        // Actualizar categoría si se proporciona
        if (teamUpdateDTO.getCategoriaId() != null) {
            Categoria categoria = categoriaRepository.findById(teamUpdateDTO.getCategoriaId())
                    .orElseThrow(() -> new IllegalArgumentException("Categoría no encontrada"));
            team.setCategoria(categoria);
        }

        Team updatedTeam = teamRepository.save(team);
        return teamMapper.toDTO(updatedTeam);
    }

    @Override
    public void deleteTeam(Long id) {
        if (!teamRepository.existsById(id)) {
            throw new IllegalArgumentException("Equipo no encontrado");
        }
        teamRepository.deleteById(id);
    }

    @Override
    public TeamDTO updateTeamStats(Long id, int puntos, int partidosJugados,
                                   int victorias, int derrotas, int noJugado,
                                   int noPresentado, int mediaSets, int mediaJuegos) {
        Team team = teamRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Equipo no encontrado"));

        team.setPuntos(puntos);
        team.setPartidosJugados(partidosJugados);
        team.setVictorias(victorias);
        team.setDerrotas(derrotas);
        team.setNoJugado(noJugado);
        team.setNoPresentado(noPresentado);
        team.setMediaSets(mediaSets);
        team.setMediaJuegos(mediaJuegos);

        Team updatedTeam = teamRepository.save(team);
        return teamMapper.toDTO(updatedTeam);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TeamDTO> getTeamsByPuntos() {
        List<Team> teams = teamRepository.findAllByOrderByPuntosDesc();
        return teams.stream()
                .map(teamMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsTeamByName(String name) {
        return teamRepository.existsByName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsTeamByNameAndDifferentId(String name, Long id) {
        return teamRepository.existsByNameAndIdNot(name, id);
    }
}
