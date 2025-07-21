package com.ligapadel.GestorLigaPadel.service;

import com.ligapadel.GestorLigaPadel.dto.request.user.CreateUserRequestDTO;
import com.ligapadel.GestorLigaPadel.dto.request.user.UpdateUserRequestDTO;
import com.ligapadel.GestorLigaPadel.dto.response.user.UserResponseDTO;
import com.ligapadel.GestorLigaPadel.entity.User;
import com.ligapadel.GestorLigaPadel.mapper.user.UserMapper;
import com.ligapadel.GestorLigaPadel.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserResponseDTO createUser(CreateUserRequestDTO dto) {
        // Validaciones
        if (userRepository.existsByUsername(dto.getUsername())) {
            throw new RuntimeException("Username ya existe");
        }
        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Email ya existe");
        }

        // Convertir DTO a Entity usando mapper
        User user = userMapper.toEntity(dto);

        // Codificar contraseña
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Guardar en BD
        User savedUser = userRepository.save(user);

        // Convertir Entity a DTO response usando mapper
        return userMapper.toResponseDTO(savedUser);
    }

    public UserResponseDTO updateUser(Long id, UpdateUserRequestDTO dto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Actualizar usando mapper
        userMapper.updateEntityFromDTO(user, dto);

        // Guardar
        User updatedUser = userRepository.save(user);

        // Retornar DTO response
        return userMapper.toResponseDTO(updatedUser);
    }

    public UserResponseDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        return userMapper.toResponseDTO(user);
    }


}
