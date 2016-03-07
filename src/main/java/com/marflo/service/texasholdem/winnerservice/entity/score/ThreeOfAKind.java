package com.marflo.service.texasholdem.winnerservice.entity.score;

import com.marflo.service.texasholdem.winnerservice.entity.card.Rank;
import com.marflo.service.texasholdem.winnerservice.entity.hand.DealerHand;
import com.marflo.service.texasholdem.winnerservice.entity.hand.PlayerHand;

public class ThreeOfAKind extends Score {

    public ThreeOfAKind(PlayerHand playerHand, DealerHand dealerHand) {
        super(playerHand, dealerHand);
    }

    public int getPoints() {
        return 3;
    }

    public boolean meetsConditions() {
        for (Rank rank : Rank.values()) {
            if (meetsConditionsForRank(rank))
                return true;
        }
        return false;
    }

    protected boolean meetsConditionsForRank(Rank rank) {
        return getNumberOfCardsMatchingRank(rank) >= 3;
    }
}
