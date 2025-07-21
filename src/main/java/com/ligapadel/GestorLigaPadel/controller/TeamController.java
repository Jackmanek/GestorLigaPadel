package com.ligapadel.GestorLigaPadel.controller;

import com.ligapadel.GestorLigaPadel.dto.request.team.*;
import com.ligapadel.GestorLigaPadel.service.team.TeamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/teams")
@CrossOrigin(origins = "*")
public class TeamController {

    @Autowired
    private TeamService teamService;

    // GET /api/teams - Obtener todos los equipos
    @GetMapping
    public ResponseEntity<List<TeamDTO>> getAllTeams() {
        try {
            List<TeamDTO> teams = teamService.getAllTeams();
            return ResponseEntity.ok(teams);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // GET /api/teams/summary - Obtener resumen de todos los equipos
    @GetMapping("/summary")
    public ResponseEntity<List<TeamSummaryDTO>> getAllTeamsSummary() {
        try {
            List<TeamSummaryDTO> teams = teamService.getAllTeamsSummary();
            return ResponseEntity.ok(teams);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // GET /api/teams/{id} - Obtener equipo por ID
    @GetMapping("/{id}")
    public ResponseEntity<TeamDTO> getTeamById(@PathVariable Long id) {
        try {
            Optional<TeamDTO> team = teamService.getTeamById(id);
            return team.map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // GET /api/teams/categoria/{categoriaId} - Obtener equipos por categoría
    @GetMapping("/categoria/{categoriaId}")
    public ResponseEntity<List<TeamDTO>> getTeamsByCategoria(@PathVariable Long categoriaId) {
        try {
            List<TeamDTO> teams = teamService.getTeamsByCategoria(categoriaId);
            return ResponseEntity.ok(teams);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // GET /api/teams/ranking - Obtener equipos ordenados por puntos
    @GetMapping("/ranking")
    public ResponseEntity<List<TeamDTO>> getTeamsByPuntos() {
        try {
            List<TeamDTO> teams = teamService.getTeamsByPuntos();
            return ResponseEntity.ok(teams);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // POST /api/teams - Crear nuevo equipo
    @PostMapping
    public ResponseEntity<TeamDTO> createTeam(@Valid @RequestBody TeamCreateDTO teamCreateDTO) {
        try {
            TeamDTO createdTeam = teamService.createTeam(teamCreateDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdTeam);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // PUT /api/teams/{id} - Actualizar equipo completo
    @PutMapping("/{id}")
    public ResponseEntity<TeamDTO> updateTeam(@PathVariable Long id,
                                              @Valid @RequestBody TeamUpdateDTO teamUpdateDTO) {
        try {
            TeamDTO updatedTeam = teamService.updateTeam(id, teamUpdateDTO);
            return ResponseEntity.ok(updatedTeam);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // PATCH /api/teams/{id}/stats - Actualizar solo estadísticas del equipo
    @PatchMapping("/{id}/stats")
    public ResponseEntity<TeamDTO> updateTeamStats(@PathVariable Long id,
                                                   @RequestBody TeamStatsUpdateDTO statsDTO) {
        try {
            TeamDTO updatedTeam = teamService.updateTeamStats(
                    id,
                    statsDTO.getPuntos(),
                    statsDTO.getPartidosJugados(),
                    statsDTO.getVictorias(),
                    statsDTO.getDerrotas(),
                    statsDTO.getNoJugado(),
                    statsDTO.getNoPresentado(),
                    statsDTO.getMediaSets(),
                    statsDTO.getMediaJuegos()
            );
            return ResponseEntity.ok(updatedTeam);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // DELETE /api/teams/{id} - Eliminar equipo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeam(@PathVariable Long id) {
        try {
            teamService.deleteTeam(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // GET /api/teams/exists/{name} - Verificar si existe un equipo con ese nombre
    @GetMapping("/exists/{name}")
    public ResponseEntity<Boolean> existsTeamByName(@PathVariable String name) {
        try {
            boolean exists = teamService.existsTeamByName(name);
            return ResponseEntity.ok(exists);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // POST /api/teams/batch - Crear múltiples equipos
    @PostMapping("/batch")
    public ResponseEntity<List<TeamDTO>> createTeams(@Valid @RequestBody List<TeamCreateDTO> teamsCreateDTO) {
        try {
            List<TeamDTO> createdTeams = teamsCreateDTO.stream()
                    .map(teamService::createTeam)
                    .collect(java.util.stream.Collectors.toList());
            return ResponseEntity.status(HttpStatus.CREATED).body(createdTeams);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
