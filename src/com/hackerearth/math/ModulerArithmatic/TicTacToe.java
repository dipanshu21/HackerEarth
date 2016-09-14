package com.hackerearth.math.ModulerArithmatic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by deepanshu on 28/08/16, 16:54.
 */
class TicTacToe {
    private static final String SPLIT_CHAR = " ";
    private static final int MOD = 1000000007;
    private static final FastScanner sc = new FastScanner(new BufferedReader(new InputStreamReader(System.in)));
    private static final long MOD_INV_6 = findModuloInverse(6, MOD);
    private static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws Exception {
        int T = sc.nextInt();
        while (T > 0) {
            long n = sc.nextLong();
            getResult(n);
            T--;
        }
        out.close();
    }

    private static void getResult(long n) {
        long max = sumOfSqrs(n - 1);
        long min;

        long n_minus_1 = n - 1;
        long min_game_everyone = n_minus_1 / 2, min_game_sqr = (min_game_everyone * min_game_everyone) % MOD;

        if (n_minus_1 % 2 == 0) {
            min = (n * min_game_sqr) % MOD;
        } else {
            long min_game_plus_1 = min_game_everyone + 1, min_game_plus_sqr = (min_game_plus_1 * min_game_plus_1) % MOD;
            long n_by_2 = n / 2;
            min = ((n_by_2 * min_game_plus_sqr) % MOD) + ((n_by_2 * min_game_plus_sqr) % MOD);
        }

        out.println(min + " " + max);
    }

    private static long sumOfSqrs(long n) {
        long n_plus_1 = (n + 1) % MOD;
        long two_n = (2 * n) % MOD;
        long two_n_plus_1 = (two_n + 1) % MOD;
        long sos = (n * n_plus_1) % MOD;
        sos = (sos * two_n_plus_1) % MOD;

        return (sos * MOD_INV_6) % MOD;
    }

    private static long factorial(int num) {
        long res = 1;

        for (int i = 2; i <= num; i++) {
            res = (res * i) % MOD;
        }

        return res;
    }

    private static long findModuloInverse(long n, long m) {
        return fast_pow(n, m - 2, m);
    }

    private static long fast_pow(long base, long n, long M) {
        if (n == 0)
            return 1;
        if (n == 1)
            return base;
        long halfn = fast_pow(base, n / 2, M);
        if (n % 2 == 0)
            return (halfn * halfn) % M;
        else
            return (((halfn * halfn) % M) * base) % M;
    }

    //Assumes str arr contains numbers
    private static int[] strToIntArr(String[] arr) {
        int[] intArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            intArr[i] = i(arr[i]);
        }

        return intArr;
    }

    //Convert string to integer
    private static int i(String s) {
        return Integer.parseInt(s);
    }

    //Convert string to long
    private static long l(String s) {
        return Long.parseLong(s);
    }

    //Convert string to double
    private static double d(String s) {
        return Double.parseDouble(s);
    }

    //fil array
    private static <T> void filArr(T[] a, T v) {
        for (int i = 0; i < a.length; i++) {
            a[i] = v;
        }
    }

    //printArrayList
    private static <T> void parli(ArrayList<T> list) {
        for (T a : list) {
            out.println(a.toString());
        }
    }

    //print array
    private static <T> void par(T[] arr) {
        for (T a : arr) {
            out.println(a.toString());
        }
    }

    //list to string arr
    private static String[] litoStrArr(List<String> list) {
        String[] arr = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }

    //list to integer array
    private static int[] litoIntArr(List<Integer> list) {
        int[] arr = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }

    private static class FastScanner {
        BufferedReader in;
        StringTokenizer st;

        public FastScanner(BufferedReader in) {
            this.in = in;
        }

        public String nextToken() throws Exception {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(in.readLine());
            }
            return st.nextToken();
        }

        public String next() throws Exception {
            return nextToken();
        }

        public int nextInt() throws Exception {
            return i(nextToken());
        }

        public long nextLong() throws Exception {
            return l(nextToken());
        }

        public double nextDouble() throws Exception {
            return d(nextToken());
        }

        public int[] nextInt(int n) throws Exception {
            int[] res = new int[n];

            for (int i = 0; i < n; i++) {
                res[i] = nextInt();
            }

            return res;
        }

        public long[] nextLong(int n) throws Exception {
            long[] res = new long[n];

            for (int i = 0; i < n; i++) {
                res[i] = nextLong();
            }

            return res;
        }

        public double[] nextDouble(int n) throws Exception {
            double[] res = new double[n];

            for (int i = 0; i < n; i++) {
                res[i] = nextDouble();
            }

            return res;
        }

        public String[] next(int n) throws Exception {
            String[] res = new String[n];

            for (int i = 0; i < n; i++) {
                res[i] = next();
            }

            return res;
        }
    }
}
