package com.ligapadel.GestorLigaPadel.service.player.impl;

import com.ligapadel.GestorLigaPadel.dto.request.player.PlayerCreateDTO;
import com.ligapadel.GestorLigaPadel.dto.request.player.PlayerDTO;
import com.ligapadel.GestorLigaPadel.dto.request.player.PlayerSummaryDTO;
import com.ligapadel.GestorLigaPadel.dto.request.player.PlayerUpdateDTO;
import com.ligapadel.GestorLigaPadel.entity.Player;
import com.ligapadel.GestorLigaPadel.entity.Team;
import com.ligapadel.GestorLigaPadel.entity.User;
import com.ligapadel.GestorLigaPadel.mapper.player.PlayerMapper;
import com.ligapadel.GestorLigaPadel.repository.PlayerRepository;
import com.ligapadel.GestorLigaPadel.repository.TeamRepository;
import com.ligapadel.GestorLigaPadel.repository.UserRepository;
import com.ligapadel.GestorLigaPadel.service.player.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PlayerMapper playerMapper;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<PlayerDTO> getAllPlayers() {
        return playerRepository.findAll().stream()
                .map(playerMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PlayerSummaryDTO> getAllPlayerSummaries() {
        return playerRepository.findAll().stream()
                .map(playerMapper::toSummaryDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PlayerDTO> getPlayerById(Long id) {
        return playerRepository.findById(id)
                .map(playerMapper::toDTO);
    }

    @Override
    public PlayerDTO createPlayer(PlayerCreateDTO dto) {
        Player player = new Player();
        player.setName(dto.getName());
        player.setSurname(dto.getSurname());
        player.setAge(dto.getAge());
        player.setGender(dto.getGender());
        player.setImgUrl(dto.getImgUrl());
        player.setDataContact(dto.getDataContact());
        player.setCreatedAt(LocalDateTime.now());

        if (dto.getTeamId() != null) {
            Team team = teamRepository.findById(dto.getTeamId())
                    .orElseThrow(() -> new IllegalArgumentException("Equipo no encontrado"));
            player.setTeam(team);
        }

        if (dto.getUserId() != null) {
            User user = userRepository.findById(dto.getUserId())
                    .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
            player.setUser(user);
        }

        return playerMapper.toDTO(playerRepository.save(player));
    }

    @Override
    public PlayerDTO updatePlayer(Long id, PlayerUpdateDTO dto) {
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Jugador no encontrado"));

        player.setName(dto.getName());
        player.setSurname(dto.getSurname());
        player.setAge(dto.getAge());
        player.setGender(dto.getGender());
        player.setImgUrl(dto.getImgUrl());

        if (dto.getTeamId() != null) {
            Team team = teamRepository.findById(dto.getTeamId())
                    .orElseThrow(() -> new IllegalArgumentException("Equipo no encontrado"));
            player.setTeam(team);
        }

        return playerMapper.toDTO(playerRepository.save(player));
    }

    @Override
    public void deletePlayer(Long id) {
        if (!playerRepository.existsById(id)) {
            throw new IllegalArgumentException("Jugador no encontrado");
        }
        playerRepository.deleteById(id);
    }
}
