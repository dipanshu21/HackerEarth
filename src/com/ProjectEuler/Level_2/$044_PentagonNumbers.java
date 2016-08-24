package com.ProjectEuler.Level_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by deepanshu on 17/05/16, 11:25 PM.
 */
class $044_PentagonNumbers {
    private static final String SPLIT_CHAR = " ";
    private static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = rsi(br);
        while (T > 0) {
            int[] in = rmi(br);
            double curMills = System.currentTimeMillis();
            String res = getResult(in);
            double nowMills = System.currentTimeMillis();
            System.out.println(res);
            System.out.println("Time to execute test case: " + (nowMills - curMills) / 1000 + " seconds");
            T--;
        }
    }

    private static String getResult(int[] in) {
        int prevNum = 1;
        long[] allPantagonNumbers = new long[37837];
        allPantagonNumbers[0] = prevNum;
        for (int i = 1; i < allPantagonNumbers.length; i++) {
            int t = 3 * i + 1;
            prevNum = prevNum + t;
            allPantagonNumbers[i] = prevNum;
        }

        for (int i = in[0]; i < in[1]; i++) {
            for (int j = 0; j + i < allPantagonNumbers.length; j++) {
                long num1 = allPantagonNumbers[j + i], num2 = allPantagonNumbers[j];
                long add = num1 + num2;
                long sub = num1 - num2;
                if (Arrays.binarySearch(allPantagonNumbers, sub) > -1 && Arrays.binarySearch(allPantagonNumbers, add) > -1) {
                    String s = num1 + " " + num2 + " " + add + " " + sub;
                    return s + "";
                }
            }
        }

        //System.out.println(prevNum);
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
