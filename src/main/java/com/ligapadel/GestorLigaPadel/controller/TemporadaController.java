package com.ligapadel.GestorLigaPadel.controller;

import com.ligapadel.GestorLigaPadel.dto.request.temporada.TemporadaCreateDTO;
import com.ligapadel.GestorLigaPadel.dto.request.temporada.TemporadaDTO;
import com.ligapadel.GestorLigaPadel.dto.request.temporada.TemporadaSummaryDTO;
import com.ligapadel.GestorLigaPadel.dto.request.temporada.TemporadaUpdateDTO;
import com.ligapadel.GestorLigaPadel.service.temporada.TemporadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/temporadas")
public class TemporadaController {

    @Autowired
    private TemporadaService temporadaService;

    @GetMapping
    public List<TemporadaDTO> getAllTemporadas() {
        return temporadaService.getAllTemporadas();
    }

    @GetMapping("/summary")
    public List<TemporadaSummaryDTO> getTemporadasSummary() {
        return temporadaService.getAllTemporadasSummary();
    }

    @GetMapping("/{id}")
    public TemporadaDTO getTemporada(@PathVariable Long id) {
        return temporadaService.getTemporadaById(id)
                .orElseThrow(() -> new IllegalArgumentException("Temporada no encontrada"));
    }

    @PostMapping
    public TemporadaDTO createTemporada(@RequestBody TemporadaCreateDTO dto) {
        return temporadaService.createTemporada(dto);
    }

    @PutMapping("/{id}")
    public TemporadaDTO updateTemporada(@PathVariable Long id, @RequestBody TemporadaUpdateDTO dto) {
        return temporadaService.updateTemporada(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteTemporada(@PathVariable Long id) {
        temporadaService.deleteTemporada(id);
    }
}
