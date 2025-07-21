package com.ligapadel.GestorLigaPadel.repository;

import com.ligapadel.GestorLigaPadel.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {

    List<Team> findByCategoriaId(Long categoriaId);

    List<Team> findAllByOrderByPuntosDesc();

    boolean existsByName(String name);

    boolean existsByNameAndIdNot(String name, Long id);

    @Query("SELECT t FROM Team t WHERE t.categoria.id = :categoriaId ORDER BY t.puntos DESC")
    List<Team> findByCategoriaIdOrderByPuntosDesc(@Param("categoriaId") Long categoriaId);

    @Query("SELECT t FROM Team t WHERE t.puntos >= :minPuntos")
    List<Team> findByPuntosGreaterThanEqual(@Param("minPuntos") int minPuntos);



}
