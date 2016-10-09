package com.ProjectEuler.Prob_51_75;

import com.ProjectEuler.Utils.PrimeUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by deepanshu on 19/05/16, 5:31 AM.
 */
class $051_PrimeDigitReplacements {
    private static final String SPLIT_CHAR = " ";
    private static final int MOD = 1000000007;
    static boolean found = false;
    private static boolean[] dp = PrimeUtil.generatePrimesUptoNSieveReturnDP(1000000000);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = rsi(br);
        while (T > 0) {
            //int in = rsi(br);
            double curMills = System.currentTimeMillis();
            String res = getResult();
            double nowMills = System.currentTimeMillis();
            System.out.println(res);
            System.out.println("Time to execute test case: " + (nowMills - curMills) / 1000 + " seconds");
            T--;
        }
    }

    //38*0*2*1 for 9
    //*2*3*3 for 8
    private static String getResult() {
        int dig[] = new int[10];
        int numOfPrimes = 10;
        found = false;
        for (int i = 1000000000; i < 1000000000 & !found; i++) {
            if (!dp[i]) {
                int n = i;
                int ind = 0;
                while (n != 0) {
                    dig[ind] = n % 10;
                    n /= 10;
                    ind++;
                }
                checkAllCombs(dig, ind, ind - 1, numOfPrimes);
            }
        }

        return "";
    }

    private static void checkAllCombs(int[] digs, int digLen, int i, int numOfPrimesNeeded) {
        if (found) return;
        if (i == 0) {
            int primes = 0;
            int c = 0;
            for (int p = 0; p < digLen; p++) {
                if (digs[p] == -1)
                    c++;
            }
            if (c == 0) return;
            for (int k = digs[digLen - 1] == -1 ? 1 : 0; k < 10 && (10 - k) >= (numOfPrimesNeeded - primes); k++) {
                int n = 0;
                for (int j = digLen; j > -1; j--) {
                    int t = digs[j];
                    if (t == -1) {
                        t = k;
                    }
                    n = n * 10 + t;
                }
                if (!dp[n]) primes++;
            }
            if (primes == numOfPrimesNeeded) {
                for (int k = digLen - 1; k >= 0; k--) {
                    System.out.print(digs[k] == -1 ? "*" : digs[k]);
                }
                System.out.println();
                found = true;
                return;
            }
        } else {
            int t = digs[i];
            digs[i] = -1;
            checkAllCombs(digs, digLen, i - 1, numOfPrimesNeeded);
            digs[i] = t;
            checkAllCombs(digs, digLen, i - 1, numOfPrimesNeeded);
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

    //printArrayList
    private static <T> void parli(ArrayList<T> list) {
        for (T a : list) {
            System.out.println(a.toString());
        }
    }
}
