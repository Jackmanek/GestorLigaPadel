package com.ligapadel.GestorLigaPadel.repository;


import com.ligapadel.GestorLigaPadel.entity.ERole;
import com.ligapadel.GestorLigaPadel.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findFirstByName(ERole name);
}
