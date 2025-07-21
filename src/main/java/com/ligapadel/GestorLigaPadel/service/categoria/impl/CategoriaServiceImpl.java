package com.ligapadel.GestorLigaPadel.service.categoria.impl;


import com.ligapadel.GestorLigaPadel.dto.request.categoria.*;
import com.ligapadel.GestorLigaPadel.entity.Categoria;
import com.ligapadel.GestorLigaPadel.entity.Fase;
import com.ligapadel.GestorLigaPadel.mapper.categoria.CategoriaMapper;
import com.ligapadel.GestorLigaPadel.repository.CategoriaRepository;
import com.ligapadel.GestorLigaPadel.repository.FaseRepository;
import com.ligapadel.GestorLigaPadel.service.categoria.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private FaseRepository faseRepository;

    @Autowired
    private CategoriaMapper categoriaMapper;

    @Override
    @Transactional(readOnly = true)
    public List<CategoriaDTO> getAllCategorias() {
        List<Categoria> categorias = categoriaRepository.findAll();
        return categorias.stream()
                .map(categoriaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoriaSummaryDTO> getAllCategoriasSummary() {
        List<Categoria> categorias = categoriaRepository.findAll();
        return categorias.stream()
                .map(categoriaMapper::toSummaryDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CategoriaDTO> getCategoriaById(Long id) {
        return categoriaRepository.findById(id)
                .map(categoriaMapper::toDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoriaDTO> getCategoriasByFase(Long faseId) {
        List<Categoria> categorias = categoriaRepository.findByFaseId(faseId);
        return categorias.stream()
                .map(categoriaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoriaDTO> getCategoriasByOrden() {
        List<Categoria> categorias = categoriaRepository.findAllByOrderByOrdenAsc();
        return categorias.stream()
                .map(categoriaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoriaDTO> getCategoriasByFaseOrderByOrden(Long faseId) {
        List<Categoria> categorias = categoriaRepository.findByFaseIdOrderByOrdenAsc(faseId);
        return categorias.stream()
                .map(categoriaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoriaBasicDTO> getCategoriaBasicByFase(Long faseId) {
        List<Categoria> categorias = categoriaRepository.findByFaseIdOrderByOrdenAsc(faseId);
        return categorias.stream()
                .map(categoriaMapper::toBasicDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CategoriaDTO createCategoria(CategoriaCreateDTO categoriaCreateDTO) {
        // Validar que no exista una categoría con el mismo nombre
        if (existsCategoriaByNombre(categoriaCreateDTO.getNombre())) {
            throw new IllegalArgumentException("Ya existe una categoría con ese nombre");
        }

        // Buscar la fase
        Fase fase = faseRepository.findById(categoriaCreateDTO.getFaseId())
                .orElseThrow(() -> new IllegalArgumentException("Fase no encontrada"));

        // Validar que no exista una categoría con el mismo orden en la fase
        if (existsCategoriaByOrdenInFase(categoriaCreateDTO.getOrden(), categoriaCreateDTO.getFaseId())) {
            throw new IllegalArgumentException("Ya existe una categoría con ese orden en la fase");
        }

        // Crear la categoría
        Categoria categoria = new Categoria();
        categoria.setNombre(categoriaCreateDTO.getNombre());
        categoria.setOrden(categoriaCreateDTO.getOrden());
        categoria.setFase(fase);

        Categoria savedCategoria = categoriaRepository.save(categoria);
        return categoriaMapper.toDTO(savedCategoria);
    }

    @Override
    public CategoriaDTO updateCategoria(Long id, CategoriaUpdateDTO categoriaUpdateDTO) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Categoría no encontrada"));

        // Validar nombre único si se está cambiando
        if (categoriaUpdateDTO.getNombre() != null &&
                !categoriaUpdateDTO.getNombre().equals(categoria.getNombre()) &&
                existsCategoriaByNombre(categoriaUpdateDTO.getNombre())) {
            throw new IllegalArgumentException("Ya existe una categoría con ese nombre");
        }

        // Actualizar campos
        if (categoriaUpdateDTO.getNombre() != null) {
            categoria.setNombre(categoriaUpdateDTO.getNombre());
        }

        categoria.setOrden(categoriaUpdateDTO.getOrden());

        // Actualizar fase si se proporciona
        if (categoriaUpdateDTO.getFaseId() != null) {
            Fase fase = faseRepository.findById(categoriaUpdateDTO.getFaseId())
                    .orElseThrow(() -> new IllegalArgumentException("Fase no encontrada"));
            categoria.setFase(fase);
        }

        // Validar orden único en la fase
        Long faseId = categoriaUpdateDTO.getFaseId() != null ?
                categoriaUpdateDTO.getFaseId() : categoria.getFase().getId();

        if (categoriaRepository.existsByOrdenAndFaseIdAndIdNot(
                categoriaUpdateDTO.getOrden(), faseId, id)) {
            throw new IllegalArgumentException("Ya existe una categoría con ese orden en la fase");
        }

        Categoria updatedCategoria = categoriaRepository.save(categoria);
        return categoriaMapper.toDTO(updatedCategoria);
    }

    @Override
    public void deleteCategoria(Long id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Categoría no encontrada"));

        // Verificar que no tenga equipos asociados
        if (categoria.getTeams() != null && !categoria.getTeams().isEmpty()) {
            throw new IllegalArgumentException("No se puede eliminar la categoría porque tiene equipos asociados");
        }

        categoriaRepository.deleteById(id);
    }

    @Override
    public CategoriaDTO updateOrdenCategoria(Long id, int nuevoOrden) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Categoría no encontrada"));

        // Validar que no exista otra categoría con el mismo orden en la misma fase
        if (categoriaRepository.existsByOrdenAndFaseIdAndIdNot(
                nuevoOrden, categoria.getFase().getId(), id)) {
            throw new IllegalArgumentException("Ya existe una categoría con ese orden en la fase");
        }

        categoria.setOrden(nuevoOrden);
        Categoria updatedCategoria = categoriaRepository.save(categoria);
        return categoriaMapper.toDTO(updatedCategoria);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsCategoriaByNombre(String nombre) {
        return categoriaRepository.existsByNombre(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsCategoriaByNombreAndDifferentId(String nombre, Long id) {
        return categoriaRepository.existsByNombreAndIdNot(nombre, id);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsCategoriaByOrdenInFase(int orden, Long faseId) {
        return categoriaRepository.existsByOrdenAndFaseId(orden, faseId);
    }
}
