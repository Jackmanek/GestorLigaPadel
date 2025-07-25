package com.ligapadel.GestorLigaPadel.repository;


import com.ligapadel.GestorLigaPadel.entity.Jornada;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JornadaRepository extends JpaRepository<Jornada, Long> {

    List<Jornada> findByFaseId(Long faseId);
}
