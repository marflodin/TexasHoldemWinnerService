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

public class FullHouseTest {

    FullHouse fullHouse;
    PlayerHand playerHand;
    DealerHand dealerHand;

    @Before
    public void setup() {
        playerHand = new PlayerHand();
        dealerHand = new DealerHand();
        fullHouse = new FullHouse(playerHand, dealerHand);
    }

    @Test
    public void noCardsOnHand_DoesNotMeetConditions() {
        boolean meetsConditions = fullHouse.meetsConditions();
        assertFalse(meetsConditions);
    }

    @Test
    public void twoPairOnHand_DoesNotMeetConditions() {
        playerHand.addCard(new Card(Suit.SPADES, Rank.SIX));
        playerHand.addCard(new Card(Suit.DIAMONDS, Rank.JACK));

        dealerHand.addCard(new Card(Suit.CLUBS, Rank.SIX));
        dealerHand.addCard(new Card(Suit.CLUBS, Rank.JACK));
        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.ACE));
        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.THREE));
        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.FIVE));

        boolean meetsConditions = fullHouse.meetsConditions();
        assertFalse(meetsConditions);
    }

    @Test
    public void threePairOnHand_DoesNotMeetConditions() {
        playerHand.addCard(new Card(Suit.SPADES, Rank.SIX));
        playerHand.addCard(new Card(Suit.DIAMONDS, Rank.JACK));

        dealerHand.addCard(new Card(Suit.CLUBS, Rank.SIX));
        dealerHand.addCard(new Card(Suit.CLUBS, Rank.JACK));
        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.ACE));
        dealerHand.addCard(new Card(Suit.HEARTS, Rank.ACE));
        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.FIVE));

        boolean meetsConditions = fullHouse.meetsConditions();
        assertFalse(meetsConditions);
    }

    @Test
    public void threeOfAKindOnHand_DoesNotMeetConditions() {
        playerHand.addCard(new Card(Suit.SPADES, Rank.SIX));
        playerHand.addCard(new Card(Suit.DIAMONDS, Rank.SIX));

        dealerHand.addCard(new Card(Suit.CLUBS, Rank.SIX));
        dealerHand.addCard(new Card(Suit.CLUBS, Rank.JACK));
        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.ACE));
        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.THREE));
        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.FIVE));

        boolean meetsConditions = fullHouse.meetsConditions();
        assertFalse(meetsConditions);
    }

    @Test
    public void fullHouseOnHand_MeetsConditions() {
        playerHand.addCard(new Card(Suit.SPADES, Rank.SIX));
        playerHand.addCard(new Card(Suit.DIAMONDS, Rank.SIX));

        dealerHand.addCard(new Card(Suit.CLUBS, Rank.SIX));
        dealerHand.addCard(new Card(Suit.CLUBS, Rank.JACK));
        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.JACK));
        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.THREE));
        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.FIVE));

        boolean meetsConditions = fullHouse.meetsConditions();
        assertTrue(meetsConditions);
    }

    @Test
    public void twoThreeOfAKindOnHand_MeetsConditions() {
        playerHand.addCard(new Card(Suit.SPADES, Rank.SIX));
        playerHand.addCard(new Card(Suit.DIAMONDS, Rank.SIX));

        dealerHand.addCard(new Card(Suit.CLUBS, Rank.SIX));
        dealerHand.addCard(new Card(Suit.CLUBS, Rank.JACK));
        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.JACK));
        dealerHand.addCard(new Card(Suit.HEARTS, Rank.JACK));
        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.FIVE));

        boolean meetsConditions = fullHouse.meetsConditions();
        assertTrue(meetsConditions);
    }
}
