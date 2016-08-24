package com.ProjectEuler.Level_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by deepanshu on 07/05/16, 4:36 PM.
 */
class $017_NumberLetterCounts {
    private static final String SPLIT_CHAR = " ";
    private static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = rsi(br);
        while (T > 0) {
            System.out.println(getResult());
            T--;
        }
    }

    private static String getResult() {
        int[][] dp = {
                {1, 3},
                {2, 3},
                {3, 5},
                {4, 4},
                {5, 4},
                {6, 3},
                {7, 5},
                {8, 5},
                {9, 4},
                {10, 3},
                {11, 6},
                {12, 6},
                {13, 8},
                {14, 8},
                {15, 7},
                {16, 7},
                {17, 9},
                {18, 8},
                {19, 8},
                {20, 6},
                {30, 6},
                {40, 5},
                {50, 5},
                {60, 5},
                {70, 7},
                {80, 6},
                {90, 6},
                {100, 7},
                {1000, 8}
        };

        int letter = 0;
        for (int i = 1; i <= 1000; i++) {
            letter += getLetter(i, dp);
        }

        return letter + "";
    }

    private static int getLetter(int i, int[][] dp) {
        int t = 0;
        t += i >= 1000 ? getLetterC(i / 1000, dp) + 8 : 0;
        i %= 1000;
        t += i >= 100 ? getLetterC(i / 100, dp) + 7 + (i % 100 == 0 ? 0 : 3) : 0;
        i %= 100;
        t += i >= 20 ? getLetterC(i % 10, dp) + getLetterC(i - i % 10, dp) : getLetterC(i, dp);

        return t;
    }

    private static int getLetterC(int n, int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            if (dp[i][0] == n) {
                return dp[i][1];
            }
        }

        return 0;
    }

    //Read multiple integer values
    private static int[] rmi(BufferedReader br) throws IOException {
        String[] arr = br.readLine().split(SPLIT_CHAR);
        int[] vals = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            vals[i] = i(arr[i]);
        }

        return vals;
    }

    //Read single integer value
    private static int rsi(BufferedReader br) throws IOException {
        return rmi(br)[0];
    }

    //Read multiple string values
    private static String[] rms(BufferedReader br) throws IOException {
        return br.readLine().split(SPLIT_CHAR);
    }

    //Read single string
    private static String rss(BufferedReader br) throws IOException {
        return rms(br)[0];
    }

    //Convert string to integer
    private static int i(String s) {
        return Integer.parseInt(s);
    }

    //Convert string to long
    private static long l(String s) {
        return Long.parseLong(s);
    }

    //fil array
    private static void filArr(int[] a, int v) {
        for (int i = 0; i < a.length; i++) {
            a[i] = v;
        }
    }

    //fil array
    private static void filArr(long[] a, long v) {
        for (int i = 0; i < a.length; i++) {
            a[i] = v;
        }
    }
}
