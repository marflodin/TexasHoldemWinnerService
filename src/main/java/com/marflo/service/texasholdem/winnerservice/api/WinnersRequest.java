package com.marflo.service.texasholdem.winnerservice.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marflo.service.texasholdem.winnerservice.entity.card.Card;

import java.util.List;

public class WinnersRequest {

    @JsonProperty
    private String handId;
    @JsonProperty
    private List<PlayerRequest> players;
    @JsonProperty
    private List<Card> dealerCards;

    public WinnersRequest(String handId, List<PlayerRequest> players, List<Card> dealerCards) {
        this.handId = handId;
        this.players = players;
        this.dealerCards = dealerCards;
    }

    public String getHandId() {
        return handId;
    }

    public List<PlayerRequest> getPlayers() {
        return players;
    }

    public List<Card> getDealerCards() {
        return dealerCards;
    }
}
