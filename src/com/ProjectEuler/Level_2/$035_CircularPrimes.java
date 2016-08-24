package com.ProjectEuler.Level_2;

import com.ProjectEuler.Utils.PrimeUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by deepanshu on 15/05/16, 9:25 AM.
 */
class $035_CircularPrimes {
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
        PrimeUtil.generatePrimesUptoNSieve(1000000);
        boolean[] dp = new boolean[1000000];
        boolean[] ans = new boolean[1000000];
        for (int i = 0; i < PrimeUtil.primes.size(); i++) {
            long ind = PrimeUtil.primes.get(i);
            dp[(int) ind] = true;
        }

        long sum = 0;
        for (int i = 2; i < 1000000; i++) {
            if (dp[i]) {
                getSumOfPrimeRotations(i, dp, ans);
            }
        }

        for (int i = 0; i < ans.length; i++) {
            if (ans[i]) {
                System.out.println(i);
                sum++;
            }
        }

        return sum + "";
    }

    private static void getSumOfPrimeRotations(int n, boolean[] primes, boolean[] ans) {
        int numOfDigit = 0;
        int fact = 1;
        int n_copy = n;

        while (n_copy != 0) {
            n_copy /= 10;
            fact *= 10;
            numOfDigit++;
        }

        fact /= 10;

        int[] rotations = new int[numOfDigit];

        for (int i = 0; i < numOfDigit; i++) {
            int t = n % 10;
            n /= 10;
            n = fact * t + n;
            rotations[i] = n;
        }

        boolean areAll = true;

        for (int i : rotations) {
            if (!primes[i]) {
                areAll = false;
                break;
            }
        }

        if (areAll) {
            for (int i : rotations) {
                primes[i] = false;
                ans[i] = true;
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
