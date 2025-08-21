package com.ligapadel.GestorLigaPadel.service.categoria;

import com.ligapadel.GestorLigaPadel.dto.request.categoria.*;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {
    List<CategoriaDTO> getAllCategorias();
    List<CategoriaSummaryDTO> getAllCategoriasSummary();
    Optional<CategoriaDTO> getCategoriaById(Long id);
    List<CategoriaDTO> getCategoriasByFase(Long faseId);
    List<CategoriaDTO> getCategoriasByOrden();
    CategoriaDTO createCategoria(CategoriaCreateDTO categoriaCreateDTO);
    CategoriaDTO updateCategoria(Long id, CategoriaUpdateDTO categoriaUpdateDTO);
    void deleteCategoria(Long id);
    List<CategoriaDTO> getCategoriasByFaseOrderByOrden(Long faseId);
    boolean existsCategoriaByNombre(String nombre);
    boolean existsCategoriaByNombreAndDifferentId(String nombre, Long id);
    boolean existsCategoriaByOrdenInFase(int orden, Long faseId);
    CategoriaDTO updateOrdenCategoria(Long id, int nuevoOrden);
    List<CategoriaBasicDTO> getCategoriaBasicByFase(Long faseId);


}
