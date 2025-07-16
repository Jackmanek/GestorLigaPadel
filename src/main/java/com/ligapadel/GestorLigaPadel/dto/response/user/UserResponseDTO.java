package com.ligapadel.GestorLigaPadel.dto.response.user;

import com.ligapadel.GestorLigaPadel.dto.request.player.PlayerDTO;

import java.time.LocalDateTime;
import java.util.Set;

public class UserResponseDTO {
    private Long id;
    private String username;
    private String email;
    private LocalDateTime createdAt;
    private Set<String> roles;
    private boolean hasPlayerProfile;
    private PlayerDTO player;
    public UserResponseDTO() {}

    public UserResponseDTO(Long id, String username, String email, LocalDateTime createdAt, Set<String> roles, boolean hasPlayerProfile, PlayerDTO player) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.createdAt = createdAt;
        this.roles = roles;
        this.hasPlayerProfile = hasPlayerProfile;
        this.player = player;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public boolean isHasPlayerProfile() {
        return hasPlayerProfile;
    }

    public void setHasPlayerProfile(boolean hasPlayerProfile) {
        this.hasPlayerProfile = hasPlayerProfile;
    }

    public PlayerDTO getPlayer() {
        return player;
    }

    public void setPlayer(PlayerDTO player) {
        this.player = player;
    }
}
