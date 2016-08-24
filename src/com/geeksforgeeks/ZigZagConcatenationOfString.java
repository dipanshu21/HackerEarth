package com.geeksforgeeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by deepanshu on 06/01/16, 7:57 PM.
 */
class ZigZagConcatenationOfString {
    private static final String SPLIT_CHAR = " ";
    private static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = rsi(br);
        while (T > 0) {
            String[] input = rms(br);
            System.out.println(getResult(input[0], i(input[1])));
            T--;
        }
    }

    private static String getResult(String str, int n) {
        StringBuilder sb = new StringBuilder(str.length());

        int highestDiff = n - 1;
        int len = str.length();

        for (int i = 0, diff = highestDiff; i < n; i++, diff--) {
            int j = i;
            int curDiff = diff != 0 ? diff : highestDiff;
            while (isInBounds(len, j)) {
                sb.append(str.charAt(j));
                j += (2 * curDiff);
                curDiff = highestDiff - curDiff;
                if (curDiff == 0) {
                    curDiff = highestDiff;
                }
            }
        }

        return sb.toString();
    }

    private static boolean isInBounds(int len, int i) {
        return i >= 0 && i < len;
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
}
