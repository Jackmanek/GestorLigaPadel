package com.ligapadel.GestorLigaPadel.controller;

import com.ligapadel.GestorLigaPadel.dto.request.fase.FaseCreateDTO;
import com.ligapadel.GestorLigaPadel.dto.request.fase.FaseDTO;
import com.ligapadel.GestorLigaPadel.dto.request.fase.FaseSummaryDTO;
import com.ligapadel.GestorLigaPadel.dto.request.fase.FaseUpdateDTO;
import com.ligapadel.GestorLigaPadel.service.fase.FaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fases")
public class FaseController {

    @Autowired
    private FaseService faseService;

    @GetMapping
    public List<FaseDTO> getAllFases() {
        return faseService.getAllFases();
    }

    @GetMapping("/summary")
    public List<FaseSummaryDTO> getSummaryFases() {
        return faseService.getAllFaseSummaries();
    }

    @GetMapping("/{id}")
    public FaseDTO getFase(@PathVariable Long id) {
        return faseService.getFaseById(id)
                .orElseThrow(() -> new IllegalArgumentException("Fase no encontrada"));
    }

    @PostMapping
    public FaseDTO createFase(@RequestBody FaseCreateDTO dto) {
        return faseService.createFase(dto);
    }

    @PutMapping("/{id}")
    public FaseDTO updateFase(@PathVariable Long id, @RequestBody FaseUpdateDTO dto) {
        return faseService.updateFase(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteFase(@PathVariable Long id) {
        faseService.deleteFase(id);
    }
}
