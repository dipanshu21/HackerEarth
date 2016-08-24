package com.hackerearth.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by deepanshu on 30/12/15, 4:57 PM.
 */
class ModifySequenceIndiaHacks2013 {
    private static final String SPLIT_CHAR = " ";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        System.out.println(getResult(rmi(br)));
    }

    private static String getResult(int[] vals) {
        int prev = vals[0];
        for (int i = 1; i < vals.length; i++) {
            if (prev > vals[i]) {
                return "NO";
            } else if (prev < vals[i]) {
                vals[i - 1] = 0;
                vals[i] = vals[i] - prev;
                prev = vals[i];
            } else {
                try {
                    vals[i - 1] = vals[i] = 0;
                    i++;
                    prev = vals[i];
                } catch (Exception e) {

                }
            }
        }

        for (int i : vals) {
            if (i != 0) {
                return "NO";
            }
        }

        return "YES";
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
