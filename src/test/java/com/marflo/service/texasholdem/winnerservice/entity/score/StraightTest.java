package com.marflo.service.texasholdem.winnerservice.entity.score;

import com.marflo.service.texasholdem.winnerservice.entity.card.Card;
import com.marflo.service.texasholdem.winnerservice.entity.card.Rank;
import com.marflo.service.texasholdem.winnerservice.entity.card.Suit;
import com.marflo.service.texasholdem.winnerservice.entity.hand.DealerHand;
import com.marflo.service.texasholdem.winnerservice.entity.hand.PlayerHand;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class StraightTest {

    Straight straight;
    PlayerHand playerHand;
    DealerHand dealerHand;

    @Before
    public void setup() {
        playerHand = new PlayerHand();
        dealerHand = new DealerHand();
        straight = new Straight(playerHand, dealerHand);
    }

    @Test
    public void oneStraightOnHand_DoesNotMeetConditions() {
        playerHand.addCard(new Card(Suit.DIAMONDS, Rank.DEUCE));
        playerHand.addCard(new Card(Suit.DIAMONDS, Rank.FOUR));

        dealerHand.addCard(new Card(Suit.CLUBS, Rank.SIX));
        dealerHand.addCard(new Card(Suit.CLUBS, Rank.EIGHT));
        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.TEN));
        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.QUEEN));
        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.ACE));

        boolean meetsConditions = straight.meetsConditions();
        assertFalse(meetsConditions);
    }

    @Test
    public void fourStraightOnHand_DoesNotMeetConditions() {
        playerHand.addCard(new Card(Suit.SPADES, Rank.DEUCE));
        playerHand.addCard(new Card(Suit.DIAMONDS, Rank.FOUR));

        dealerHand.addCard(new Card(Suit.CLUBS, Rank.THREE));
        dealerHand.addCard(new Card(Suit.CLUBS, Rank.EIGHT));
        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.TEN));
        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.QUEEN));
        dealerHand.addCard(new Card(Suit.HEARTS, Rank.FIVE));

        boolean meetsConditions = straight.meetsConditions();
        assertFalse(meetsConditions);
    }

    @Test
    public void fiveStraightOnHandDifferentSuits_MeetsConditions() {
        playerHand.addCard(new Card(Suit.SPADES, Rank.DEUCE));
        playerHand.addCard(new Card(Suit.DIAMONDS, Rank.FOUR));

        dealerHand.addCard(new Card(Suit.CLUBS, Rank.THREE));
        dealerHand.addCard(new Card(Suit.CLUBS, Rank.EIGHT));
        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.TEN));
        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.SIX));
        dealerHand.addCard(new Card(Suit.HEARTS, Rank.FIVE));

        boolean meetsConditions = straight.meetsConditions();
        assertTrue(meetsConditions);
    }

    @Test
    public void fiveStraightOnHandSameSuit_MeetsConditions() {
        playerHand.addCard(new Card(Suit.SPADES, Rank.DEUCE));
        playerHand.addCard(new Card(Suit.SPADES, Rank.FOUR));

        dealerHand.addCard(new Card(Suit.SPADES, Rank.THREE));
        dealerHand.addCard(new Card(Suit.SPADES, Rank.EIGHT));
        dealerHand.addCard(new Card(Suit.SPADES, Rank.TEN));
        dealerHand.addCard(new Card(Suit.SPADES, Rank.SIX));
        dealerHand.addCard(new Card(Suit.SPADES, Rank.FIVE));

        boolean meetsConditions = straight.meetsConditions();
        assertTrue(meetsConditions);
    }

    @Test
    public void fiveStraightOnHandAceHigh_MeetsConditions() {
        playerHand.addCard(new Card(Suit.SPADES, Rank.TEN));
        playerHand.addCard(new Card(Suit.DIAMONDS, Rank.JACK));

        dealerHand.addCard(new Card(Suit.CLUBS, Rank.QUEEN));
        dealerHand.addCard(new Card(Suit.CLUBS, Rank.KING));
        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.ACE));
        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.SIX));
        dealerHand.addCard(new Card(Suit.HEARTS, Rank.FIVE));

        boolean meetsConditions = straight.meetsConditions();
        assertTrue(meetsConditions);
    }

    @Test
    public void fiveStraightOnHandAceLow_MeetsConditions() {
        playerHand.addCard(new Card(Suit.SPADES, Rank.ACE));
        playerHand.addCard(new Card(Suit.DIAMONDS, Rank.DEUCE));

        dealerHand.addCard(new Card(Suit.CLUBS, Rank.THREE));
        dealerHand.addCard(new Card(Suit.CLUBS, Rank.FOUR));
        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.FIVE));
        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.EIGHT));
        dealerHand.addCard(new Card(Suit.HEARTS, Rank.TEN));

        boolean meetsConditions = straight.meetsConditions();
        assertTrue(meetsConditions);
    }
}
