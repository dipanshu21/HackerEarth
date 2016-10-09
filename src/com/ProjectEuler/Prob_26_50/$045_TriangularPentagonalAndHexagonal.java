package com.ProjectEuler.Prob_26_50;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by deepanshu on 18/05/16, 6:09 AM.
 */
class $045_TriangularPentagonalAndHexagonal {
    private static final String SPLIT_CHAR = " ";
    private static final int MOD = 1000000007;

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

    private static String getResult() {
        long[][] sqrs = generatePerfectSquares();

        long preTrian = 1;
        boolean isFound = false;

        long i = 2;
        while (!isFound) {
            preTrian += i;
            int x = Arrays.binarySearch(sqrs[1], 24 * preTrian + 1);
            int y = Arrays.binarySearch(sqrs[0], 8 * preTrian + 1);
            if (x > -1 && y > -1) {
                double penta = (Math.sqrt(sqrs[1][x]) + 1) / 6.0;
                double hexa = (Math.sqrt(sqrs[0][y]) + 1) / 4.0;
                System.out.println("Triang: " + i);
                System.out.println("Penta:  " + penta);
                System.out.println("Hexa:   " + hexa);
                System.out.println("\n");
                if (i > 285) {
                    isFound = true;
                }
            }
            i++;
        }


        return "";
    }

    //[0] contains divisible by 4 and [1] contains divisible by 3
    private static long[][] generatePerfectSquares() {
        ArrayList<Long> a = new ArrayList<>(10000);
        ArrayList<Long> b = new ArrayList<>(10000);

        for (long i = 1; i < 1000000; i += 2) {
            long sqr = i * i;
            if ((i + 1) % 4 == 0) {
                a.add(sqr);
            }

            if ((i + 1) % 3 == 0) {
                b.add(sqr);
            }
        }

        long[][] res = new long[2][];
        res[0] = new long[a.size()];
        res[1] = new long[b.size()];

        for (int i = 0; i < a.size(); i++) {
            res[0][i] = a.get(i);
        }

        for (int i = 0; i < b.size(); i++) {
            res[1][i] = b.get(i);
        }

        return res;
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
