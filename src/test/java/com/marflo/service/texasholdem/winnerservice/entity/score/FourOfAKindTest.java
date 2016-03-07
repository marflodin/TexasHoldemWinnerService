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

public class FourOfAKindTest {

    FourOfAKind fourOfAKind;
    PlayerHand playerHand;
    DealerHand dealerHand;

    @Before
    public void setup() {
        playerHand = new PlayerHand();
        dealerHand = new DealerHand();
        fourOfAKind = new FourOfAKind(playerHand, dealerHand);
    }

    @Test
    public void threeOfAKindOnHand_DoesNotMeetConditions() {
        playerHand.addCard(new Card(Suit.DIAMONDS, Rank.DEUCE));
        playerHand.addCard(new Card(Suit.HEARTS, Rank.DEUCE));

        dealerHand.addCard(new Card(Suit.CLUBS, Rank.DEUCE));
        dealerHand.addCard(new Card(Suit.CLUBS, Rank.NINE));
        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.TEN));
        dealerHand.addCard(new Card(Suit.HEARTS, Rank.ACE));
        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.FIVE));

        boolean meetsConditions = fourOfAKind.meetsConditions();
        assertFalse(meetsConditions);
    }

    @Test
    public void fourOfAKindOnHand_MeetsConditions() {
        playerHand.addCard(new Card(Suit.DIAMONDS, Rank.DEUCE));
        playerHand.addCard(new Card(Suit.HEARTS, Rank.DEUCE));

        dealerHand.addCard(new Card(Suit.CLUBS, Rank.DEUCE));
        dealerHand.addCard(new Card(Suit.SPADES, Rank.DEUCE));
        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.TEN));
        dealerHand.addCard(new Card(Suit.HEARTS, Rank.ACE));
        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.FIVE));

        boolean meetsConditions = fourOfAKind.meetsConditions();
        assertTrue(meetsConditions);
    }
}
