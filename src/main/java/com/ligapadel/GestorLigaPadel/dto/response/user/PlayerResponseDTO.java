package com.ligapadel.GestorLigaPadel.dto.response.user;

import com.ligapadel.GestorLigaPadel.dto.request.team.TeamDTO;

public class PlayerResponseDTO {

    private Long id;
    private String name;
    private String surname;
    private int age;
    private String gender;
    private String imgUrl;
    private String email;
    private String phone;
    private String username;        // Del usuario asociado
    private TeamDTO team;

    public PlayerResponseDTO() {
    }

    public PlayerResponseDTO(Long id, String name, String surname, int age, String gender, String imgUrl, String email, String phone, String username, TeamDTO team) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
        this.imgUrl = imgUrl;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.team = team;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public TeamDTO getTeam() {
        return team;
    }

    public void setTeam(TeamDTO team) {
        this.team = team;
    }
}
