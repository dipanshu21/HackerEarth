package com.ProjectEuler.Prob_26_50;

import com.ProjectEuler.Utils.GCDUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by deepanshu on 15/05/16, 6:24 AM.
 */
class $033_DigitCancellingFractions {
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
        GCDUtil.generateGCD(100);

        int[][] gcd = GCDUtil.gcdDP;

        for (int i = 10; i < 100; i++) {
            for (int j = 10; j < 100; j++) {
                if (i != j && i % 10 != 0 && j % 10 != 0) {
                    try {
                        int modI = i / gcd[i][j];
                        int modJ = j / gcd[i][j];

                        int d1 = i % 10, d2 = i / 10, d3 = j % 10, d4 = j / 10;

                        int newModI = 0, newModJ = 0;
                        if (d1 == d3) {
                            newModI = d2 / gcd[d2][d4];
                            newModJ = d4 / gcd[d2][d4];
                        } else if (d1 == d4) {
                            newModI = d2 / gcd[d3][d2];
                            newModJ = d3 / gcd[d3][d2];
                        } else if (d2 == d3) {
                            newModI = d1 / gcd[d1][d4];
                            newModJ = d4 / gcd[d1][d4];
                        } else if (d2 == d4) {
                            newModI = d1 / gcd[d1][d3];
                            newModJ = d3 / gcd[d1][d3];
                        }

                        if (newModI == modI && newModJ == modJ) {
                            System.out.println(i + "\t" + j);
                        }
                    } catch (ArithmeticException e) {

                    }
                }
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
