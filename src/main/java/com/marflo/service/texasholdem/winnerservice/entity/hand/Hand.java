package com.marflo.service.texasholdem.winnerservice.entity.hand;

import com.marflo.service.texasholdem.winnerservice.entity.card.Card;
import com.marflo.service.texasholdem.winnerservice.entity.card.Rank;
import com.marflo.service.texasholdem.winnerservice.entity.card.Suit;
import com.marflo.service.texasholdem.winnerservice.exception.TexasHoldemException;
import com.marflo.service.texasholdem.winnerservice.exception.Error;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {

    private List<Card> cards = new ArrayList<Card>();

    public List<Card> getCards() {
        return cards;
    }

    public void addCard(Card card) {
        if (cardIsAlreadyOnHand(card))
            throw new TexasHoldemException(Error.HAND_CONTAINS_DUPLICATE_CARD);
        if (handIsNotFull())
            cards.add(card);
        else
            throw new TexasHoldemException(Error.HAND_ALREADY_FULL);
    }

    private boolean cardIsAlreadyOnHand(Card card) {
        for (Card cardOnHand : cards)
            if (cardOnHand.equals(card))
                return true;
        return false;
    }

    public List<Card> getCardsMatchingRank(Rank rank) {
        List<Card> cardsMatchingRank = new ArrayList<Card>();
        for (Card card : cards) {
            if (card.getRank().equals(rank)) {
                cardsMatchingRank.add(card);
            }
        }
        return cardsMatchingRank;
    }

    public List<Card> getCardsMatchingSuit(Suit suit) {
        List<Card> cardsMatchingSuit = new ArrayList<Card>();
        for (Card card : cards) {
            if (card.getSuit().equals(suit)) {
                cardsMatchingSuit.add(card);
            }
        }
        return cardsMatchingSuit;
    }

    public List<Card> getCardsMatchingRankAndSuit(Rank rank, Suit suit) {
        List<Card> cardsMatchingRankAndSuit = new ArrayList<Card>();
        for (Card card : cards) {
            if (card.getRank().equals(rank) && card.getSuit().equals(suit)) {
                cardsMatchingRankAndSuit.add(card);
            }
        }
        return cardsMatchingRankAndSuit;
    }

    abstract boolean handIsNotFull();
}
