package com.ligapadel.GestorLigaPadel.dto.request.team;

public class TeamBasicDTO {
    private Long id;
    private String name;

    public TeamBasicDTO() {
    }

    public TeamBasicDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
