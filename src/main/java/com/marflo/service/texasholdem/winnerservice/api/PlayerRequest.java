package com.marflo.service.texasholdem.winnerservice.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marflo.service.texasholdem.winnerservice.entity.card.Card;

import java.math.BigDecimal;
import java.util.List;

public class PlayerRequest {

    @JsonProperty
    private String playerId;
    @JsonProperty
    private List<Card> playerCards;
    @JsonProperty
    private BigDecimal potAmount;


    public String getPlayerId() {
        return playerId;
    }

    public List<Card> getPlayerCards() {
        return playerCards;
    }

    public BigDecimal getPotAmount() {
        return potAmount;
    }
}
