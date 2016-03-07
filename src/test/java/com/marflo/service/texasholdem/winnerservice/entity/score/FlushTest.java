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

public class FlushTest {

    Flush flush;
    PlayerHand playerHand;
    DealerHand dealerHand;

    @Before
    public void setup() {
        playerHand = new PlayerHand();
        dealerHand = new DealerHand();
        flush = new Flush(playerHand, dealerHand);
    }

    @Test
    public void noCardsOnHand_DoesNotMeetConditions() {
        boolean meetsConditions = flush.meetsConditions();
        assertFalse(meetsConditions);
    }

    @Test
    public void fourCardsOfSameSuit_DoesNotMeetConditions() {
        playerHand.addCard(new Card(Suit.SPADES, Rank.DEUCE));
        playerHand.addCard(new Card(Suit.DIAMONDS, Rank.JACK));

        dealerHand.addCard(new Card(Suit.CLUBS, Rank.QUEEN));
        dealerHand.addCard(new Card(Suit.CLUBS, Rank.SIX));
        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.ACE));
        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.SIX));
        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.FIVE));

        boolean meetsConditions = flush.meetsConditions();
        assertFalse(meetsConditions);
    }

    @Test
    public void fiveCardsOfSameSuit_MeetsConditions() {
        playerHand.addCard(new Card(Suit.DIAMONDS, Rank.DEUCE));
        playerHand.addCard(new Card(Suit.DIAMONDS, Rank.JACK));

        dealerHand.addCard(new Card(Suit.CLUBS, Rank.QUEEN));
        dealerHand.addCard(new Card(Suit.CLUBS, Rank.SIX));
        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.ACE));
        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.SIX));
        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.FIVE));

        boolean meetsConditions = flush.meetsConditions();
        assertTrue(meetsConditions);
    }

    @Test
    public void eightCardsOfSameSuit_MeetsConditions() {
        playerHand.addCard(new Card(Suit.DIAMONDS, Rank.DEUCE));
        playerHand.addCard(new Card(Suit.DIAMONDS, Rank.JACK));

        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.QUEEN));
        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.SEVEN));
        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.ACE));
        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.SIX));
        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.FIVE));

        boolean meetsConditions = flush.meetsConditions();
        assertTrue(meetsConditions);
    }
}
