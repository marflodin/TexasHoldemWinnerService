package com.marflo.service.texasholdem.winnerservice.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marflo.service.texasholdem.winnerservice.entity.card.Card;

import java.math.BigDecimal;
import java.util.List;

public class PlayerRequest {

    @JsonProperty
    private String playerId;
    @JsonProperty
    private List<Card> cards;
    @JsonProperty
    private BigDecimal potAmount;

    public PlayerRequest(String playerId, List<Card> cards, BigDecimal potAmount) {
        this.playerId = playerId;
        this.cards = cards;
        this.potAmount = potAmount;
    }

    public String getPlayerId() {
        return playerId;
    }

    public List<Card> getCards() {
        return cards;
    }

    public BigDecimal getPotAmount() {
        return potAmount;
    }
}
