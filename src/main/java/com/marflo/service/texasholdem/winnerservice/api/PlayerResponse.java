package com.marflo.service.texasholdem.winnerservice.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class PlayerResponse {

    @JsonProperty
    private String playerId;
    @JsonProperty
    private BigDecimal potAmount;

    public PlayerResponse(String playerId, BigDecimal potAmount) {
        this.playerId = playerId;
        this.potAmount = potAmount;
    }

    public String getPlayerId() {
        return playerId;
    }

    public BigDecimal getPotAmount() {
        return potAmount;
    }
}
