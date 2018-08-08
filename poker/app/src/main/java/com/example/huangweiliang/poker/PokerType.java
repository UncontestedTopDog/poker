package com.example.huangweiliang.poker;

public enum PokerType {
    ILLEGAL(0),
    SINGLE(1),
    DOUBLE(2),
    TRIPLE(3),
    STRAIGHT(4),
    FLUSH(5),
    FULL(6),
    FOUROFAKIND(7),
    STRAIGHTFLUSH(8);

    private int value;

    PokerType(int value){
        this.value=value;
    }

    public int getValue() {
        return value;
    }
}
