package com.ProjectEuler.Level_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by deepanshu on 17/05/16, 8:52 AM.
 */
class $043_SubStringDivisibility {
    private static final String SPLIT_CHAR = " ";
    private static final int MOD = 1000000007;
    private final static long sec;
    static long sum = 0;
    private static long[][] multipleDP = new long[10][10];
    private static boolean[][] divisibilityDP = new boolean[7][1000];

    static {
        sec = System.currentTimeMillis();
        long start = 1000000000;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                multipleDP[i][j] = start * j;
            }
            start /= 10;
        }
    }

    static {
        int[] divisors = new int[]{2, 3, 5, 7, 11, 13, 17};
        for (int i = 0; i < divisors.length; i++) {
            int t = divisors[i];
            int k = 0;
            int m = k * t;
            while (m < 1000) {
                divisibilityDP[i][m] = true;
                k++;
                m = t * k;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = rsi(br);
        while (T > 0) {
            String res = getResult();
            System.out.println(res);
            System.out.println("Time to execute test case: " + (System.currentTimeMillis() - sec) / 1000 + " seconds");
            T--;
        }
    }

    private static String getResult() {
        countAllDivisible(1, 10, new boolean[10], 0, 0, 0);
        return sum + "";
    }

    private static void countAllDivisible(int s, int n, boolean[] dp, int prev1, int prev2, long sumSoFar) {
        if (n == 0) {
            sum += sumSoFar;
            System.out.println(sumSoFar);
        } else {
            for (int i = s; i < 10; i++) {
                if (!dp[i]) {
                    dp[i] = true;
                    int ind = 7 - n;
                    if (ind > -1) {
                        int divNum = 100 * prev1 + 10 * prev2 + i;
                        if (divisibilityDP[ind][divNum]) {
                            countAllDivisible(0, n - 1, dp, prev2, i, sumSoFar + multipleDP[10 - n][i]);
                        }
                    } else {
                        countAllDivisible(0, n - 1, dp, prev2, i, sumSoFar + multipleDP[10 - n][i]);
                    }
                    dp[i] = false;
                }
            }
        }
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

    //printArrayList
    private static <T> void parli(ArrayList<T> list) {
        for (T a : list) {
            System.out.println(a.toString());
        }
    }
}
