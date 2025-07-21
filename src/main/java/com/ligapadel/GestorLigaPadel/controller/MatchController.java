package com.ligapadel.GestorLigaPadel.controller;

import com.ligapadel.GestorLigaPadel.dto.request.match.MatchCreateDTO;
import com.ligapadel.GestorLigaPadel.dto.request.match.MatchDTO;
import com.ligapadel.GestorLigaPadel.service.match.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
public class MatchController {
    @Autowired
    private MatchService matchService;

    @GetMapping
    public List<MatchDTO> getAll() {
        return matchService.findAll();
    }

    @GetMapping("/{id}")
    public MatchDTO get(@PathVariable Long id) {
        return matchService.getById(id);
    }

    @PostMapping
    public MatchDTO create(@RequestBody MatchCreateDTO dto) {
        return matchService.create(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        matchService.delete(id);
    }
}
