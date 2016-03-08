package com.marflo.service.texasholdem.winnerservice.entity.score;

import com.marflo.service.texasholdem.winnerservice.entity.card.Suit;
import com.marflo.service.texasholdem.winnerservice.entity.hand.DealerHand;
import com.marflo.service.texasholdem.winnerservice.entity.hand.PlayerHand;

public class Flush extends Score {

    public Flush(PlayerHand playerHand, DealerHand dealerHand) {
        super(playerHand, dealerHand);
    }

    public int getPoints() {
        return 5;
    }

    public boolean meetsConditions() {
        for (Suit suit : Suit.values()) {
            if (enoughCardsOfSuit(suit))
                return true;
        }
        return  false;
    }

    private boolean enoughCardsOfSuit(Suit suit) {
        return getNumberOfCardsMatchingSuit(suit) >= 5;
    }
}
