package com.ProjectEuler.Prob_26_50;

import com.ProjectEuler.Utils.NumberUtil;
import com.ProjectEuler.Utils.PrimeUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by deepanshu on 18/05/16, 9:43 PM.
 */
class $047_DistinctPrimesFactors {
    private static final String SPLIT_CHAR = " ";
    private static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = rsi(br);
        while (T > 0) {
            //int in = rsi(br);
            double curMills = System.currentTimeMillis();
            String res = getResult();
            double nowMills = System.currentTimeMillis();
            System.out.println(res);
            System.out.println("Time to execute test case: " + (nowMills - curMills) / 1000 + " seconds");
            T--;
        }
    }

    private static String getResult() {
        final int MAX_PRIME_LIM = 200000;

        PrimeUtil.generatePrimesUptoNSieve(MAX_PRIME_LIM);
        final int LIMIT = 4;
        int p1, p2, p3;

        p1 = p2 = p3 = 0;

        for (int i = 2; i < MAX_PRIME_LIM; i++) {
            if (NumberUtil.getPrimeFactorisation(i, PrimeUtil.primes).size() == LIMIT) {
                if (p1 == LIMIT && p2 == LIMIT && p3 == LIMIT) {
                    System.out.println(i);
                    System.out.println(i - 1);
                    System.out.println(i - 2);
                    System.out.println(i - 3);
                    break;
                }
                p1 = p2;
                p2 = p3;
                p3 = LIMIT;
            } else {
                p1 = p2 = p3 = 0;
            }
        }

        return "";
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
