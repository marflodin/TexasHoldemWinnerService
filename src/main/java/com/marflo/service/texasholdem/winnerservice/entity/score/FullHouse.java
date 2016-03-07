package com.marflo.service.texasholdem.winnerservice.entity.score;


import com.marflo.service.texasholdem.winnerservice.entity.card.Rank;
import com.marflo.service.texasholdem.winnerservice.entity.hand.DealerHand;
import com.marflo.service.texasholdem.winnerservice.entity.hand.PlayerHand;

public class FullHouse extends Score {

    Pair pair;
    ThreeOfAKind threeOfAKind;

    public FullHouse(PlayerHand playerHand, DealerHand dealerHand) {
        super(playerHand, dealerHand);
        pair = new Pair(playerHand, dealerHand);
        threeOfAKind = new ThreeOfAKind(playerHand, dealerHand);
    }

    public int getPoints() {
        return 6;
    }

    public boolean meetsConditions() {
        boolean containsThreeOfAKind = false;
        boolean containsPair = false;
        for (Rank rank : Rank.values()) {
            if (!containsThreeOfAKind && threeOfAKind.meetsConditionsForRank(rank))
                containsThreeOfAKind = true;
            else if (pair.meetsConditionsForRank(rank))
                containsPair = true;
        }
        return containsPair && containsThreeOfAKind;
    }
}
