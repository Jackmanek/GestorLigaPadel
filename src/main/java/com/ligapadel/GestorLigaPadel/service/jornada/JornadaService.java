package com.ligapadel.GestorLigaPadel.service.jornada;

import com.ligapadel.GestorLigaPadel.dto.request.jornada.JornadaCreateDTO;
import com.ligapadel.GestorLigaPadel.dto.request.jornada.JornadaDTO;

import java.util.List;

public interface JornadaService {
    List<JornadaDTO> findAll();
    JornadaDTO create(JornadaCreateDTO dto);
    JornadaDTO getById(Long id);
    void delete(Long id);

    void generarCalendario(Long categoriaId);
}
