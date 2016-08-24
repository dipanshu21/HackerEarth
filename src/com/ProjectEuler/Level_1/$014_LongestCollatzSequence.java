package com.ProjectEuler.Level_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by deepanshu on 07/05/16, 12:38 PM.
 */
class $014_LongestCollatzSequence {
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
        final int lim = 1000001;
        long[] dp = new long[lim];

        filArr(dp, 0);

        dp[1] = 1;

        for (int i = 2; i < lim; i++) {
            if (dp[i] == 0) {
                Stack<Long> s = new Stack<>();
                long k = i;
                while (k != 1) {
                    if (k < lim && dp[(int) k] != 0) {
                        break;
                    }
                    s.push(k);
                    if (k % 2 == 0) {
                        k /= 2;
                    } else {
                        k *= 3;
                        k++;
                    }

                }

                long sol = dp[(int) k];

                while (!s.isEmpty()) {
                    long popped = s.pop();
                    sol++;
                    if (popped < lim) {
                        dp[(int) popped] = sol;
                    }
                }
            }
        }

        long max = 0;
        int maxI = 0;

        for (int i = 0; i < dp.length; i++) {
            if (max < dp[i]) {
                max = dp[i];
                maxI = i;
            }
        }

        return maxI + "";
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
    private static void filArr(long[] a, int v) {
        for (int i = 0; i < a.length; i++) {
            a[i] = v;
        }
    }
}
