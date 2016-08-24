package com.hackerearth.easy_track;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by deepanshu on 31/12/15, 7:16 AM.
 */
class PandaAndXOR {
    private static final String SPLIT_CHAR = " ";
    private static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = rsi(br);
        int[] numbers = new int[T];
        for (int i = 0; i < T; i++) {
            numbers[i] = rsi(br);
        }
        System.out.println(getResult(numbers));
    }

    private static void increment(int[] arr, int index) {
        int val = arr[index];
        val = (val + 1) % MOD;
        arr[index] = val;
    }

    private static String getResult(int[] arr) {
        int[] allXOR = new int[128];

        for (int i = 0; i < arr.length; i++) {
            int[] temp = new int[128];
            for (int j = 0; j < 128; j++) {
                if (allXOR[j] != 0) {
                    temp[j ^ arr[i]] += allXOR[j];
                }
            }

            for (int j = 0; j < 128; j++) {
                allXOR[j] += temp[j];
            }

            allXOR[arr[i]] += 1;
        }

        long res = 0;

        for (int i = 0; i < allXOR.length; i++) {
            long val = allXOR[i];
            if (val % 2 != 0) {
                val = val * ((val - 1) / 2);
            } else {
                val = (val / 2) * (val - 1);
            }
            val %= MOD;
            res = (res + val) % MOD;
        }
        return res + "";
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

    //Read string values
    private static String[] rv(BufferedReader br) throws IOException {
        return br.readLine().split(SPLIT_CHAR);
    }

    //Convert string to integer
    private static int i(String s) {
        return Integer.parseInt(s);
    }

    //Convert string to long
    private static long l(String s) {
        return Long.parseLong(s);
    }
}
