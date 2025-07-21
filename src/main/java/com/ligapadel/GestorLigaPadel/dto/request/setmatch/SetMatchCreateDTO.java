package com.ligapadel.GestorLigaPadel.dto.request.setmatch;

public class SetMatchCreateDTO {
    private int numSet;
    private int gameLocal;
    private int gameVisit;
    private Long matchId;

    public SetMatchCreateDTO() {
    }

    public SetMatchCreateDTO(int numSet, int gameLocal, int gameVisit, Long matchId) {
        this.numSet = numSet;
        this.gameLocal = gameLocal;
        this.gameVisit = gameVisit;
        this.matchId = matchId;
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
