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

public class ThreeOfAKindTest {

    ThreeOfAKind threeOfAKind;
    PlayerHand playerHand;
    DealerHand dealerHand;

    @Before
    public void setup() {
        playerHand = new PlayerHand();
        dealerHand = new DealerHand();
        threeOfAKind = new ThreeOfAKind(playerHand, dealerHand);
    }

    @Test
    public void pairOnHand_DoesNotMeetConditions() {

        playerHand.addCard(new Card(Suit.DIAMONDS, Rank.DEUCE));
        playerHand.addCard(new Card(Suit.HEARTS, Rank.DEUCE));

        dealerHand.addCard(new Card(Suit.CLUBS, Rank.EIGHT));
        dealerHand.addCard(new Card(Suit.CLUBS, Rank.NINE));
        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.TEN));

        boolean meetsConditions = threeOfAKind.meetsConditions();
        assertFalse(meetsConditions);
    }

    @Test
    public void threeOfAKindOnHand_MeetsConditions() {

        playerHand.addCard(new Card(Suit.DIAMONDS, Rank.DEUCE));
        playerHand.addCard(new Card(Suit.HEARTS, Rank.DEUCE));

        dealerHand.addCard(new Card(Suit.CLUBS, Rank.DEUCE));
        dealerHand.addCard(new Card(Suit.CLUBS, Rank.NINE));
        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.TEN));

        boolean meetsConditions = threeOfAKind.meetsConditions();
        assertTrue(meetsConditions);
    }

    @Test
    public void threeOfAKindOnDealerHand_MeetsConditions() {

        playerHand.addCard(new Card(Suit.DIAMONDS, Rank.DEUCE));
        playerHand.addCard(new Card(Suit.HEARTS, Rank.THREE));

        dealerHand.addCard(new Card(Suit.HEARTS, Rank.NINE));
        dealerHand.addCard(new Card(Suit.CLUBS, Rank.NINE));
        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.NINE));

        boolean meetsConditions = threeOfAKind.meetsConditions();
        assertTrue(meetsConditions);
    }

    @Test
    public void fullHouseOnHand_MeetsConditions() {

        playerHand.addCard(new Card(Suit.DIAMONDS, Rank.DEUCE));
        playerHand.addCard(new Card(Suit.HEARTS, Rank.DEUCE));

        dealerHand.addCard(new Card(Suit.HEARTS, Rank.NINE));
        dealerHand.addCard(new Card(Suit.CLUBS, Rank.NINE));
        dealerHand.addCard(new Card(Suit.DIAMONDS, Rank.NINE));

        boolean meetsConditions = threeOfAKind.meetsConditions();
        assertTrue(meetsConditions);
    }
}
