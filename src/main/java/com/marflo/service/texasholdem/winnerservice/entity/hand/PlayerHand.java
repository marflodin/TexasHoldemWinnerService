package com.marflo.service.texasholdem.winnerservice.entity.hand;


public class PlayerHand extends Hand {

    private static final int MAX_NUMBER_OF_CARDS_FOR_PLAYER_HAND = 2;

    @Override
    boolean handIsNotFull() {
        return getCards().size() < MAX_NUMBER_OF_CARDS_FOR_PLAYER_HAND;
    }
}
