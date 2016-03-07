package com.marflo.service.texasholdem.winnerservice.entity.score;

import com.marflo.service.texasholdem.winnerservice.entity.card.Card;
import com.marflo.service.texasholdem.winnerservice.entity.card.Rank;
import com.marflo.service.texasholdem.winnerservice.entity.card.Suit;
import com.marflo.service.texasholdem.winnerservice.entity.hand.DealerHand;
import com.marflo.service.texasholdem.winnerservice.entity.hand.PlayerHand;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TwoPairTest {

    TwoPair twoPair;
    PlayerHand playerHand;
    DealerHand dealerHand;

    @Before
    public void setup() {
        playerHand = new PlayerHand();
        dealerHand = new DealerHand();
        twoPair = new TwoPair(playerHand, dealerHand);
    }

    @Test
    public void noTwoPairOnHand_DoesNotMeetConditions() {
        playerHand.addCard(new Card(Suit.DIAMONDS, Rank.DEUCE));
        playerHand.addCard(new Card(Suit.DIAMONDS, Rank.THREE));

        dealerHand.addCard(new Card(Suit.CLUBS, Rank.EIGHT));
        dealerHand.addCard(new Card(Suit.CLUBS, Rank.NINE));
        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.TEN));

        boolean meetsConditions = twoPair.meetsConditions();
        assertFalse(meetsConditions);
    }

    @Test
    public void pairOnHand_DoesNotMeetConditions() {
        playerHand.addCard(new Card(Suit.DIAMONDS, Rank.DEUCE));
        playerHand.addCard(new Card(Suit.HEARTS, Rank.DEUCE));

        dealerHand.addCard(new Card(Suit.CLUBS, Rank.EIGHT));
        dealerHand.addCard(new Card(Suit.CLUBS, Rank.NINE));
        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.TEN));

        boolean meetsConditions = twoPair.meetsConditions();
        assertFalse(meetsConditions);
    }

    @Test
    public void twoPairOnHandOnePerHand_MeetsConditions() {
        playerHand.addCard(new Card(Suit.DIAMONDS, Rank.DEUCE));
        playerHand.addCard(new Card(Suit.HEARTS, Rank.DEUCE));

        dealerHand.addCard(new Card(Suit.CLUBS, Rank.EIGHT));
        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.EIGHT));
        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.TEN));

        boolean meetsConditions = twoPair.meetsConditions();
        assertTrue(meetsConditions);
    }

    @Test
    public void twoPairOnHandMixed_MeetsConditions() {
        playerHand.addCard(new Card(Suit.DIAMONDS, Rank.DEUCE));
        playerHand.addCard(new Card(Suit.HEARTS, Rank.EIGHT));

        dealerHand.addCard(new Card(Suit.CLUBS, Rank.DEUCE));
        dealerHand.addCard(new Card(Suit.CLUBS, Rank.EIGHT));
        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.TEN));

        boolean meetsConditions = twoPair.meetsConditions();
        assertTrue(meetsConditions);
    }

    @Test
    public void twoPairUsesThreeDealerCards_MeetsConditions() {
        playerHand.addCard(new Card(Suit.DIAMONDS, Rank.DEUCE));
        playerHand.addCard(new Card(Suit.HEARTS, Rank.THREE));

        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.EIGHT));
        dealerHand.addCard(new Card(Suit.CLUBS, Rank.EIGHT));
        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.THREE));
        dealerHand.addCard(new Card(Suit.HEARTS, Rank.FIVE));

        boolean meetsConditions = twoPair.meetsConditions();
        assertTrue(meetsConditions);
    }

    @Test
    public void twoPairUsesFourDealerCards_MeetsConditions() {
        playerHand.addCard(new Card(Suit.DIAMONDS, Rank.DEUCE));
        playerHand.addCard(new Card(Suit.HEARTS, Rank.THREE));

        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.EIGHT));
        dealerHand.addCard(new Card(Suit.CLUBS, Rank.EIGHT));
        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.TEN));
        dealerHand.addCard(new Card(Suit.HEARTS, Rank.TEN));

        boolean meetsConditions = twoPair.meetsConditions();
        assertTrue(meetsConditions);
    }
}
