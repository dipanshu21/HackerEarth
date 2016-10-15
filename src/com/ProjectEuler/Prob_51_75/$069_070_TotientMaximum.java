package com.ProjectEuler.Prob_51_75;

import com.ProjectEuler.Utils.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by deepanshu on 09/10/16, 10:56.
 */
public class $069_070_TotientMaximum {
    private static final String SPLIT_CHAR = " ";
    private static final int MOD = 1000000007;
    private static final String FILE_NAME = ".txt";
    private static final String TESTCASE_TIME_LOG_MESSAGE = "Time to execute testcase: ";
    private static final String INPUT_TIME_LOG_MESSAGE = "Time to take input: ";
    private static final FastScanner sc = new FastScanner(new BufferedReader(new InputStreamReader(System.in)));
    public static int[] dp = new int[10000001];
    private static FastScanner fsc = null;
    private static PrintWriter out = null;
    private static TimeLogger tl = new TimeLogger(TESTCASE_TIME_LOG_MESSAGE, TimeUnit.MILLI_SECONDS, out);
    private static ArrayList<Long> primes = null;

    public static void main(String[] args) throws Exception {
        //initFileScanner();
        Log.enableLogging(out);
        int T = sc.nextInt();
        while (T > 0) {
            tl.startTracking();
            getResult();
            tl.pauseTracking();
            tl.stopTrackingAndLog();
            T--;
        }
        if (out != null) {
            out.close();
        }
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

    public static void getResult() {
        PrimeUtil.generatePrimesUptoN(10000000);
        primes = PrimeUtil.primes;

        //Marking all the primes to n-1
        for (int i = 0; i < primes.size() - 1; i++) {
            int prime = primes.get(i).intValue();
            dp[prime] = prime - 1;
        }

        for (int i = 0; i < 1050; i++) {
            dp[i] = coutRelativePrimesBruteForce(i);
        }

        //calculating remaining using dp
        for (int i = 10000000; i > 2; i--) {
            if (dp[i] == 0) {
                countRelativePrimes(i);
            }
        }

        double minRatio = 5000000;
        int maxN = -1;

        for (int i = 3; i < dp.length; i++) {
            if (isPermutation(i, dp[i])) {
                double curRatio = i / (dp[i] * 1.0);
                if (curRatio < minRatio) {
                    minRatio = curRatio;
                    maxN = i;
                }
            }
        }

        Log.logString("N: " + maxN);
    }

    public static boolean isPermutation(int a, int b) {
        int[] dp = new int[10];
        while (a > 0) {
            dp[a % 10]++;
            a /= 10;
        }

        while (b > 0) {
            dp[b % 10]--;
            b /= 10;
        }

        for (int i : dp) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }

    public static int countRelativePrimes(int n) {

        if (dp[n] == 0) {
            if ((n & 1) == 0) {
                int half = n / 2, relativePrimeHalf = countRelativePrimes(half);
                dp[n] = (half & 1) == 0 ? 2 * relativePrimeHalf : relativePrimeHalf;
            } else {
                int divisor = 0;
                int divident = 0;
                for (Long p : primes) {
                    int t = p.intValue();
                    if (n % t == 0) {
                        divisor = t;
                        divident = n / t;
                        break;
                    }
                }

                int rpsDvsr = countRelativePrimes(divisor), rpsDvdnt = countRelativePrimes(divident);
                int gcd = GCDUtil.gcdNum(divisor, divident);
                if (gcd == 1) {
                    dp[n] = rpsDvdnt * rpsDvsr;
                } else {
                    dp[n] = (rpsDvdnt * rpsDvsr * gcd) / (countRelativePrimes(gcd));
                }
            }
        }

        return dp[n];
    }

    public static int coutRelativePrimesBruteForce(int n) {
        int c = 0;
        for (int i = 1; i < n; i++) {
            if (GCDUtil.gcdNum(i, n) == 1) {
                c++;
            }
        }

        return c;
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

    //fil array
    private static void filArr(int[] a, int v) {
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
