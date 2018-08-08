package com.example.huangweiliang.poker;

public enum PokerRank {
    THREE(0),
    TWO(1),
    ACE(2),
    KING(3),
    QUEEEN(4),
    JACK(5),
    TEN(6),
    NINE(7),
    EIGHT(8),
    SEVEN(9),
    SIX(10),
    FIVE(11),
    FOUR(12);
    private int value;

    PokerRank(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
