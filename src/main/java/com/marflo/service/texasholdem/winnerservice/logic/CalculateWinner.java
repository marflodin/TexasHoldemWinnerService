package com.marflo.service.texasholdem.winnerservice.logic;

import com.marflo.service.texasholdem.winnerservice.api.PlayerRequest;
import com.marflo.service.texasholdem.winnerservice.api.PlayerResponse;
import com.marflo.service.texasholdem.winnerservice.api.WinnersRequest;
import com.marflo.service.texasholdem.winnerservice.api.WinnersResponse;
import com.marflo.service.texasholdem.winnerservice.entity.card.Card;
import com.marflo.service.texasholdem.winnerservice.entity.hand.DealerHand;
import com.marflo.service.texasholdem.winnerservice.entity.hand.PlayerHand;
import com.marflo.service.texasholdem.winnerservice.entity.score.HandScore;

import java.util.ArrayList;
import java.util.List;

public class CalculateWinner {

    public WinnersResponse calculateWinner(WinnersRequest request) {

        List<PlayerRequest> players = request.getPlayers();
        DealerHand dealerHand = getDealerHandForRequest(request);
        List<PlayerResponse> playerResponses = new ArrayList<>();
        for (PlayerRequest player : request.getPlayers()) {
            PlayerHand playerHand = getPlayerHandForPlayerRequest(player);
            HandScore handScoreForPlayer = new HandScore(playerHand, dealerHand);
        }
        WinnersResponse response = new WinnersResponse(null);
        return response;
    }

    private DealerHand getDealerHandForRequest(WinnersRequest request) {
        DealerHand dealerHand = new DealerHand();
        List<Card> dealerCards = request.getDealerCards();
        for (Card dealerCard : dealerCards) {
            dealerHand.addCard(dealerCard);
        }
        return dealerHand;
    }

    private PlayerHand getPlayerHandForPlayerRequest(PlayerRequest playerRequest) {
        PlayerHand playerHand = new PlayerHand();
        for(Card playerCard : playerRequest.getCards()) {
            playerHand.addCard(playerCard);
        }
        return playerHand;
    }
}
