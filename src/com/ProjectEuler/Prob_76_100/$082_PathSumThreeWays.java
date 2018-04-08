package com.ProjectEuler.Prob_76_100;

import com.ProjectEuler.Utils.Log;
import com.ProjectEuler.Utils.TimeLogger;
import com.ProjectEuler.Utils.TimeUnit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by deepanshu on 25/08/16, 7:16 PM.
 */
class $082_PathSumThreeWays {
    private static final String SPLIT_CHAR = " ";
    private static final int MOD = 1000000007;
    private static final String FILE_NAME = "p082_matrix.txt";
    private static final String TESTCASE_TIME_LOG_MESSAGE = "Time to execute testcase: ";
    private static final String INPUT_TIME_LOG_MESSAGE = "Time to take input: ";
    private static final FastScanner sc = new FastScanner(new BufferedReader(new InputStreamReader(System.in)));
    private static FastScanner fsc = null;
    private static PrintWriter out = new PrintWriter(System.out);
    private static TimeLogger tl = new TimeLogger(TESTCASE_TIME_LOG_MESSAGE, TimeUnit.SECONDS, out);

    public static void main(String[] args) throws Exception {
        initFileScanner();
        Log.enableLogging();
        tl.startTracking();
        String res = getResult(readMatrix());
        tl.pauseTracking();
        print(res);
        tl.stopTrackingAndLog();
        if (out != null) {
            out.close();
        }
    }

    private static int[][] readMatrix() throws Exception {
        int[][] matrix = new int[80][80];
        String[] lines = fsc.next(80);

        for (int i = 0; i < matrix.length; i++) {
            String[] values = lines[i].split(",");
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Integer.parseInt(values[j]);
            }
        }

        return matrix;
    }

    private static void print(String str) {
        if (out == null) {
            System.out.println(str);
        } else {
            out.println(str);
        }
    }

    private static void initFileScanner() throws Exception {
        fsc = new FastScanner(new BufferedReader(new FileReader(FILE_NAME)));
    }

    private static String getResult(int[][] matrix) {
        List<Integer> min = new ArrayList<>(1);
        boolean[][] visited = new boolean[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            findMin(matrix, i, 0, 0, min, visited);
            tl.logSoFar("Testcase " + i + ": ");
        }

        return min.get(0) + "";
    }

    private static void findMin(int[][] matrix, int r, int c, int sumSoFar, List<Integer> min, boolean[][] visited) {
        if (r >= matrix.length || c >= matrix.length || r < 0 || c < 0) {
            return;
        }

        if (c == matrix.length - 1) {
            setMin(min, matrix[r][c] + sumSoFar);
            return;
        }

        if (visited[r][c]) {
            return;
        }

        sumSoFar += matrix[r][c];
        visited[r][c] = true;

        findMin(matrix, r, c + 1, sumSoFar, min, visited);
        findMin(matrix, r - 1, c, sumSoFar, min, visited);
        findMin(matrix, r + 1, c, sumSoFar, min, visited);

        visited[r][c] = false;
    }

    private static void setMin(List<Integer> min, int m) {
        if (min.size() == 0) {
            min.add(m);
        } else {
            min.set(0, Math.min(min.get(0), m));
        }
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
