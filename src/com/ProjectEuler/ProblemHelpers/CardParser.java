package com.ProjectEuler.ProblemHelpers;

/**
 * Created by deepanshu on 22/05/16, 10:39 AM.
 */
public class CardParser {
    private static final String OF = " of ";
    private static int[] ints = new int[90];
    private static String[] strs = new String[19];
    private static String[] minStrs = new String[19];

    static {
        ints['2'] = 2;
        ints['3'] = 3;
        ints['4'] = 4;
        ints['5'] = 5;
        ints['6'] = 6;
        ints['7'] = 7;
        ints['8'] = 8;
        ints['9'] = 9;
        ints['T'] = 10;
        ints['J'] = 11;
        ints['Q'] = 12;
        ints['K'] = 13;
        ints['A'] = 14;
        ints['C'] = 15;
        ints['D'] = 16;
        ints['S'] = 17;
        ints['H'] = 18;

        strs[2] = "Two";
        strs[3] = "Three";
        strs[4] = "Four";
        strs[5] = "Five";
        strs[6] = "Six";
        strs[7] = "Seven";
        strs[8] = "Eight";
        strs[9] = "Nine";
        strs[10] = "Ten";
        strs[11] = "Jack";
        strs[12] = "Queen";
        strs[13] = "King";
        strs[14] = "Ace";
        strs[15] = "Club";
        strs[16] = "Diamond";
        strs[17] = "Spade";
        strs[18] = "Heart";

        minStrs[2] = "2";
        minStrs[3] = "3";
        minStrs[4] = "4";
        minStrs[5] = "5";
        minStrs[6] = "6";
        minStrs[7] = "7";
        minStrs[8] = "8";
        minStrs[9] = "9";
        minStrs[10] = "T";
        minStrs[11] = "J";
        minStrs[12] = "Q";
        minStrs[13] = "K";
        minStrs[14] = "A";
        minStrs[15] = "C";
        minStrs[16] = "Ð";
        minStrs[17] = "S";
        minStrs[18] = "H";

    }

    public static String getStr(char c) {
        return strs[ints[c]];
    }

    public static int getInt(char c) {
        return ints[c];
    }

    public static String getStr(int i) {
        return strs[i];
    }

    public static String getMinifiedStr(int i) {
        return minStrs[i];
    }

    public static int[] parseCard(String card) {
        return new int[]{
                getInt(card.charAt(0)),
                getInt(card.charAt(1))
        };
    }

    public static String getStringForCard(int[] card) {
        return getStr(card[0]) + OF + getStr(card[1]);
    }

    public static String getMinifiedStringForCard(int[] card) {
        return getMinifiedStr(card[0]) + getMinifiedStr(card[1]);
    }

    public static String getStringForHand(int[][] card) {
        StringBuilder sb = new StringBuilder();
        for (int[] a : card) {
            sb.append(getStringForCard(a) + "\n");
        }

        return sb.toString();
    }

    public static String getMinifiedStringForHand(int[][] card) {
        StringBuilder sb = new StringBuilder();
        for (int[] a : card) {
            sb.append(getMinifiedStringForCard(a) + " ");
        }

        return sb.toString();
    }
}
