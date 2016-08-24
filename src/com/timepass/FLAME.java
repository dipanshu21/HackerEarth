package com.timepass;

/**
 * Created by deepanshu on 02/02/16, 7:45 AM.
 */
class FLAME {
    static final String[] VALUES = {"FRIENDS", "LOVE", "ADMIRE", "MARRIAGE", "ENEMY"};

    public static String getFlame(String a, String b) {
        int[][] vals = new int[2][26];

        a = a.toLowerCase();
        b = b.toLowerCase();

        for (char c : a.toCharArray()) {
            vals[0][c - 'a']++;
        }

        for (char c : b.toCharArray()) {
            vals[1][c - 'a']++;
        }

        int cnt = 0;

        for (int i = 0; i < 26; i++) {
            cnt += Math.abs(vals[0][i] - vals[1][i]);
        }

        return VALUES[cnt % 5 - 1];
    }

    public static void main(String[] args) {
        String a = "deepanshu";
        String b = "ssa";

        System.out.println(getFlame(a, b));
    }
}
