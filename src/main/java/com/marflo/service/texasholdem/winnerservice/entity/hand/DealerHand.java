package com.marflo.service.texasholdem.winnerservice.entity.hand;


public class DealerHand extends Hand {

    private static final int MAX_NUMBER_OF_CARDS_FOR_DEALER_HAND = 5;

    @Override
    boolean handIsNotFull() {
        return getCards().size() < MAX_NUMBER_OF_CARDS_FOR_DEALER_HAND;
    }
}
