package com.ProjectEuler.Prob_1_25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by deepanshu on 25/04/16, 8:48 AM.
 */
class $023_NonAbundantSum {
    private static final String SPLIT_CHAR = " ";
    private static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = rsi(br);
        while (T > 0) {
            getResult(rsi(br));
            T--;
        }
    }

    private static void getResult(int lim) {
        long cur = System.currentTimeMillis();
        boolean[] numbers = new boolean[28124];
        int[] abundantNumber = new int[6965];
        int c = 0;
        for (int i = 12; i <= lim; i++) {
            if (isAbudant(i)) {
                abundantNumber[c] = i;
                c++;
            }
        }

        final int LIM = 28123;

        for (int i = 0; i < c; i++) {
            for (int j = i; j < c; j++) {
                int sum = abundantNumber[i] + abundantNumber[j];
                if (sum > LIM) {
                    break;
                } else {
                    numbers[sum] = true;
                }
            }
        }

        long sum = 0;

        for (int i = 1; i <= lim; i++) {
            if (!numbers[i]) {
                sum += i;
            }
        }

        long cur2 = System.currentTimeMillis();
        System.out.println("sum: " + sum + "\ntime:  " + (cur2 - cur) + "\n------End-----");
    }

    static boolean isAbudant(int n) {
        int sum = 1;

        int sqrt = (int) Math.sqrt(n);

        for (int i = 2; i <= sqrt; i++) {
            sum += n % i == 0 ? (i == n / i ? i : i + n / i) : 0;
        }

        return sum > n;
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
