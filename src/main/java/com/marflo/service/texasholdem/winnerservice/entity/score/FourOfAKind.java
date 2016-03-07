package com.marflo.service.texasholdem.winnerservice.entity.score;

import com.marflo.service.texasholdem.winnerservice.entity.card.Rank;
import com.marflo.service.texasholdem.winnerservice.entity.hand.DealerHand;
import com.marflo.service.texasholdem.winnerservice.entity.hand.PlayerHand;

public class FourOfAKind extends Score {

    public FourOfAKind(PlayerHand playerHand, DealerHand dealerHand) {
        super(playerHand, dealerHand);
    }

    public int getPoints() {
        return 7;
    }

    public boolean meetsConditions() {
        for (Rank rank : Rank.values()) {
            if (meetsConditionsForRank(rank))
                return true;
        }
        return false;
    }

    protected boolean meetsConditionsForRank(Rank rank) {
        return getNumberOfCardsMatchingRank(rank) >= 4;
    }
}
