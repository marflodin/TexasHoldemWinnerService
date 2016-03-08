package com.marflo.service.texasholdem.winnerservice.entity.score;

import com.marflo.service.texasholdem.winnerservice.entity.card.Card;
import com.marflo.service.texasholdem.winnerservice.entity.hand.DealerHand;
import com.marflo.service.texasholdem.winnerservice.entity.hand.PlayerHand;

import java.util.List;
import java.util.Set;

public class HandScore {
    private int points;
    private Set<Integer> orderedCardValue;

    public HandScore(PlayerHand playerHand, DealerHand dealerHand) {
        Score score = getHandPoints(playerHand, dealerHand);
        this.points = score.getPoints();

        //this.orderedCardValue = getOrderedCardsByValue(cards);
    }

    private Set<Integer> getOrderedCardsByValue(List<Card> cards) {
        return null;
    }

    private Score getHandPoints(PlayerHand playerHand, DealerHand dealerHand) {
        if (new StraightFlush(playerHand, dealerHand).meetsConditions())
            return new StraightFlush(playerHand, dealerHand);
        else if (new FourOfAKind(playerHand, dealerHand).meetsConditions())
            return new FourOfAKind(playerHand, dealerHand);
        else if (new FullHouse(playerHand, dealerHand).meetsConditions())
            return new FullHouse(playerHand, dealerHand);
        else if (new Flush(playerHand, dealerHand).meetsConditions())
            return new Flush(playerHand, dealerHand);
        else if (new Straight(playerHand, dealerHand).meetsConditions())
            return new Straight(playerHand, dealerHand);
        else if (new ThreeOfAKind(playerHand, dealerHand).meetsConditions())
            return new ThreeOfAKind(playerHand, dealerHand);
        else if (new TwoPair(playerHand, dealerHand).meetsConditions())
            return new TwoPair(playerHand, dealerHand);
        else if (new Pair(playerHand, dealerHand).meetsConditions())
            return new Pair(playerHand, dealerHand);
        else
            return null;
    }

    public int getPoints() {
        return points;
    }

    public Set<Integer> getOrderedCardValue() {
        return orderedCardValue;
    }
}
