package com.marflo.service.texasholdem.winnerservice.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class WinnersResponse {

    @JsonProperty
    private List<PlayerResponse> players;

    public WinnersResponse(List<PlayerResponse> players) {
        this.players = players;
    }

    public List<PlayerResponse> getPlayers() {
        return players;
    }
}
