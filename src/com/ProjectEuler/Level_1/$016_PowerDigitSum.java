package com.ProjectEuler.Level_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by deepanshu on 07/05/16, 3:53 PM.
 */
class $016_PowerDigitSum {
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
        BigInteger two = new BigInteger("2");

        BigInteger two24 = new BigInteger("1");

        int prevDig = 0;
        for (int i = 0; i < 1000; i++) {
            two24 = two24.multiply(two);

            if ((i + 1) % 100 == 0) {
                int curSum = getSum(two24);
                System.out.printf("%3d %5d %5d\n", i + 1, getSum(two24), curSum - prevDig);
                prevDig = curSum;
            }
        }

        two = two.multiply(two); //2
        two = two.multiply(two); //4
        two = two.multiply(two); //8
        two = two.multiply(two); //16
        two = two.multiply(two); //32
        two = two.multiply(two); //64
        two = two.multiply(two); //128
        two = two.multiply(two); //256
        two = two.multiply(two); //512
        two = two.multiply(two); //1024

        two = two.divide(two24);

        int sum = 0;

        for (char c : two.toString().toCharArray()) {
            sum += c - '0';
        }

        return two.toString() + "\n" + sum;
    }

    private static int getSum(BigInteger b) {
        int sum = 0;
        for (char c : b.toString().toCharArray()) {
            sum += (c - '0');
        }

        return sum;
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
