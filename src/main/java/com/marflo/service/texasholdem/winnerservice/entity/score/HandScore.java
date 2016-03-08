package com.marflo.service.texasholdem.winnerservice.entity.score;

import com.marflo.service.texasholdem.winnerservice.entity.card.Card;

import java.util.Set;

public class HandScore {
    private int points;
    private Set<Card> orderedCards;

    public HandScore(int points, Set<Card> orderedCards) {
        this.points = points;
        this.orderedCards = orderedCards;
    }

    public int getPoints() {
        return points;
    }

    public Set<Card> getOrderedCards() {
        return orderedCards;
    }
}
