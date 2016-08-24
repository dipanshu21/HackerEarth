package com.ProjectEuler.Level_2;

import com.ProjectEuler.Utils.PrimeUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by deepanshu on 10/05/16, 12:23 AM.
 */
class $027_QuadraticPrimes {
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
        PrimeUtil.generatePrimesUptoN(Integer.MAX_VALUE / 1000);

        int max = 0;
        int maxProd = 0;

        //System.out.printf("a: %4d\tb: %4d\tprimes: %5d\n",1,41,getLongestPrime(1,41));

        for (int a = -999; a < 1000; a++) {
            for (int b = -999; b < 1000; b++) {
                int t = getLongestPrime(a, b);
                //System.out.printf("a: %4d\tb: %4d\tprimes: %5d\n",a,b,t);
                if (t > max) {
                    System.out.printf("a: %4d\tb: %4d\tprimes: %5d\n", a, b, t);
                    max = t;
                    maxProd = a * b;
                }
            }
        }

        return maxProd + "";
    }

    private static int getLongestPrime(int a, int b) {
        for (int n = 0; ; n++) {
            if (!isPrime(getEqVal(n, a, b))) {
                return n - 1;
            }
        }
    }

    private static int getEqVal(int n, int a, int b) {
        return (n * n) + (a * n) + b;
    }

    private static boolean isPrime(int n) {
        return Collections.binarySearch(PrimeUtil.primes, (long) n) > -1;
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
