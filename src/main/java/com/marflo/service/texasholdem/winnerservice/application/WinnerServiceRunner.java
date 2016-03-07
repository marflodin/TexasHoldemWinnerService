package com.marflo.service.texasholdem.winnerservice.application;

import com.marflo.service.texasholdem.winnerservice.configuration.WinnerServiceConfiguration;
import com.marflo.service.texasholdem.winnerservice.endpoint.WinnerService;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class WinnerServiceRunner extends Application<WinnerServiceConfiguration> {

    public static void main(String[] args) throws Exception {
        //new WinnerServiceRunner().run(args);
        new WinnerServiceRunner().run("server");
    }

    @Override
    public void initialize(Bootstrap<WinnerServiceConfiguration> bootstrap) {
    }

    @Override
    public void run(WinnerServiceConfiguration winnerServiceConfiguration, Environment environment) throws Exception {
        final WinnerService endpoint = new WinnerService();
        environment.jersey().register(endpoint);
    }
}
