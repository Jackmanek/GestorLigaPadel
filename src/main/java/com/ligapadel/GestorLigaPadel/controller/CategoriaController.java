package com.ligapadel.GestorLigaPadel.controller;

import com.ligapadel.GestorLigaPadel.dto.request.categoria.*;
import com.ligapadel.GestorLigaPadel.service.categoria.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categorias")
@CrossOrigin(origins = "*")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    // GET /api/categorias - Obtener todas las categorías
    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> getAllCategorias() {
        try {
            List<CategoriaDTO> categorias = categoriaService.getAllCategorias();
            return ResponseEntity.ok(categorias);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // GET /api/categorias/summary - Obtener resumen de todas las categorías
    @GetMapping("/summary")
    public ResponseEntity<List<CategoriaSummaryDTO>> getAllCategoriasSummary() {
        try {
            List<CategoriaSummaryDTO> categorias = categoriaService.getAllCategoriasSummary();
            return ResponseEntity.ok(categorias);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // GET /api/categorias/{id} - Obtener categoría por ID
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> getCategoriaById(@PathVariable Long id) {
        try {
            Optional<CategoriaDTO> categoria = categoriaService.getCategoriaById(id);
            return categoria.map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // GET /api/categorias/fase/{faseId} - Obtener categorías por fase
    @GetMapping("/fase/{faseId}")
    public ResponseEntity<List<CategoriaDTO>> getCategoriasByFase(@PathVariable Long faseId) {
        try {
            List<CategoriaDTO> categorias = categoriaService.getCategoriasByFase(faseId);
            return ResponseEntity.ok(categorias);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // GET /api/categorias/fase/{faseId}/basic - Obtener categorías básicas por fase
    @GetMapping("/fase/{faseId}/basic")
    public ResponseEntity<List<CategoriaBasicDTO>> getCategoriaBasicByFase(@PathVariable Long faseId) {
        try {
            List<CategoriaBasicDTO> categorias = categoriaService.getCategoriaBasicByFase(faseId);
            return ResponseEntity.ok(categorias);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // GET /api/categorias/fase/{faseId}/ordenadas - Obtener categorías por fase ordenadas
    @GetMapping("/fase/{faseId}/ordenadas")
    public ResponseEntity<List<CategoriaDTO>> getCategoriasByFaseOrderByOrden(@PathVariable Long faseId) {
        try {
            List<CategoriaDTO> categorias = categoriaService.getCategoriasByFaseOrderByOrden(faseId);
            return ResponseEntity.ok(categorias);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // GET /api/categorias/ordenadas - Obtener todas las categorías ordenadas
    @GetMapping("/ordenadas")
    public ResponseEntity<List<CategoriaDTO>> getCategoriasByOrden() {
        try {
            List<CategoriaDTO> categorias = categoriaService.getCategoriasByOrden();
            return ResponseEntity.ok(categorias);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // POST /api/categorias - Crear nueva categoría
    @PostMapping
    public ResponseEntity<CategoriaDTO> createCategoria(@Valid @RequestBody CategoriaCreateDTO categoriaCreateDTO) {
        try {
            CategoriaDTO createdCategoria = categoriaService.createCategoria(categoriaCreateDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdCategoria);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // PUT /api/categorias/{id} - Actualizar categoría completa
    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO> updateCategoria(@PathVariable Long id,
                                                        @Valid @RequestBody CategoriaUpdateDTO categoriaUpdateDTO) {
        try {
            CategoriaDTO updatedCategoria = categoriaService.updateCategoria(id, categoriaUpdateDTO);
            return ResponseEntity.ok(updatedCategoria);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // PATCH /api/categorias/{id}/orden - Actualizar solo el orden de la categoría
    @PatchMapping("/{id}/orden")
    public ResponseEntity<CategoriaDTO> updateOrdenCategoria(@PathVariable Long id,
                                                             @RequestBody CategoriaOrdenUpdateDTO ordenDTO) {
        try {
            CategoriaDTO updatedCategoria = categoriaService.updateOrdenCategoria(id, ordenDTO.getOrden());
            return ResponseEntity.ok(updatedCategoria);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // DELETE /api/categorias/{id} - Eliminar categoría
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable Long id) {
        try {
            categoriaService.deleteCategoria(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // GET /api/categorias/exists/nombre/{nombre} - Verificar si existe una categoría con ese nombre
    @GetMapping("/exists/nombre/{nombre}")
    public ResponseEntity<Boolean> existsCategoriaByNombre(@PathVariable String nombre) {
        try {
            boolean exists = categoriaService.existsCategoriaByNombre(nombre);
            return ResponseEntity.ok(exists);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // GET /api/categorias/exists/orden/{orden}/fase/{faseId} - Verificar si existe una categoría con ese orden en la fase
    @GetMapping("/exists/orden/{orden}/fase/{faseId}")
    public ResponseEntity<Boolean> existsCategoriaByOrdenInFase(@PathVariable int orden,
                                                                @PathVariable Long faseId) {
        try {
            boolean exists = categoriaService.existsCategoriaByOrdenInFase(orden, faseId);
            return ResponseEntity.ok(exists);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // POST /api/categorias/batch - Crear múltiples categorías
    @PostMapping("/batch")
    public ResponseEntity<List<CategoriaDTO>> createCategorias(@Valid @RequestBody List<CategoriaCreateDTO> categoriasCreateDTO) {
        try {
            List<CategoriaDTO> createdCategorias = categoriasCreateDTO.stream()
                    .map(categoriaService::createCategoria)
                    .collect(java.util.stream.Collectors.toList());
            return ResponseEntity.status(HttpStatus.CREATED).body(createdCategorias);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
