package com.marflo.service.texasholdem.winnerservice.entity.score;


import com.marflo.service.texasholdem.winnerservice.entity.card.Card;
import com.marflo.service.texasholdem.winnerservice.entity.card.Rank;
import com.marflo.service.texasholdem.winnerservice.entity.card.Suit;
import com.marflo.service.texasholdem.winnerservice.entity.hand.DealerHand;
import com.marflo.service.texasholdem.winnerservice.entity.hand.PlayerHand;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class StraightFlush extends Score {

    int maxNumbersInARowWithSameSuit;
    int numbersInARowWithSameSuit;
    Collection<Suit> suits;

    public StraightFlush(PlayerHand playerHand, DealerHand dealerHand) {
        super(playerHand, dealerHand);
    }

    public int getPoints() {
        return 8;
    }

    public boolean meetsConditions() {
        maxNumbersInARowWithSameSuit = 0;
        numbersInARowWithSameSuit = 0;
        for (Rank rank : Rank.values()) {
            if (isCardOnStraightFlush(rank)) {
                numbersInARowWithSameSuit++;
            } else {
                calculateMaxNumbersInARow(numbersInARowWithSameSuit);
                numbersInARowWithSameSuit = 0;
            }
        }
        calculateMaxNumbersInARow(numbersInARowWithSameSuit);
        return determineIfConditionsAreMet();
    }

    private boolean isCardOnStraightFlush(Rank rank) {
        return hasCardMatchingRank(rank) && hasCorrectSuit(rank);
    }

    private boolean hasCardMatchingRank(Rank rank) {
        return getNumberOfCardsMatchingRank(rank) >= 1;
    }

    private boolean hasCorrectSuit(Rank rank) {
        if (numbersInARowWithSameSuit == 0) {
            setPossibleSuits(getCardsMatchingRank(rank));
            return true;
        }
        return getCardsMatchingRankAndAvailableSuits(rank).size() >= 1;
    }

    private void setPossibleSuits(List<Card> cards) {
        suits = new HashSet<Suit>();
        for (Card card : cards) {
            suits.add(card.getSuit());
        }
    }

    private List<Card> getCardsMatchingRankAndAvailableSuits(Rank rank) {
        List<Card> cardsMatchingRankAndSuit = new ArrayList<Card>();
        for (Suit suit : suits) {
            cardsMatchingRankAndSuit.addAll(getCardsMatchingRankAndSuit(rank, suit));
        }
        setPossibleSuits(cardsMatchingRankAndSuit);
        return cardsMatchingRankAndSuit;
    }

    private void calculateMaxNumbersInARow(int numbersInARowWithSameSuit) {
        maxNumbersInARowWithSameSuit = Math.max(maxNumbersInARowWithSameSuit, numbersInARowWithSameSuit);
    }

    private boolean determineIfConditionsAreMet() {
        return maxNumbersInARowWithSameSuit >= 5 || isStraightFlushWithAceCountedAsOne();
    }

    private boolean isStraightFlushWithAceCountedAsOne() {
        for (Suit suit : Suit.values()) {
            if (isStraightFlushWithAceCountedAsOneForSuit(suit))
                return true;
        }
        return false;
    }

    private boolean isStraightFlushWithAceCountedAsOneForSuit(Suit suit) {
        return hasCardMatchingRankAndSuit(Rank.ACE, suit) &&
                hasCardMatchingRankAndSuit(Rank.DEUCE, suit) &&
                hasCardMatchingRankAndSuit(Rank.THREE, suit) &&
                hasCardMatchingRankAndSuit(Rank.FOUR, suit) &&
                hasCardMatchingRankAndSuit(Rank.FIVE, suit);
    }

    private boolean hasCardMatchingRankAndSuit(Rank rank, Suit suit) {
        return getNumberOfCardsMatchingRankAndSuit(rank, suit) >= 1;
    }
}
