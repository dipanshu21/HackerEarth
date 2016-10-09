package com.ProjectEuler.Prob_26_50;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by deepanshu on 14/05/16, 10:27 PM.
 */
class $032_PandigitalProducts {
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
        boolean[] arry = new boolean[10];
        boolean[] copy = new boolean[10];
        boolean[] dp = new boolean[10000];
        final int MAX_DIG = 10;
        arry[0] = copy[0] = true;
        int sumOfProd = 0;
        for (int i = 1; i < MAX_DIG; i++) {
            arry[i] = true;
            for (int j = 1; j < MAX_DIG; j++) {
                if (!arry[j]) {
                    arry[j] = true;
                    for (int k = 1; k < MAX_DIG; k++) {
                        if (!arry[k]) {
                            arry[k] = true;
                            for (int l = 1; l < MAX_DIG; l++) {
                                if (!arry[l]) {
                                    arry[l] = true;
                                    for (int m = 1; m < MAX_DIG; m++) {
                                        if (!arry[m]) {
                                            arry[m] = true;
                                            int a = 100 * i + 10 * j + k;
                                            int b = 10 * l + m;
                                            sumOfProd += checkNum(a, b, arry, copy, dp);
                                            sumOfProd += checkNum(10 * a + l, m, arry, copy, dp);
                                            arry[m] = false;
                                        }
                                    }
                                    arry[l] = false;
                                }
                            }
                            arry[k] = false;
                        }
                    }
                    arry[j] = false;
                }
            }
            arry[i] = false;
        }

        return sumOfProd + "";
    }

    private static int checkNum(int a, int b, boolean[] arry, boolean[] copy, boolean[] dp) {
        int c = a * b;
        int r = c;
        int sumOfProd = 0;
        if (c > 1233 && c < 9877) {
            System.arraycopy(arry, 1, copy, 1, 9);
            boolean isFound = false;
            while (c != 0) {
                int t = c % 10;
                if (copy[t]) {
                    isFound = true;
                    break;
                } else {
                    copy[t] = true;
                }
                c /= 10;
            }

            if (!isFound && !dp[r]) {
                dp[r] = true;
                sumOfProd = r;
                System.out.println(a + " x " + b + " = " + r);
            }
        }

        return sumOfProd;
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
