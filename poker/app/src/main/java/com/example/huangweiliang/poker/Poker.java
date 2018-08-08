package com.example.huangweiliang.poker;

import android.support.annotation.NonNull;

public class Poker implements Comparable<Poker> {
    private PokerSuit mPokerSuit;
    private PokerRank mPokerRank;


    public Poker(PokerSuit mPokerSuit, PokerRank mPokerRank) {
        this.mPokerSuit = mPokerSuit;
        this.mPokerRank = mPokerRank;
    }

    public PokerSuit getmPokerSuit() {
        return mPokerSuit;
    }

    public void setmPokerSuit(PokerSuit mPokerSuit) {
        this.mPokerSuit = mPokerSuit;
    }

    public PokerRank getmPokerRank() {
        return mPokerRank;
    }

    public void setmPokerRank(PokerRank mPokerRank) {
        this.mPokerRank = mPokerRank;
    }

    @Override
    public int compareTo(@NonNull Poker poker) {
        if(this.getmPokerRank()==poker.getmPokerRank())
            return this.getmPokerSuit().getValue()-poker.getmPokerSuit().getValue();
        return (this.getmPokerRank().getValue()-poker.getmPokerRank().getValue())*10;
    }

    public boolean isSameRank(@NonNull Poker poker){
        if(this.getmPokerRank()==poker.getmPokerRank())
            return true ;
        else return false;
    }
    public boolean isSameSuit(@NonNull Poker poker){
        if(this.getmPokerSuit()==poker.getmPokerSuit())
            return true ;
        else return false;
    }
}
