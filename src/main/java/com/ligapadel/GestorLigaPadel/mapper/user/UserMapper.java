package com.ligapadel.GestorLigaPadel.mapper.user;

import com.ligapadel.GestorLigaPadel.dto.request.player.PlayerDTO;
import com.ligapadel.GestorLigaPadel.dto.request.user.CreateUserRequestDTO;
import com.ligapadel.GestorLigaPadel.dto.request.user.UpdateUserRequestDTO;
import com.ligapadel.GestorLigaPadel.dto.response.user.UserResponseDTO;
import com.ligapadel.GestorLigaPadel.entity.User;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    // Convierte DTO request a Entity
    public User toEntity(CreateUserRequestDTO dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword()); // Se codificará en el service
        user.setCreatedAt(LocalDateTime.now());
        return user;
    }

    // Convierte Entity a DTO response
    public UserResponseDTO toResponseDTO(User user) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setCreatedAt(user.getCreatedAt());

        // Mapear roles
        Set<String> roleNames = user.getRoles().stream()
                .map(role -> role.getName().name())
                .collect(Collectors.toSet());
        dto.setRoles(roleNames);

        // Verificar si tiene perfil de jugador
        dto.setHasPlayerProfile(user.getPlayer() != null);

        // Si tiene jugador, incluir datos básicos
        if (user.getPlayer() != null) {
            dto.setPlayer(new PlayerDTO(user.getPlayer()));
        }

        return dto;
    }

    // Actualiza Entity con datos del DTO
    public void updateEntityFromDTO(User user, UpdateUserRequestDTO dto) {
        if (dto.getUsername() != null) {
            user.setUsername(dto.getUsername());
        }
        if (dto.getEmail() != null) {
            user.setEmail(dto.getEmail());
        }
    }
}
