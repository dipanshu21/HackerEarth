package com.ProjectEuler.Prob_26_50;

import com.ProjectEuler.Utils.NumberUtil;
import com.ProjectEuler.Utils.PrimeUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by deepanshu on 10/05/16, 7:19 AM.
 */
class $029_DistinctPowers {
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
        ArrayList<ArrayList<int[]>> distinct = new ArrayList<>(99 * 99);

        int lim = 100;
        PrimeUtil.generatePrimesUptoNSieve(101);

        for (int a = 2; a <= lim; a++) {
            ArrayList<int[]> primeFactors = NumberUtil.getPrimeFactorisation(a, PrimeUtil.primes);
            for (int b = 2; b <= lim; b++) {
                ArrayList<int[]> curFactors = putPower(primeFactors, b);
                if (!isExists(distinct, curFactors)) {
                    distinct.add(curFactors);
                }
            }
        }

        return distinct.size() + "";
    }

    private static boolean isExists(ArrayList<ArrayList<int[]>> listFacts, ArrayList<int[]> fact) {
        for (ArrayList<int[]> f : listFacts) {
            if (areFactEqual(f, fact)) {
                return true;
            }
        }

        return false;
    }

    private static boolean areFactEqual(ArrayList<int[]> fact1, ArrayList<int[]> fact2) {
        if (fact1.size() == fact2.size()) {
            for (int i = 0; i < fact1.size(); i++) {
                int[] f1 = fact1.get(i);
                int[] f2 = fact2.get(i);

                if (f1[0] != f2[0] || f1[1] != f2[1]) {
                    return false;
                }
            }

            return true;
        }

        return false;
    }

    private static ArrayList<int[]> putPower(ArrayList<int[]> primeFacts, int p) {
        ArrayList<int[]> newFact = new ArrayList<>();
        for (int[] i : primeFacts) {
            newFact.add(new int[]{i[0], i[1] * p});
        }

        return newFact;
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
