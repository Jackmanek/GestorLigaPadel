package com.ligapadel.GestorLigaPadel.dto.request.team;

import com.ligapadel.GestorLigaPadel.dto.request.player.PlayerDTO;

import java.util.List;

public class TeamCreateDTO {
    private String name;
    private Long categoriaId;
    private List<Long> playerIds;

    // Constructor vacío
    public TeamCreateDTO() {}

    // Constructor
    public TeamCreateDTO(String name, Long categoriaId, List<Long> playerIds) {
        this.name = name;
        this.categoriaId = categoriaId;
        this.playerIds = playerIds;
    }

    // Getters y Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Long getCategoriaId() { return categoriaId; }
    public void setCategoriaId(Long categoriaId) { this.categoriaId = categoriaId; }

    public List<Long> getPlayerIds() {
        return playerIds;
    }

    public void setPlayerIds(List<Long> playerIds) {
        this.playerIds = playerIds;
    }
}
