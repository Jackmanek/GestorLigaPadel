package com.ligapadel.GestorLigaPadel.controller;

import com.ligapadel.GestorLigaPadel.dto.request.jornada.JornadaCreateDTO;
import com.ligapadel.GestorLigaPadel.dto.request.jornada.JornadaDTO;
import com.ligapadel.GestorLigaPadel.service.jornada.JornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jornadas")
public class JornadaController {
    @Autowired
    private JornadaService jornadaService;

    @GetMapping
    public List<JornadaDTO> getAll() {
        return jornadaService.findAll();
    }

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
