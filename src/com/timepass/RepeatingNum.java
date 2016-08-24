package com.timepass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by deepanshu on 18/03/16, 11:28 AM.
 */
class RepeatingNum {
    private static final String SPLIT_CHAR = " ";
    private static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = rsi(br);
        while (T > 0) {
            System.out.println(numberInSeries(rsi(br)));
            T--;
        }
    }

    private static String getResult() {
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

    static int isRepeating(int n) {
        int[] a = new int[10];

        int i = 0;
        while (i < 10) {
            a[i] = 0;
            i++;
        }

        int d = 0;

        while (n > 0) {
            d = n % 10;
            if (a[d] == 1) {
                return 0;
            } else {
                a[d] = 1;
            }
            n /= 10;
        }

        return 1;
    }


    static int numberInSeries(int n) {
        if (n < 11) {
            return n;
        }

        int c = 10;

        int curNum = 10;

        while (c < n) {
            curNum++;

            while (isRepeating(curNum) == 0) {
                curNum++;
            }
            c++;
        }

        return curNum;
    }
}
