package com.marflo.service.texasholdem.winnerservice.entity.card;

public enum Suit {

    DIAMONDS(1), CLUBS(2), HEARTS(3), SPADES(4);
    private final int value;

    Suit(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
