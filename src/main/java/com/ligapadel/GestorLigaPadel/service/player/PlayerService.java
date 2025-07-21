package com.ligapadel.GestorLigaPadel.service.player;

import com.ligapadel.GestorLigaPadel.dto.request.player.PlayerCreateDTO;
import com.ligapadel.GestorLigaPadel.dto.request.player.PlayerDTO;
import com.ligapadel.GestorLigaPadel.dto.request.player.PlayerSummaryDTO;
import com.ligapadel.GestorLigaPadel.dto.request.player.PlayerUpdateDTO;

import java.util.List;
import java.util.Optional;

public interface PlayerService {
    List<PlayerDTO> getAllPlayers();
    List<PlayerSummaryDTO> getAllPlayerSummaries();
    Optional<PlayerDTO> getPlayerById(Long id);
    PlayerDTO createPlayer(PlayerCreateDTO dto);
    PlayerDTO updatePlayer(Long id, PlayerUpdateDTO dto);
    void deletePlayer(Long id);
}
