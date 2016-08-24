package com.timepass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by deepanshu on 06/02/16, 2:01 PM.
 */
class BinarySearchRotatedArray {
    private static final String SPLIT_CHAR = " ";
    private static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = rsi(br);
        while (T > 0) {
            System.out.println(getResult(rmi(br)));
            T--;
        }
    }

    private static int getResult(int[] a) {
        int len = a.length;
        int l = 0;
        int h = len - 1;


        while (l <= h) {
            int m = l + (h - l) / 2;
            int e = a[m];

            boolean l_edge = m == 0;
            boolean r_edge = m == len - 1;

            int l_e = l_edge ? Integer.MIN_VALUE : a[m - 1];
            int r_e = r_edge ? Integer.MAX_VALUE : a[m + 1];

            boolean isLs = l_e <= e;
            boolean isRs = e <= r_e;

            if (isLs && isRs) {
                if (e > a[h]) {
                    l = m + 1;
                } else {
                    h = m - 1;
                }
            } else {
                if (!isLs && isRs) {
                    return m;
                } else if (isLs && !isRs) {
                    return m + 1;
                }
            }
        }

        return 0;

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
