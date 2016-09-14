package com.hackerearth.math.ModulerArithmatic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

class RhezoAndBigPowers {
    private static final int MOD = 1000000007;
    private static final FastScanner sc = new FastScanner(new BufferedReader(new InputStreamReader(System.in)));
    private static final BigInteger ZERO = BigInteger.valueOf(0);
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private static final BigInteger TWO = BigInteger.valueOf(2);
    private static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws Exception {
        long a = sc.nextLong();
        String b = sc.next();
        out.print(getResult(a, b));
        out.close();
    }

    private static String getResult(long a, String b) {
        long bnum = 0;
        return "";

    }

    //Convert string to integer
    private static long l(String s) {
        return Long.parseLong(s);
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

        public long nextLong() throws Exception {
            return l(nextToken());
        }

    }
}
