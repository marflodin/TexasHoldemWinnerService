package com.marflo.service.texasholdem.winnerservice.entity.score;


import com.marflo.service.texasholdem.winnerservice.entity.card.Card;
import com.marflo.service.texasholdem.winnerservice.entity.card.Rank;
import com.marflo.service.texasholdem.winnerservice.entity.card.Suit;
import com.marflo.service.texasholdem.winnerservice.entity.hand.DealerHand;
import com.marflo.service.texasholdem.winnerservice.entity.hand.PlayerHand;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertFalse;

public class PairTest {

    Pair pair;
    PlayerHand playerHand;
    DealerHand dealerHand;

    @Before
    public void setup() {
        playerHand = new PlayerHand();
        dealerHand = new DealerHand();
        pair = new Pair(playerHand, dealerHand);
    }

    @Test
    public void noPairOnHand_DoesNotMeetConditions() {

        playerHand.addCard(new Card(Suit.DIAMONDS, Rank.DEUCE));
        playerHand.addCard(new Card(Suit.DIAMONDS, Rank.THREE));

        dealerHand.addCard(new Card(Suit.CLUBS, Rank.EIGHT));
        dealerHand.addCard(new Card(Suit.CLUBS, Rank.NINE));
        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.TEN));

        boolean meetsConditions = pair.meetsConditions();
        assertFalse(meetsConditions);
    }

    @Test
    public void pairOnPlayerHand_MeetsConditions() {

        playerHand.addCard(new Card(Suit.DIAMONDS, Rank.DEUCE));
        playerHand.addCard(new Card(Suit.CLUBS, Rank.DEUCE));

        dealerHand.addCard(new Card(Suit.CLUBS, Rank.EIGHT));
        dealerHand.addCard(new Card(Suit.CLUBS, Rank.NINE));
        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.TEN));

        boolean meetsConditions = pair.meetsConditions();
        assertTrue(meetsConditions);
    }

    @Test
    public void pairOnDealerHand_MeetsConditions() {

        playerHand.addCard(new Card(Suit.DIAMONDS, Rank.DEUCE));
        playerHand.addCard(new Card(Suit.DIAMONDS, Rank.THREE));

        dealerHand.addCard(new Card(Suit.CLUBS, Rank.EIGHT));
        dealerHand.addCard(new Card(Suit.CLUBS, Rank.NINE));
        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.EIGHT));

        boolean meetsConditions = pair.meetsConditions();
        assertTrue(meetsConditions);
    }

    @Test
    public void pairFromCombinationOfPlayerAndDealerHand_MeetsConditions() {

        playerHand.addCard(new Card(Suit.DIAMONDS, Rank.DEUCE));
        playerHand.addCard(new Card(Suit.DIAMONDS, Rank.THREE));

        dealerHand.addCard(new Card(Suit.CLUBS, Rank.THREE));
        dealerHand.addCard(new Card(Suit.CLUBS, Rank.NINE));
        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.TEN));

        boolean meetsConditions = pair.meetsConditions();
        assertTrue(meetsConditions);
    }

    @Test
    public void threeOfAKindOnHand_MeetsConditions() {

        playerHand.addCard(new Card(Suit.DIAMONDS, Rank.DEUCE));
        playerHand.addCard(new Card(Suit.HEARTS, Rank.DEUCE));

        dealerHand.addCard(new Card(Suit.CLUBS, Rank.DEUCE));
        dealerHand.addCard(new Card(Suit.CLUBS, Rank.NINE));
        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.TEN));

        boolean meetsConditions = pair.meetsConditions();
        assertTrue(meetsConditions);
    }

    @Test
    public void twoPairsOnHand_MeetsConditions() {

        playerHand.addCard(new Card(Suit.DIAMONDS, Rank.DEUCE));
        playerHand.addCard(new Card(Suit.HEARTS, Rank.DEUCE));

        dealerHand.addCard(new Card(Suit.CLUBS, Rank.EIGHT));
        dealerHand.addCard(new Card(Suit.CLUBS, Rank.NINE));
        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.EIGHT));

        boolean meetsConditions = pair.meetsConditions();
        assertTrue(meetsConditions);
    }
}
