package com.ligapadel.GestorLigaPadel.dto.request.player;

public class PlayerSummaryDTO {
    private Long id;
    private String fullName;
    private String gender;
    private int age;
    private Long teamId;

    public PlayerSummaryDTO() {
    }

    public PlayerSummaryDTO(Long id, String fullName, String gender, Long teamId, int age) {
        this.id = id;
        this.fullName = fullName;
        this.gender = gender;
        this.teamId = teamId;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
