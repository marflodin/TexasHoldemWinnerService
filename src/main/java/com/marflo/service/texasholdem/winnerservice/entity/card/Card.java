package com.marflo.service.texasholdem.winnerservice.entity.card;

public class Card {

    private final Rank rank;
    private final Suit suit;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    //Multiply rank with 5 to give it higher priority than suit
    public int getValue() {
        return rank.getValue()*5 + suit.getValue();
    }
}