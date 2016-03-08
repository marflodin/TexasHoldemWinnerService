package com.marflo.service.texasholdem.winnerservice.logic;

import com.marflo.service.texasholdem.winnerservice.api.WinnersRequest;
import com.marflo.service.texasholdem.winnerservice.api.WinnersResponse;

public interface CalculateWinner {
    WinnersResponse calculateWinner(WinnersRequest request);
}
