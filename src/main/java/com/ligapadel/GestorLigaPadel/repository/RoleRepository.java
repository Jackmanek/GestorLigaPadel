package com.ligapadel.GestorLigaPadel.repository;

import com.padelmons.PadelMons.entities.ERole;
import com.padelmons.PadelMons.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findFirstByName(ERole name);
}
