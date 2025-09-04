package com.ligapadel.GestorLigaPadel.service.jornada.impl;

import com.ligapadel.GestorLigaPadel.dto.request.jornada.JornadaCreateDTO;
import com.ligapadel.GestorLigaPadel.dto.request.jornada.JornadaDTO;
import com.ligapadel.GestorLigaPadel.entity.Categoria;
import com.ligapadel.GestorLigaPadel.entity.Jornada;
import com.ligapadel.GestorLigaPadel.entity.Match;
import com.ligapadel.GestorLigaPadel.entity.Team;
import com.ligapadel.GestorLigaPadel.mapper.jornada.JornadaMapper;
import com.ligapadel.GestorLigaPadel.repository.CategoriaRepository;
import com.ligapadel.GestorLigaPadel.repository.FaseRepository;
import com.ligapadel.GestorLigaPadel.repository.JornadaRepository;
import com.ligapadel.GestorLigaPadel.repository.MatchRepository;
import com.ligapadel.GestorLigaPadel.service.jornada.JornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JornadaServiceImpl implements JornadaService {
    @Autowired
    private JornadaRepository jornadaRepository;
    @Autowired
    private JornadaMapper jornadaMapper;
    @Autowired
    private FaseRepository faseRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private MatchRepository matchRepository;

    public List<JornadaDTO> findAll() {
        return jornadaRepository.findAll().stream()
                .map(jornadaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public JornadaDTO create(JornadaCreateDTO dto) {
        Jornada j = new Jornada();
        j.setNumJornada(dto.getNumJornada());
        j.setFase(faseRepository.findById(dto.getFaseId()).orElse(null));
        j.setCategoria(categoriaRepository.findById(dto.getCategoriaId()).orElse(null));
        return jornadaMapper.toDTO(jornadaRepository.save(j));
    }

    public JornadaDTO getById(Long id) {
        return jornadaRepository.findById(id).map(jornadaMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Jornada no encontrada"));
    }

    public void delete(Long id) {
        jornadaRepository.deleteById(id);
    }

    @Override
    public void generarCalendario(Long categoriaId) {
        Categoria categoria = categoriaRepository.findById(categoriaId)
                .orElseThrow(() -> new RuntimeException("Categoria no encontrada"));


        List<Team> equipos = new ArrayList<>(categoria.getTeams());
        int n = equipos.size();

        if(n % 2 != 0){
            equipos.add(null);
            n++;
        }

        Team fijo = equipos.remove(0);
        int jornadas = n - 1;

        for (int j = 0; j < jornadas; j++ ){
            Jornada jornada = new Jornada();
            jornada.setNumJornada(j + 1);
            jornada.setFase(categoria.getFase());
            jornada = jornadaRepository.save(jornada);

            List<Match> partidos = new ArrayList<>();

            Team rivalFijo = equipos.get(equipos.size() - 1);
            if (rivalFijo != null){
                Match m1 = new Match();
                m1.setLocal(fijo);
                m1.setVisitor(rivalFijo);
                m1.setJornada(jornada);
                partidos.add(m1);
            }

            for (int i= 0; i < (n / 2) - 1; i++){
                Team local = equipos.get(i);
                Team visitantes = equipos.get(equipos.size() - 2 - i);

                if(local != null && visitantes != null) {
                    Match m = new Match();
                    m.setLocal(local);
                    m.setVisitor(visitantes);
                    m.setJornada(jornada);
                    partidos.add(m);
                }
            }

            matchRepository.saveAll(partidos);

            Collections.rotate(equipos, 1);
        }
    }
}
