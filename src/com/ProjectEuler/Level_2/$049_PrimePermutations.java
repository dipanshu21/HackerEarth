package com.ProjectEuler.Level_2;

import com.ProjectEuler.Utils.PrimeUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by deepanshu on 18/05/16, 10:20 PM.
 */
class $049_PrimePermutations {
    private static final String SPLIT_CHAR = " ";
    private static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = rsi(br);
        while (T > 0) {
            int in = rsi(br);
            double curMills = System.currentTimeMillis();
            String res = getResult(in);
            double nowMills = System.currentTimeMillis();
            System.out.println(res);
            System.out.println("Time to execute test case: " + (nowMills - curMills) / 1000 + " seconds");
            T--;
        }
    }

    private static String getResult(int n) {
        boolean[] dp = PrimeUtil.generatePrimesUptoNSieveReturnDP(10000);

        for (int i = 1000; i < dp.length; i++) {
            if (!dp[i]) {
                for (int j = 1; i + 2 * j < dp.length; j++) {
                    int a = i + j, b = a + j;
                    if (areDigSame(i, a) && areDigSame(a, b)) {
                        if (!dp[i + j] && !dp[i + j + j]) {
                            System.out.print(i);
                            System.out.print(" " + (i + j));
                            System.out.println(" " + (i + j + j) + "\n");
                            break;
                        }
                    }
                }
            }
        }

        return "";
    }

    private static boolean areDigSame(int n1, int n2) {
        int[] dp = new int[10];

        while (n1 != 0) {
            dp[n1 % 10]++;
            n1 /= 10;
        }

        while (n2 != 0) {
            dp[n2 % 10]--;
            n2 /= 10;
        }

        for (int i : dp) {
            if (i != 0) {
                return false;
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
