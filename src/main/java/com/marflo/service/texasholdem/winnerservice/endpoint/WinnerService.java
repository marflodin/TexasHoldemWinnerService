package com.marflo.service.texasholdem.winnerservice.endpoint;

import com.codahale.metrics.annotation.Timed;
import com.marflo.service.texasholdem.winnerservice.api.WinnersRequest;
import com.marflo.service.texasholdem.winnerservice.api.WinnersResponse;
import com.marflo.service.texasholdem.winnerservice.logic.CalculateWinner;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/calculate-winners/")
@Produces(MediaType.APPLICATION_JSON)
public class WinnerService {

    CalculateWinner calculateWinner = new CalculateWinner();

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Timed
    public Response getWinners(WinnersRequest request) {

        WinnersResponse response = calculateWinner.calculateWinner(request);

        return Response.ok()
                .entity(response)
                .build();
    }
}
