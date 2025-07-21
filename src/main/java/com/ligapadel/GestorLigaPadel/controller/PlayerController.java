package com.ligapadel.GestorLigaPadel.controller;

import com.ligapadel.GestorLigaPadel.dto.request.player.PlayerCreateDTO;
import com.ligapadel.GestorLigaPadel.dto.request.player.PlayerDTO;
import com.ligapadel.GestorLigaPadel.dto.request.player.PlayerSummaryDTO;
import com.ligapadel.GestorLigaPadel.dto.request.player.PlayerUpdateDTO;
import com.ligapadel.GestorLigaPadel.service.player.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping
    public List<PlayerDTO> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/summary")
    public List<PlayerSummaryDTO> getAllPlayerSummaries() {
        return playerService.getAllPlayerSummaries();
    }

    @GetMapping("/{id}")
    public PlayerDTO getPlayerById(@PathVariable Long id) {
        return playerService.getPlayerById(id)
                .orElseThrow(() -> new IllegalArgumentException("Jugador no encontrado"));
    }

    @PostMapping
    public PlayerDTO createPlayer(@RequestBody PlayerCreateDTO dto) {
        return playerService.createPlayer(dto);
    }

    @PutMapping("/{id}")
    public PlayerDTO updatePlayer(@PathVariable Long id, @RequestBody PlayerUpdateDTO dto) {
        return playerService.updatePlayer(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable Long id) {
        playerService.deletePlayer(id);
    }
}
