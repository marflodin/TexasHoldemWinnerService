package com.marflo.service.texasholdem.winnerservice.logic;

import com.marflo.service.texasholdem.winnerservice.api.PlayerRequest;
import com.marflo.service.texasholdem.winnerservice.api.WinnersRequest;
import com.marflo.service.texasholdem.winnerservice.api.WinnersResponse;
import com.marflo.service.texasholdem.winnerservice.entity.card.Card;
import com.marflo.service.texasholdem.winnerservice.entity.card.Rank;
import com.marflo.service.texasholdem.winnerservice.entity.card.Suit;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CalculateWinnerTest {

    WinnersRequest request;
    WinnersResponse response;
    WinnersResponse expectedResponse;
    List<Card> dealerCards;
    List<PlayerRequest> players;
    CalculateWinner calculateWinner = new CalculateWinner();
    static final String HAND_ID = "hand-id";

    @Before
    public void setup() {
        players = new ArrayList<>();
        dealerCards = new ArrayList<Card>() {{
            add(new Card(Suit.HEARTS, Rank.DEUCE));
            add(new Card(Suit.HEARTS, Rank.THREE));
            add(new Card(Suit.HEARTS, Rank.FOUR));
            add(new Card(Suit.SPADES, Rank.EIGHT));
            add(new Card(Suit.SPADES, Rank.ACE));
        }};
    }

    @Test
    public void whenOnlyOnePlayerReturnPlayerAsWinner() {
        List<Card> playerCards = new ArrayList<Card>() {{
            add(new Card(Suit.DIAMONDS, Rank.SEVEN));
            add(new Card(Suit.DIAMONDS, Rank.DEUCE));
        }};
        BigDecimal playerPotAmount = new BigDecimal(20);
        String playerId = "player1";
        players.add(new PlayerRequest(playerId, playerCards, playerPotAmount));
        request = new WinnersRequest(HAND_ID, players, dealerCards);
        response = calculateWinner.calculateWinner(request);
        expectedResponse = null;
        assertEquals(1, response.getPlayers().size());
        assertEquals(playerId, response.getPlayers().get(0).getPlayerId());
        assertEquals(playerPotAmount, response.getPlayers().get(0).getPotAmount());
    }


}