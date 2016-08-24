package com.hackerearth.easy_track;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by deepanshu on 30/12/15, 8:34 AM.
 */
class PKNewLanguage {
    private static final String SPLIT_CHAR = " ";
    private static final long MOD = 1000000007l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[][] languageEncoding = new long[26][26];
        for (int i = 0; i < 26; i++) {
            int[] temp = rmi(br);
            for (int j = 0; j < 26; j++) {
                languageEncoding[i][j] = temp[j];
            }
        }

        int T = rsi(br);
        while (T > 0) {
            String[] temp = rv(br);
            int endingPos = temp[0].charAt(0) - 'a';
            int len = i(temp[1]);
            System.out.println(getResult(languageEncoding, endingPos, len));
            T--;
        }
    }

    private static long getResult(long[][] encoding, int endingPos, int len) {
        long[][] mat = matrixPow(encoding, len - 1);

        long res = 0;

        for (int i = 0; i < 26; i++) {
            res = (res + mat[i][endingPos]) % MOD;
        }

        return res;
    }

    private static long[][] matrixPow(long mat[][], int n) {
        if (n == 0) {
            return getIdentity();
        }
        if (n % 2 == 0) {
            long[][] matHalf = matrixPow(mat, n / 2);
            return multiply(matHalf, matHalf);
        } else {
            return multiply(mat, matrixPow(mat, n - 1));
        }
    }

    private static long[][] getIdentity() {
        long[][] mat = new long[26][26];

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (i == j) {
                    mat[i][j] = 1;
                }
            }
        }

        return mat;
    }

    private static long[][] multiply(long[][] mat1, long[][] mat2) {
        long[][] res = new long[mat1.length][mat2[0].length];

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                long r = 0;
                for (int k = 0; k < 26; k++) {
                    r = (r + ((mat1[i][k] * mat2[k][j]) % MOD)) % MOD;
                }
                res[i][j] = r;
            }
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

    //Read string values
    private static String[] rv(BufferedReader br) throws IOException {
        return br.readLine().split(SPLIT_CHAR);
    }

    //Convert string to integer
    private static int i(String s) {
        return Integer.parseInt(s);
    }

    //Convert string to long
    private static long l(String s) {
        return Long.parseLong(s);
    }
}
