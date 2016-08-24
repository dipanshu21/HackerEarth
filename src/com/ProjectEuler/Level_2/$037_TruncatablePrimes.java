package com.ProjectEuler.Level_2;

import com.ProjectEuler.Utils.PrimeUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by deepanshu on 16/05/16, 9:14 PM.
 */
class $037_TruncatablePrimes {
    private static final String SPLIT_CHAR = " ";
    private static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = rsi(br);
        while (T > 0) {
            int n = rsi(br);
            double curMills = System.currentTimeMillis();
            System.out.println(getResult(n));
            double nowMills = System.currentTimeMillis();
            System.out.println("Time to execute test case: " + (nowMills - curMills) / 1000 + " seconds");
            T--;
        }
    }

    private static String getResult(int div) {
        boolean[] primes = PrimeUtil.generatePrimesUptoNSieveReturnDP(Integer.MAX_VALUE / div);

        long sum = 0;

        for (int i = 10; i < primes.length; i++) {
            if (!primes[i]) {
                if (isTrucatablePrime(i, primes)) {
                    System.out.println(i);
                    sum += i;
                }
            }
        }

        return sum + "";
    }

    private static boolean isTrucatablePrime(int n, boolean[] primes) {
        int fact = 1;
        int copy = n / 10;

        while (copy != 0) {
            if (primes[copy]) {
                return false;
            }
            copy /= 10;
            fact *= 10;
        }

        while (fact != 1) {
            int t = n % fact;
            if (primes[t]) {
                return false;
            }

            fact /= 10;
        }


        return true;
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
