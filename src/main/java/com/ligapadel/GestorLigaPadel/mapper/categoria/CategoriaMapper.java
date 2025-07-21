package com.ligapadel.GestorLigaPadel.mapper.categoria;

import com.ligapadel.GestorLigaPadel.dto.request.categoria.CategoriaBasicDTO;
import com.ligapadel.GestorLigaPadel.dto.request.categoria.CategoriaCreateDTO;
import com.ligapadel.GestorLigaPadel.dto.request.categoria.CategoriaDTO;
import com.ligapadel.GestorLigaPadel.dto.request.categoria.CategoriaSummaryDTO;
import com.ligapadel.GestorLigaPadel.entity.Categoria;
import com.ligapadel.GestorLigaPadel.mapper.team.TeamMapper;
import com.ligapadel.GestorLigaPadel.mapper.fase.FaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CategoriaMapper {

    @Autowired
    private FaseMapper faseMapper;

    @Autowired
    @Lazy
    private TeamMapper teamMapper;

    public CategoriaDTO toDTO(Categoria categoria) {
        if (categoria == null) {
            return null;
        }

        CategoriaDTO dto = new CategoriaDTO();
        dto.setId(categoria.getId());
        dto.setNombre(categoria.getNombre());
        dto.setOrden(categoria.getOrden());

        // Mapear fase
        if (categoria.getFase() != null) {
            dto.setFase(faseMapper.toDTO(categoria.getFase()));
        }

        // Mapear equipos (solo si están cargados)
        if (categoria.getTeams() != null) {
            dto.setTeams(categoria.getTeams().stream()
                    .map(teamMapper::toDTO)
                    .collect(Collectors.toList()));
        }

        return dto;
    }

    public CategoriaSummaryDTO toSummaryDTO(Categoria categoria) {
        if (categoria == null) {
            return null;
        }

        return new CategoriaSummaryDTO(
                categoria.getId(),
                categoria.getNombre(),
                categoria.getOrden(),
                categoria.getFase() != null ? categoria.getFase().getNombre() : null,
                categoria.getTeams() != null ? categoria.getTeams().size() : 0
        );
    }

    public CategoriaBasicDTO toBasicDTO(Categoria categoria) {
        if (categoria == null) {
            return null;
        }

        return new CategoriaBasicDTO(
                categoria.getId(),
                categoria.getNombre(),
                categoria.getOrden(),
                categoria.getFase() != null ? categoria.getFase().getNombre() : null
        );
    }

    public Categoria toEntity(CategoriaCreateDTO createDTO) {
        if (createDTO == null) {
            return null;
        }

        Categoria categoria = new Categoria();
        categoria.setNombre(createDTO.getNombre());
        categoria.setOrden(createDTO.getOrden());

        return categoria;
    }
}
