package com.marflo.service.texasholdem.winnerservice.entity.score;


import com.marflo.service.texasholdem.winnerservice.entity.card.Rank;
import com.marflo.service.texasholdem.winnerservice.entity.hand.DealerHand;
import com.marflo.service.texasholdem.winnerservice.entity.hand.PlayerHand;

public class Straight extends Score {

    int maxNumbersInARow;

    public Straight(PlayerHand playerHand, DealerHand dealerHand) {
        super(playerHand, dealerHand);
    }

    public int getPoints() {
        return 4;
    }

    public boolean meetsConditions() {
        maxNumbersInARow = 0;
        int numbersInARow = 0;
        for (Rank rank : Rank.values()) {
            if (hasCardMatchingRank(rank))
                numbersInARow++;
            else {
                calculateMaxNumbersInARow(numbersInARow);
                numbersInARow = 0;
            }
        }
        calculateMaxNumbersInARow(numbersInARow);
        return determineIfConditionsAreMet();
    }

    private boolean hasCardMatchingRank(Rank rank) {
        return getNumberOfCardsMatchingRank(rank) >= 1;
    }

    private void calculateMaxNumbersInARow(int numbersInARow) {
        maxNumbersInARow = Math.max(maxNumbersInARow, numbersInARow);
    }

    private boolean determineIfConditionsAreMet() {
        if (maxNumbersInARow >= 5)
            return true;
        else if (isStraightWithAceCountedAsOne())
            return true;
        else
            return false;
    }

    private boolean isStraightWithAceCountedAsOne() {
        return hasCardMatchingRank(Rank.ACE) &&
                hasCardMatchingRank(Rank.DEUCE) &&
                hasCardMatchingRank(Rank.THREE) &&
                hasCardMatchingRank(Rank.FOUR) &&
                hasCardMatchingRank(Rank.FIVE);
    }
}
