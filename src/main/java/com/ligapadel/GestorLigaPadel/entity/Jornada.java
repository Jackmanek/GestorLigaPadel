package com.ligapadel.GestorLigaPadel.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Jornada {
    @Id
    @GeneratedValue
    private Long id;
    private int numJornada;

    @ManyToOne
    @JsonBackReference("fase-jornada")
    private Fase fase;

    @OneToMany(mappedBy = "jornada")
    @JsonManagedReference("jornada-match")
    private List<Match> matches;
    public Jornada() {}
    public Jornada(int numJornada) {
        this.numJornada = numJornada;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumJornada() {
        return numJornada;
    }

    public void setNumJornada(int numJornada) {
        this.numJornada = numJornada;
    }

    public Fase getFase() {
        return fase;
    }

    public void setFase(Fase fase) {
        this.fase = fase;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }
}
