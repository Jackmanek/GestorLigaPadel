package com.ligapadel.GestorLigaPadel.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private int age;
    private String gender;
    private String imgUrl;
    private LocalDateTime createdAt;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Embedded
    private DataContact dataContact;

    @ManyToOne()
    @JoinColumn(name = "team_id")
    @JsonBackReference("team-player")
    private Team team;

    // Constructores
    public Player() {}

    public Player(User user, String name, String surname, int age, String gender, String imgUrl, DataContact dataContact) {
        this.user = user;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
        this.imgUrl = imgUrl;
        this.dataContact = dataContact;
    }

    // Método de utilidad para obtener el email del usuario
    public String getUserEmail() {
        return user != null ? user.getEmail() : null;
    }

    // Método de utilidad para obtener el username
    public String getUsername() {
        return user != null ? user.getUsername() : null;
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getImgUrl() { return imgUrl; }
    public void setImgUrl(String imgUrl) { this.imgUrl = imgUrl; }

    public DataContact getDataContact() { return dataContact; }
    public void setDataContact(DataContact dataContact) { this.dataContact = dataContact; }

    public Team getTeam() { return team; }
    public void setTeam(Team team) { this.team = team; }
}