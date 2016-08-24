package com.hackerearth.easy_track;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by deepanshu on 30/12/15, 9:31 PM.
 */
class ladder_ride {
    private static final String SPLIT_CHAR = " ";
    private static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = rsi(br);
        while (T > 0) {

            int[] in = rmi(br);

            System.out.println(getResult(new long[in[0] + 1], in[0], in[1]));
            T--;
        }
    }

    private static long getResult(long[] dp, int cur, int step) {
        dp[0] = 0;
        if (1 < dp.length)
            dp[1] = 0;
        if (2 < dp.length)
            dp[2] = 1;
        if (3 < dp.length)
            dp[3] = 0;
        if (4 < dp.length)
            dp[4] = 1;
        if (5 < dp.length)
            dp[5] = 1;

        for (int i = 6; i <= cur; i++) {
            dp[i] = (dp[i - 2] + dp[i - 5]) % MOD;
        }

        if (step > cur) {
            return dp[cur];
        } else if (step == cur) {
            return (dp[cur] + 1) % MOD;
        } else {
            dp[step] = (dp[step] + 1) % MOD;
            for (int i = step + 1; i <= cur; i++) {
                dp[i] = ((dp[i - 2] + dp[i - 5]) % MOD + dp[i - step]) % MOD;
            }
            return dp[cur];
        }
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
