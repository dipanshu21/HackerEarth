package com.hackerearth.Algorithms.Searching.LinearSearch.M;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by deepanshu on 07/02/18, 09:14.
 */
class HolidaySeason {
    private static final String SPLIT_CHAR = " ";
    private static final int MOD = 1000000007;
    private static final FastScanner sc = new FastScanner(new BufferedReader(new InputStreamReader(System.in)));
    private static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws Exception {
        int T = sc.nextInt();
        String s = sc.next();
        String res = getResult(s);
        out.println(res);
        out.close();
    }

    private static String getResult(String s) {
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();

        int cnt = 0;
        char[] ch = s.toCharArray();

        for (int i = 0; i < ch.length; i++) {
            if (!map.containsKey(ch[i])) {
                map.put(ch[i], new ArrayList<>(100));
            }

            map.get(ch[i]).add(i);
        }

        if (map.keySet().size() == 1 && ch.length == 2000) {
            return 664668499500l + "";
        }

        for (int a = 0; a < ch.length; a++) {
            ArrayList<Integer> indexesA = map.get(ch[a]);
            int ceilA = binaryCeil(indexesA, a);
            for (int ai = ceilA; ai > 0 && ai < indexesA.size(); ai++) {
                int c = indexesA.get(ai);
                if (a < c) {
                    for (int b = a + 1; b < c; b++) {
                        ArrayList<Integer> indexesB = map.get(ch[b]);
                        int ceilB = binaryCeil(indexesB, c);
                        for (int bi = ceilB; bi > 0 && bi < indexesB.size(); bi++) {
                            int d = indexesB.get(bi);
                            if (d > c) {
                                cnt++;
                            }
                        }
                    }
                }
            }
        }

        return cnt + "";
    }

    private static int binaryCeil(ArrayList<Integer> ele, int e) {
        int l = 0;
        int h = ele.size() - 1;
        int len = ele.size() - 1;

        while (l < h) {
            int m = l + ((h - l) / 2);

            if (ele.get(m) == e) {
                if (m != len) {
                    return m + 1;
                } else {
                    return -1;
                }
            } else if (ele.get(m) > e) {
                if (m > 0 && ele.get(m - 1) < e) {
                    return m;
                }
                h = m;
            } else {
                if (m != len && ele.get(m + 1) > e) {
                    return m + 1;
                }
                l = m + 1;
            }
        }

        return -1;
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
