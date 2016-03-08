package com.marflo.service.texasholdem.winnerservice.entity.score;


import com.marflo.service.texasholdem.winnerservice.entity.card.Card;
import com.marflo.service.texasholdem.winnerservice.entity.card.Rank;
import com.marflo.service.texasholdem.winnerservice.entity.card.Suit;
import com.marflo.service.texasholdem.winnerservice.entity.hand.DealerHand;
import com.marflo.service.texasholdem.winnerservice.entity.hand.PlayerHand;

import java.util.ArrayList;
import java.util.List;

public abstract class Score {

    private PlayerHand playerHand;
    private DealerHand dealerHand;

    public Score(PlayerHand playerHand, DealerHand dealerHand) {
        this.playerHand = playerHand;
        this.dealerHand = dealerHand;
    }

    public int getNumberOfCardsMatchingRank(Rank rank) {
        return getCardsMatchingRank(rank).size();
    }

    public List<Card> getCardsMatchingRank(Rank rank) {
        List<Card> cardsMatchingRank = new ArrayList<>();
        cardsMatchingRank.addAll(getPlayerHand().getCardsMatchingRank(rank));
        cardsMatchingRank.addAll(getDealerHand().getCardsMatchingRank(rank));
        return cardsMatchingRank;
    }

    public int getNumberOfCardsMatchingSuit(Suit suit) {
        return getCardsMatchingSuit(suit).size();
    }

    public List<Card> getCardsMatchingSuit(Suit suit) {
        List<Card> cardsMatchingSuit = new ArrayList<>();
        cardsMatchingSuit.addAll(getPlayerHand().getCardsMatchingSuit(suit));
        cardsMatchingSuit.addAll(getDealerHand().getCardsMatchingSuit(suit));
        return cardsMatchingSuit;
    }

    public int getNumberOfCardsMatchingRankAndSuit(Rank rank, Suit suit) {
        return getCardsMatchingRankAndSuit(rank, suit).size();
    }

    public List<Card> getCardsMatchingRankAndSuit(Rank rank, Suit suit) {
        List<Card> cardsMatchingRankAndSuit = new ArrayList<>();
        cardsMatchingRankAndSuit.addAll(getPlayerHand().getCardsMatchingRankAndSuit(rank, suit));
        cardsMatchingRankAndSuit.addAll(getDealerHand().getCardsMatchingRankAndSuit(rank, suit));
        return cardsMatchingRankAndSuit;
    }

    public PlayerHand getPlayerHand() {
        return playerHand;
    }

    public DealerHand getDealerHand() {
        return dealerHand;
    }

    abstract int getPoints();
    abstract boolean meetsConditions();
}
