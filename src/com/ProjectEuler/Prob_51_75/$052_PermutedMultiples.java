package com.ProjectEuler.Prob_51_75;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by deepanshu on 19/05/16, 7:16 AM.
 */
class $052_PermutedMultiples {
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
        int s = 100000;
        int e = 1000000;
        int x = 6;

        e = e / x;
        for (int i = s; i <= e; i++) {
            if (areSame(i, x)) {
                for (int k = 1; k <= x; k++) {
                    System.out.println(i * k);
                }
                break;
            }
        }

        return "";
    }

    private static boolean areSame(int n, int x) {
        int[] t = new int[10];
        int c = n;

        while (n != 0) {
            t[n % 10] += (x - 1);
            n /= 10;
        }

        for (int i = 2; i <= x; i++) {
            n = c;
            n *= i;
            while (n != 0) {
                int d = n % 10;
                t[d] -= 1;
                if (t[d] < 0) return false;
                n /= 10;
            }
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
