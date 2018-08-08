package com.example.huangweiliang.poker;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;

public class PokerUtils {

    private static String TAG = "PokerUtils";

    public static PokerType checkType(ArrayList<Poker> pokers) {
        PokerType pokerType = PokerType.ILLEGAL;
        if (pokers.size() > 5)
            pokerType = PokerType.ILLEGAL;
        else if (pokers.size() == 1)
            pokerType = PokerType.SINGLE;
        else if (pokers.size() == 2) {
            if (pokers.get(0).isSameRank(pokers.get(1)))
                pokerType = PokerType.DOUBLE;
        } else if (pokers.size() == 3) {
            if (pokers.get(0).isSameRank(pokers.get(1)) && pokers.get(1).isSameRank(pokers.get(2)))
                pokerType = PokerType.TRIPLE;
        } else if (pokers.size() == 4) {
            Log.i(TAG, "pokers quantity is 4");
        } else if (pokers.size() == 5) {
            pokerType = checkCombination(pokers);
        }
        return pokerType;
    }

    public static PokerType checkCombination(ArrayList<Poker> pokers) {
        PokerType pokerType = PokerType.ILLEGAL;
        sortPokers(pokers);
        if (checkFull(pokers))
            pokerType = PokerType.FULL;
        else if (checkFourOfKind(pokers)) {
            pokerType = PokerType.FOUROFAKIND;
        } else if (checkFlush(pokers)) {
            if (checkStraight(pokers))
                pokerType = PokerType.STRAIGHTFLUSH;
            else
                pokerType = PokerType.FLUSH;
        } else if (checkStraight(pokers))
            pokerType = PokerType.STRAIGHT;
        return pokerType;
    }

    private static boolean checkStraight(ArrayList<Poker> pokers) {
        if (pokers.get(0).compareTo(pokers.get(1)) == -10
                && pokers.get(1).compareTo(pokers.get(2)) == -10
                && pokers.get(2).compareTo(pokers.get(3)) == -10
                && pokers.get(3).compareTo(pokers.get(4)) == -10) {
            if (pokers.get(0).getmPokerRank() == PokerRank.THREE && pokers.get(3).getmPokerRank() == PokerRank.KING)
                return false;
            else if (pokers.get(0).getmPokerRank() == PokerRank.TWO && pokers.get(2).getmPokerRank() == PokerRank.KING)
                return false;
            else
                return true;
        } else {
            if (pokers.get(0).getmPokerRank() == PokerRank.THREE
                    && pokers.get(1).getmPokerRank() == PokerRank.TWO
                    && pokers.get(2).getmPokerRank() == PokerRank.ACE
                    && pokers.get(3).getmPokerRank() == PokerRank.FIVE
                    && pokers.get(4).getmPokerRank() == PokerRank.FOUR)
                return true;
            else if (pokers.get(0).getmPokerRank() == PokerRank.THREE
                    && pokers.get(1).getmPokerRank() == PokerRank.TWO
                    && pokers.get(2).getmPokerRank() == PokerRank.SIX
                    && pokers.get(3).getmPokerRank() == PokerRank.FIVE
                    && pokers.get(4).getmPokerRank() == PokerRank.FOUR)
                return true;
            else if (pokers.get(0).getmPokerRank() == PokerRank.THREE
                    && pokers.get(1).getmPokerRank() == PokerRank.SEVEN
                    && pokers.get(2).getmPokerRank() == PokerRank.SIX
                    && pokers.get(3).getmPokerRank() == PokerRank.FIVE
                    && pokers.get(4).getmPokerRank() == PokerRank.FOUR)
                return true;
            else
                return false;
        }
    }

    private static boolean checkFlush(ArrayList<Poker> pokers) {
        if (pokers.get(0).isSameSuit(pokers.get(1))
                && pokers.get(1).isSameSuit(pokers.get(2))
                && pokers.get(2).isSameSuit(pokers.get(3))
                && pokers.get(3).isSameSuit(pokers.get(4)))
            return true;
        else return false;
    }

    private static boolean checkFourOfKind(ArrayList<Poker> pokers) {
        if (pokers.get(0).isSameRank(pokers.get(1))
                && pokers.get(1).isSameRank(pokers.get(2))
                && pokers.get(2).isSameRank(pokers.get(3))
                || pokers.get(1).isSameRank(pokers.get(2))
                && pokers.get(2).isSameRank(pokers.get(3))
                && pokers.get(3).isSameRank(pokers.get(4)))
            return true;
        else return false;
    }

    private static boolean checkFull(ArrayList<Poker> pokers) {
        if (pokers.get(0).isSameRank(pokers.get(1))
                && pokers.get(1).isSameRank(pokers.get(2))
                && pokers.get(3).isSameRank(pokers.get(4))
                || pokers.get(0).isSameRank(pokers.get(1))
                && pokers.get(2).isSameRank(pokers.get(3))
                && pokers.get(3).isSameRank(pokers.get(4)))
            return true;
        else return false;
    }

    public static ArrayList<Poker> sortPokers(ArrayList<Poker> pokers) {
        Collections.sort(pokers);
        return pokers;
    }

}
