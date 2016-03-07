package com.marflo.service.texasholdem.winnerservice.exception;

public class TexasHoldemException extends RuntimeException {

    private Error error;

    public TexasHoldemException(Error error) {
        super(error.getDescription());
        this.error = error;
    }

    public TexasHoldemException(Error error, Throwable throwable) {
        super(error.getDescription(), throwable);
        this.error = error;
    }

    public Error getError() {
        return error;
    }

    @Override
    public String toString() {
        return "TexasHoldemException{" +
                "error=" + error +
                '}';
    }
}
