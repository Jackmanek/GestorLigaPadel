package com.ligapadel.GestorLigaPadel.repository;


import com.ligapadel.GestorLigaPadel.entity.Categoria;
import com.ligapadel.GestorLigaPadel.entity.Fase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    List<Categoria> findByFaseOrderByOrdenAsc(Fase fase);
}
