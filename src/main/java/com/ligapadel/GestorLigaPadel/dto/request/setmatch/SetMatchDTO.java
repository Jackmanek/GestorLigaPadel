package com.ligapadel.GestorLigaPadel.dto.request.setmatch;

public class SetMatchDTO {
    private Long id;
    private int numSet;
    private int gameLocal;
    private int gameVisit;
    private Long matchId;

    public SetMatchDTO() {
    }

    public SetMatchDTO(Long id, int numSet, int gameLocal, int gameVisit, Long matchId) {
        this.id = id;
        this.numSet = numSet;
        this.gameLocal = gameLocal;
        this.gameVisit = gameVisit;
        this.matchId = matchId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumSet() {
        return numSet;
    }

    public void setNumSet(int numSet) {
        this.numSet = numSet;
    }

    public int getGameLocal() {
        return gameLocal;
    }

    public void setGameLocal(int gameLocal) {
        this.gameLocal = gameLocal;
    }

    public int getGameVisit() {
        return gameVisit;
    }

    public void setGameVisit(int gameVisit) {
        this.gameVisit = gameVisit;
    }

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }
}
