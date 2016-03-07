package com.marflo.service.texasholdem.winnerservice.entity.score;


import com.marflo.service.texasholdem.winnerservice.entity.card.Rank;
import com.marflo.service.texasholdem.winnerservice.entity.hand.DealerHand;
import com.marflo.service.texasholdem.winnerservice.entity.hand.PlayerHand;

public class TwoPair extends Score {

    Pair pair;

    public TwoPair(PlayerHand playerHand, DealerHand dealerHand) {
        super(playerHand, dealerHand);
        pair = new Pair(playerHand, dealerHand);
    }

    public int getPoints() {
        return 2;
    }

    public boolean meetsConditions() {
        int numberOfPairs = 0;
        for (Rank rank : Rank.values()) {
            if (pair.meetsConditionsForRank(rank))
                numberOfPairs++;
        }
        return numberOfPairs >= 2;
    }
}
