package com.timepass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by deepanshu on 04/02/16, 8:49 PM.
 */
class ZSAssociates {
    private static final String SPLIT_CHAR = " ";
    private static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = rsi(br);
        while (T > 0) {
            System.out.println(getResult(rsi(br)));
            T--;
        }
    }

    private static boolean getResult(int a) {
        if (a == 1) return true;
        for (int i = 2; i < 32; i++) {
            for (int j = 2; j < 2 * 65536; j++) {
                long pow = j;
                boolean t = false;
                for (int k = 1; k < i; k++) {
                    pow *= pow;
                    if (pow > Integer.MAX_VALUE) {
                        t = true;
                        break;
                    }
                }
                if (t) {
                    break;
                } else if (pow == a) {
                    return true;
                }
            }

        }

        return false;

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
