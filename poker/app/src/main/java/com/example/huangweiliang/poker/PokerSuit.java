package com.example.huangweiliang.poker;

public enum PokerSuit {
    Diamond(0),
    Spade(1),
    Heart(2),
    Club(3);

    private int value;

    PokerSuit(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
