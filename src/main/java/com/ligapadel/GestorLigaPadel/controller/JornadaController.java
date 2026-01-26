package com.ligapadel.GestorLigaPadel.controller;

import com.ligapadel.GestorLigaPadel.dto.request.jornada.JornadaCreateDTO;
import com.ligapadel.GestorLigaPadel.dto.request.jornada.JornadaDTO;
import com.ligapadel.GestorLigaPadel.entity.Jornada;
import com.ligapadel.GestorLigaPadel.service.jornada.JornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/jornadas")
public class JornadaController {
    @Autowired
    private JornadaService jornadaService;
/*
    @GetMapping
    public List<JornadaDTO> getAll() {
        List<Jornada> jornadas = jornadaService.findAll();

        return jornadas.stream().map(jornada -> {
            JornadaDTO dto = new JornadaDTO();
            dto.setId(jornada.getId());
            dto.setNumJornada(jornada.getNumJornada());
            dto.setFase(FaseDTO(jornada.getFase()));
            dto.setCategoria(CategoriaDTO(jornada.getCategoria())); // Asegúrate de que tu entidad Jornada tenga una relación con Categoria
            dto.setMatches(MatchDTO(jornada.getMatches()));
            return dto;
        }).collect(Collectors.toList());


    }
*/
    @GetMapping("/{id}")
    public JornadaDTO get(@PathVariable Long id) {
        return jornadaService.getById(id);
    }

    @PostMapping
    public JornadaDTO create(@RequestBody JornadaCreateDTO dto) {
        return jornadaService.create(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        jornadaService.delete(id);
    }

    @PostMapping("/generar/{categoriaId}")
    public ResponseEntity<String> generarCalendario(@PathVariable Long categoriaId) {
        jornadaService.generarCalendario(categoriaId);
        return ResponseEntity.ok("Calendario generado para la categoría " + categoriaId);
    }


}
