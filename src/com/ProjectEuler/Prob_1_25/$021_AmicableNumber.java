package com.ProjectEuler.Prob_1_25;

import com.ProjectEuler.Utils.NumberUtil;
import com.ProjectEuler.Utils.PrimeUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by deepanshu on 08/05/16, 11:26 AM.
 */
class $021_AmicableNumber {
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
        int[] dp = new int[10001];

        dp[1] = 1;
        PrimeUtil.generatePrimesUptoN(10000);

        for (int i = 2; i < dp.length; i++) {
            dp[i] = NumberUtil.getSumOfDivisorsUsingPrimeFactorisation(i, PrimeUtil.primes);
        }

        int sum = 0;

        for (int i = 2; i < dp.length; i++) {
            int t = dp[i];
            int v = t < dp.length ? dp[t] : 0;
            if (t != i && v == i) {
                sum += i + t;
                dp[i] = dp[t] = 0;
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

    //fil array
    private static void filArr(long[] a, long v) {
        for (int i = 0; i < a.length; i++) {
            a[i] = v;
        }
    }
}
