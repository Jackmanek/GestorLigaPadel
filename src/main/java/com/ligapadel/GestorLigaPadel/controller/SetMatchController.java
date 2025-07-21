package com.ligapadel.GestorLigaPadel.controller;

import com.ligapadel.GestorLigaPadel.dto.request.setmatch.SetMatchCreateDTO;
import com.ligapadel.GestorLigaPadel.dto.request.setmatch.SetMatchDTO;
import com.ligapadel.GestorLigaPadel.service.setmatch.SetMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/setmatches")
public class SetMatchController {
    @Autowired
    private SetMatchService setMatchService;

    @GetMapping
    public List<SetMatchDTO> getAll() {
        return setMatchService.findAll();
    }

    @GetMapping("/{id}")
    public SetMatchDTO get(@PathVariable Long id) {
        return setMatchService.getById(id);
    }

    @PostMapping
    public SetMatchDTO create(@RequestBody SetMatchCreateDTO dto) {
        return setMatchService.create(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { setMatchService.delete(id); }
}
