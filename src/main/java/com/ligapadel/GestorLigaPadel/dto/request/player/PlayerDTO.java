package com.ligapadel.GestorLigaPadel.dto.request.player;

import com.ligapadel.GestorLigaPadel.entity.Player;

public class PlayerDTO {
    private String name;
    private String surname;
    private int age;
    private String gender;
    private String imgUrl;
    private String email;
    private String phone;

    // Constructores, getters y setters
    public PlayerDTO(Player player) {}

    // Getters y setters...
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

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}
