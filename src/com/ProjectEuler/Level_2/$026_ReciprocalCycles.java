package com.ProjectEuler.Level_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by deepanshu on 09/05/16, 6:35 AM.
 */
class $026_ReciprocalCycles {
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

    private static String getResult(int n) {
        HashMap<Integer, Integer> occurredNumbers = new HashMap<>(1000);

        int maxLen = 0;
        int maxI = 0;

        for (int i = 1; i < 1000; i++) {
            int len = getRecurringSequence(i, occurredNumbers);
            if (len > maxLen) {
                maxI = i;
                maxLen = len;
            }
        }

        return maxLen + "\n" + maxI;
    }

    private static int getRecurringSequence(int n, HashMap<Integer, Integer> occurredNumbers) {
        int x = 10;
        int seqLen = 1;
        occurredNumbers.clear();

        while (!occurredNumbers.containsKey(x)) {
            occurredNumbers.put(x, seqLen);
            if (x < n) {
                seqLen++;
                x *= 10;
            } else {
                int t = x % n;
                if (t == 0) {
                    seqLen = 0;
                    break;
                } else {
                    seqLen++;
                    x = t * 10;
                }
            }
        }

        if (seqLen != 0) {
            int t = occurredNumbers.get(x);
            seqLen -= t;
        }

        return seqLen;
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
}
