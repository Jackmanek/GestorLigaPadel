package com.ligapadel.GestorLigaPadel.dto.request.player;

import com.ligapadel.GestorLigaPadel.dto.request.team.TeamDTO;
import com.ligapadel.GestorLigaPadel.entity.Player;

import java.time.LocalDateTime;

public class PlayerDTO {
    private Long id;
    private String name;
    private String surname;
    private int age;
    private String gender;
    private String imgUrl;
    private LocalDateTime createdAt;
    private Long teamId;
    private Long userId;

    public PlayerDTO() {
    }

    public PlayerDTO(Player player) {
    }

    public PlayerDTO(Long id, String name, String surname, int age, String gender, String imgUrl, LocalDateTime createdAt, Long teamId, Long userId) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
        this.imgUrl = imgUrl;
        this.createdAt = createdAt;
        this.teamId = teamId;
        this.userId = userId;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
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