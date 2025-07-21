package com.ligapadel.GestorLigaPadel.mapper.player;

import com.ligapadel.GestorLigaPadel.dto.request.player.PlayerDTO;
import com.ligapadel.GestorLigaPadel.dto.request.player.PlayerSummaryDTO;
import com.ligapadel.GestorLigaPadel.entity.Player;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PlayerMapper {


    public PlayerDTO toDTO(Player player) {
        PlayerDTO dto = new PlayerDTO();
        dto.setId(player.getId());
        dto.setName(player.getName());
        dto.setSurname(player.getSurname());
        dto.setAge(player.getAge());
        dto.setGender(player.getGender());
        dto.setImgUrl(player.getImgUrl());
        dto.setCreatedAt(player.getCreatedAt());
        dto.setTeamId(player.getTeam() != null ? player.getTeam().getId() : null);
        dto.setUserId(player.getUser() != null ? player.getUser().getId() : null);
        return dto;
    }

    public PlayerSummaryDTO toSummaryDTO(Player player) {
        PlayerSummaryDTO summary = new PlayerSummaryDTO();
        summary.setId(player.getId());
        summary.setFullName(player.getName() + " " + player.getSurname());
        summary.setGender(player.getGender());
        summary.setTeamId(player.getTeam() != null ? player.getTeam().getId() : null);
        return summary;
    }
}
