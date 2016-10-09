package com.ProjectEuler.Prob_26_50;

import com.ProjectEuler.Utils.NumberUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by deepanshu on 16/05/16, 11:34 PM.
 */
class $038_PandigitalMultiples {
    private static final String SPLIT_CHAR = " ";
    private static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = rsi(br);
        while (T > 0) {
            double curMills = System.currentTimeMillis();

            System.out.println(getResult());

            double nowMills = System.currentTimeMillis();
            System.out.println("Time to execute test case: " + (nowMills - curMills) / 1000 + " seconds");
            T--;
        }
    }

    private static String getResult() {
        ArrayList<String> s = new ArrayList<>();
        makePandigital(9, s);

        for (int i = 9000; i < 10000; i++) {
            makePandigital(i, s);
        }

        Collections.sort(s);

        parli(s);

        return "";
    }

    private static void makePandigital(int n, ArrayList<String> s) {
        StringBuilder ans = new StringBuilder();
        int k = 1;
        while (true) {
            if (ans.length() >= 9) {
                if (NumberUtil.is1to9Pandigital(ans.toString())) {
                    s.add(ans.toString());
                }
                break;
            }
            ans.append(n * k);
            k++;
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
