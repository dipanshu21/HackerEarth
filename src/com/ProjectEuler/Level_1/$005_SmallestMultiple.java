package com.ProjectEuler.Level_1;

import com.ProjectEuler.Utils.PrimeUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by deepanshu on 30/04/16, 8:53 AM.
 */
class $005_SmallestMultiple {
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
        int[] dp = new int[100];

        filArr(dp, 0);

        for (int i = 2; i < 21; i++) {
            PrimeUtil.clear();
            int t = i;
            while (t != 1) {
                int prime = (int) PrimeUtil.getNextPrime();
                int c = 0;
                while (t % prime == 0) {
                    t /= prime;
                    c++;
                }

                if (dp[prime] < c) {
                    dp[prime] = c;
                }
            }

        }

        int sum = 1;

        for (int i = 0; i < dp.length; i++) {
            int t = dp[i];
            for (int j = 0; j < t; j++) {
                sum *= i;
            }
        }
        return sum + "";
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
}
