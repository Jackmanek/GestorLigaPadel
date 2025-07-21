package com.ligapadel.GestorLigaPadel.dto.request.player;

public class PlayerCreateDTO {
    private String name;
    private String surname;
    private int age;
    private String gender;
    private String imgUrl;
    private Long teamId;
    private Long userId;
    public PlayerCreateDTO() {}

    public PlayerCreateDTO(String name, String surname, int age, String gender, String imgUrl, Long teamId, Long userId) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
        this.imgUrl = imgUrl;
        this.teamId = teamId;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
