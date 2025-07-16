package com.ligapadel.GestorLigaPadel.dto.request.team;

import java.util.List;

public class TeamDTO {
    public Long id;
    public String name;
    public int puntos;

    public Long categoriaId;
    public List<Long> playerIds;
}
