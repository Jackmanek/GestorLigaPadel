package com.ligapadel.GestorLigaPadel.repository;

import com.ligapadel.GestorLigaPadel.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
