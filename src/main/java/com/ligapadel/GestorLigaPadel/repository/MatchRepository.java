package com.ligapadel.GestorLigaPadel.repository;


import com.ligapadel.GestorLigaPadel.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Long> {
}
