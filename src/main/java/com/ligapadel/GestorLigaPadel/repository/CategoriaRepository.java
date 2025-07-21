package com.ligapadel.GestorLigaPadel.repository;


import com.ligapadel.GestorLigaPadel.entity.Categoria;
import com.ligapadel.GestorLigaPadel.entity.Fase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    List<Categoria> findByFaseOrderByOrdenAsc(Fase fase);
    List<Categoria> findByFaseId(Long faseId);

    List<Categoria> findAllByOrderByOrdenAsc();

    List<Categoria> findByFaseIdOrderByOrdenAsc(Long faseId);

    boolean existsByNombre(String nombre);

    boolean existsByNombreAndIdNot(String nombre, Long id);

    boolean existsByOrdenAndFaseId(int orden, Long faseId);

    boolean existsByOrdenAndFaseIdAndIdNot(int orden, Long faseId, Long id);

    @Query("SELECT c FROM Categoria c WHERE c.fase.id = :faseId AND c.orden BETWEEN :ordenMin AND :ordenMax")
    List<Categoria> findByFaseIdAndOrdenBetween(@Param("faseId") Long faseId,
                                                @Param("ordenMin") int ordenMin,
                                                @Param("ordenMax") int ordenMax);

    @Query("SELECT c FROM Categoria c WHERE SIZE(c.teams) > :minTeams")
    List<Categoria> findCategoriasWithMinTeams(@Param("minTeams") int minTeams);

    @Query("SELECT c FROM Categoria c WHERE SIZE(c.teams) = 0")
    List<Categoria> findCategoriasWithoutTeams();
}
