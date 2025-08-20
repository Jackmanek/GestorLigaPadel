package com.ligapadel.GestorLigaPadel.dto.request.player;

import com.ligapadel.GestorLigaPadel.entity.DataContact;
import com.ligapadel.GestorLigaPadel.entity.Team;

public class PlayerSummaryDTO {
    private Long id;
    private String fullName;
    private String gender;
    private int age;
    private Long teamId;
    private String teamName;
    private DataContact dataContact;


    public PlayerSummaryDTO() {
    }

    public PlayerSummaryDTO(Long id, String fullName, String gender, Long teamId, int age, String teamName, DataContact dataContact) {
        this.id = id;
        this.fullName = fullName;
        this.gender = gender;
        this.teamId = teamId;
        this.age = age;
        this.dataContact = dataContact;
        this.teamName = teamName;
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

    public DataContact getDataContact() {
        return dataContact;
    }

    public void setDataContact(DataContact dataContact) {
        this.dataContact = dataContact;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
