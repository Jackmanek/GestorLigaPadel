package com.ligapadel.GestorLigaPadel.mapper.player;

import com.ligapadel.GestorLigaPadel.entity.Player;
import com.ligapadel.GestorLigaPadel.entity.User;

public class PlayerMapper {

    public Player toEntity(CreatePlayerRequestDTO dto, User user) {
        Player player = new Player();
        player.setName(dto.getName());
        player.setSurname(dto.getSurname());
        player.setAge(dto.getAge());
        player.setGender(dto.getGender());
        player.setImgUrl(dto.getImgUrl());
        player.setUser(user);
        player.setCreatedAt(LocalDateTime.now());

        // Mapear datos de contacto
        DataContact contact = new DataContact();
        contact.setEmail(dto.getEmail());
        contact.setPhone(dto.getPhone());
        player.setDataContact(contact);

        return player;
    }

    public PlayerResponseDTO toResponseDTO(Player player) {
        PlayerResponseDTO dto = new PlayerResponseDTO();
        dto.setId(player.getId());
        dto.setName(player.getName());
        dto.setSurname(player.getSurname());
        dto.setAge(player.getAge());
        dto.setGender(player.getGender());
        dto.setImgUrl(player.getImgUrl());

        // Datos del usuario asociado
        dto.setUsername(player.getUser().getUsername());

        // Datos de contacto
        if (player.getDataContact() != null) {
            dto.setEmail(player.getDataContact().getEmail());
            dto.setPhone(player.getDataContact().getPhone());
        }

        // Datos del team (si tiene)
        if (player.getTeam() != null) {
            dto.setTeam(new TeamBasicDTO(player.getTeam()));
        }

        return dto;
    }
}
