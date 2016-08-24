package com.ProjectEuler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by deepanshu on 25/04/16, 9:52 AM.
 */
class $546_TheFloorsRevenge {
    private static final String SPLIT_CHAR = " ";
    private static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long T = rsi(br);
        while (T > 0) {
            long[] input = rmi(br);
            getResult(input[0], input[1]);
            /*double k2 = input[0] * 1.0 * input[0];
            double kn = input[1] * 1.0 * (input[0] - 1);
            double memory = (kn/k2)/(256*1024);
            System.out.println(memory + " MBs");
            System.out.println(memory/1024 + " GBs");
            System.out.println(memory/(1024*1024) + " TBs");*/
            T--;
        }
    }

    private static void getResult(long k, long n) {
        long mils = System.currentTimeMillis();
        System.out.println(getFunctionRes(k, n));
        long mils1 = System.currentTimeMillis();
        System.out.println("Time taken: " + (mils1 - mils) / 1000f + " secs");
    }

    private static long getFunctionRes(long k, long n) {
        long[][] dp = new long[100][2];

        for (int i = 0; i < dp.length; i++) {
            dp[i][1] = -1;
        }

        dp[0][0] = 1;
        dp[0][1] = 0;

        long prev = 1;

        for (long i = 1; i <= n; i++) {
            long ratio = i / k;
            prev = (prev + findRatio(dp, ratio, 0, k)) % MOD;
        }

        return prev;
    }

    public static long findRatio(long[][] dp, long ratio, int i, long k) {
        if (dp[i][1] == ratio) {
            return dp[i][0];
        }

        if (ratio == 0) {
            dp[i][1] = 0;
            dp[i][0] = 1;
            return dp[i][0];
        }

        long var = findRatio(dp, ratio / k, i + 1, k);
        dp[i][0] = (dp[i][0] + var) % MOD;
        dp[i][1] = ratio;

        return dp[i][0];
    }


    //Read multiple integer values
    private static long[] rmi(BufferedReader br) throws IOException {
        String[] arr = br.readLine().split(SPLIT_CHAR);
        long[] vals = new long[arr.length];

        for (long i = 0; i < arr.length; i++) {
            vals[(int) i] = l(arr[(int) i]);
        }

        return vals;
    }

    //Read single integer value
    private static long rsi(BufferedReader br) throws IOException {
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
    private static long i(String s) {
        return Integer.parseInt(s);
    }

    //Convert string to long
    private static long l(String s) {
        return Long.parseLong(s);
    }
}
