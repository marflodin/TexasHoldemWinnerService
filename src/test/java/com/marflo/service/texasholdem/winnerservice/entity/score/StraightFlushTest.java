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

public class StraightFlushTest {

    StraightFlush straightFlush;
    PlayerHand playerHand;
    DealerHand dealerHand;

    @Before
    public void setup() {
        playerHand = new PlayerHand();
        dealerHand = new DealerHand();
        straightFlush = new StraightFlush(playerHand, dealerHand);
    }

    @Test
    public void fiveStraightOnHandDifferentSuits_DoesNotMeetConditions() {
        playerHand.addCard(new Card(Suit.SPADES, Rank.DEUCE));
        playerHand.addCard(new Card(Suit.DIAMONDS, Rank.FOUR));

        dealerHand.addCard(new Card(Suit.CLUBS, Rank.THREE));
        dealerHand.addCard(new Card(Suit.CLUBS, Rank.EIGHT));
        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.TEN));
        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.SIX));
        dealerHand.addCard(new Card(Suit.HEARTS, Rank.FIVE));

        boolean meetsConditions = straightFlush.meetsConditions();
        assertFalse(meetsConditions);
    }

    @Test
    public void fiveCardsOfSameSuit_DoesNotMeetConditions() {
        playerHand.addCard(new Card(Suit.DIAMONDS, Rank.DEUCE));
        playerHand.addCard(new Card(Suit.DIAMONDS, Rank.JACK));

        dealerHand.addCard(new Card(Suit.CLUBS, Rank.QUEEN));
        dealerHand.addCard(new Card(Suit.CLUBS, Rank.SIX));
        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.ACE));
        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.SIX));
        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.FIVE));

        boolean meetsConditions = straightFlush.meetsConditions();
        assertFalse(meetsConditions);
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

        boolean meetsConditions = straightFlush.meetsConditions();
        assertTrue(meetsConditions);
    }

    @Test
    public void pairOnStraightFlush_MeetsConditions() {
        playerHand.addCard(new Card(Suit.HEARTS, Rank.DEUCE));
        playerHand.addCard(new Card(Suit.SPADES, Rank.DEUCE));

        dealerHand.addCard(new Card(Suit.SPADES, Rank.THREE));
        dealerHand.addCard(new Card(Suit.SPADES, Rank.FOUR));
        dealerHand.addCard(new Card(Suit.SPADES, Rank.FIVE));
        dealerHand.addCard(new Card(Suit.SPADES, Rank.SIX));
        dealerHand.addCard(new Card(Suit.SPADES, Rank.KING));

        boolean meetsConditions = straightFlush.meetsConditions();
        assertTrue(meetsConditions);
    }

    @Test
    public void fiveStraightOnHandSameSuitAceHigh_MeetsConditions() {
        playerHand.addCard(new Card(Suit.SPADES, Rank.TEN));
        playerHand.addCard(new Card(Suit.SPADES, Rank.JACK));

        dealerHand.addCard(new Card(Suit.SPADES, Rank.QUEEN));
        dealerHand.addCard(new Card(Suit.SPADES, Rank.KING));
        dealerHand.addCard(new Card(Suit.SPADES, Rank.ACE));
        dealerHand.addCard(new Card(Suit.SPADES, Rank.SIX));
        dealerHand.addCard(new Card(Suit.SPADES, Rank.FIVE));

        boolean meetsConditions = straightFlush.meetsConditions();
        assertTrue(meetsConditions);
    }

    @Test
    public void fiveStraightOnHandSameSuitAceLow_MeetsConditions() {
        playerHand.addCard(new Card(Suit.SPADES, Rank.ACE));
        playerHand.addCard(new Card(Suit.SPADES, Rank.DEUCE));

        dealerHand.addCard(new Card(Suit.SPADES, Rank.THREE));
        dealerHand.addCard(new Card(Suit.SPADES, Rank.FOUR));
        dealerHand.addCard(new Card(Suit.SPADES, Rank.FIVE));
        dealerHand.addCard(new Card(Suit.SPADES, Rank.EIGHT));
        dealerHand.addCard(new Card(Suit.SPADES, Rank.TEN));

        boolean meetsConditions = straightFlush.meetsConditions();
        assertTrue(meetsConditions);
    }

    @Test
    public void fiveStraightOnHandDifferentSuitsAceLow_DoesNotMeetConditions() {
        playerHand.addCard(new Card(Suit.HEARTS, Rank.ACE));
        playerHand.addCard(new Card(Suit.SPADES, Rank.DEUCE));

        dealerHand.addCard(new Card(Suit.SPADES, Rank.THREE));
        dealerHand.addCard(new Card(Suit.SPADES, Rank.FOUR));
        dealerHand.addCard(new Card(Suit.SPADES, Rank.FIVE));
        dealerHand.addCard(new Card(Suit.SPADES, Rank.EIGHT));
        dealerHand.addCard(new Card(Suit.SPADES, Rank.TEN));

        boolean meetsConditions = straightFlush.meetsConditions();
        assertFalse(meetsConditions);
    }
}