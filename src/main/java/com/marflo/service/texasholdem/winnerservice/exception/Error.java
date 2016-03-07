package com.marflo.service.texasholdem.winnerservice.exception;


public enum Error {

    HAND_ALREADY_FULL(1, "No more cards can be added to the hand since it is already filled."),
    DECK_ALREADY_EMPTY(2, "No cards can be drawn from deck since the deck is already empty"),
    HAND_CONTAINS_DUPLICATE_CARD(3, "Trying to add a card that already exists on hand"),
    NOT_ENOUGH_MONEY_AVALIABLE(4, "Not enough money avaliable for withdrawal"),
    INVALID_AMOUNT(5, "The amount does not meet the required conditions"),
    INVALID_PLAYER(6, "Player is not valid for action"),
    NOT_ENOUGH_PLAYERS_AT_TABLE(7, "Not enough players available at table"),
    FULL_TABLE(8, "Table is already full"),
    NO_PLAYER_AT_SEAT(9, "No player at selected seat"),

    DAO_COULD_NOT_FETCH_RESULTS(10, "Could not fetch the requested results correctly from datasource"),

    UNEXPECTED_EXCEPTION(100, "An unexpected exception has occured");

    private final int code;
    private final String description;

    Error(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return code + ": " + description;
    }
}
