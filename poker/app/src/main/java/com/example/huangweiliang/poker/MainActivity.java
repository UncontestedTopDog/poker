package com.example.huangweiliang.poker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Poker poker1 = new Poker(PokerSuit.Club,PokerRank.SIX);
        Poker poker2 = new Poker(PokerSuit.Diamond,PokerRank.SEVEN);
        Poker poker3 = new Poker(PokerSuit.Club,PokerRank.EIGHT);
        Poker poker4 = new Poker(PokerSuit.Spade,PokerRank.FOUR);
        Poker poker5 = new Poker(PokerSuit.Club,PokerRank.FIVE);
        ArrayList<Poker> pokers = new ArrayList<>();
        pokers.add(poker1);
        pokers.add(poker2);
        pokers.add(poker3);
        pokers.add(poker4);
        pokers.add(poker5);
        Log.i("ASDASD",pokers.toString());
        PokerUtils.sortPokers(pokers);
        Log.i("ASDASD",pokers.toString());
        Log.i("ASDASD",PokerUtils.checkType(pokers)+"");
    }
}