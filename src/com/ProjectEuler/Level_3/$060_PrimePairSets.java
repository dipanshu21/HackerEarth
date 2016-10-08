package com.ProjectEuler.Level_3;

import com.ProjectEuler.Utils.Log;
import com.ProjectEuler.Utils.PrimeUtil;
import com.ProjectEuler.Utils.TimeLogger;
import com.ProjectEuler.Utils.TimeUnit;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by deepanshu on 28/05/16, 1:01 PM.
 */
class $060_PrimePairSets {
    private static final String SPLIT_CHAR = " ";
    private static final int MOD = 1000000007;
    private static final String FILE_NAME = ".txt";
    private static final String TESTCASE_TIME_LOG_MESSAGE = "Time to execute testcase: ";
    private static final String INPUT_TIME_LOG_MESSAGE = "Time to take input: ";
    public static int loopLimit = 1118;
    private static TimeLogger tl = new TimeLogger(TESTCASE_TIME_LOG_MESSAGE, TimeUnit.SECONDS);

    public static void main(String[] args) throws IOException {
        Log.enableLogging();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = rsi(br);
        while (T > 0) {
            //int in = rsi(br);
            tl.startTracking();
            String res = getResult();
            tl.pauseTracking();
            System.out.println(res);
            tl.stopTrackingAndLog();
            T--;
        }
    }

    private static String getResult() {
        int lim = 9000;
        ArrayList<HashSet<Integer>> primeDp = getPrimeDP(lim);
        ArrayList<Long> primes = PrimeUtil.primes;
        long a, b, c, d, e;
        a = b = c = d = e = 0;
        long min = Integer.MAX_VALUE;
        for (int i = 0; i < loopLimit - 4; i++) {
            for (int j = i + 1; j < loopLimit - 3; j++) {
                if (primeDp.get(i).contains(j)) {
                    for (int k = j + 1; k < loopLimit - 2; k++) {
                        if (primeDp.get(i).contains(k) && primeDp.get(j).contains(k)) {
                            for (int l = k + 1; l < loopLimit - 1; l++) {
                                if (primeDp.get(i).contains(l) && primeDp.get(j).contains(l)
                                        && primeDp.get(k).contains(l)) {
                                    for (int m = l + 1; m < loopLimit; m++) {
                                        if (primeDp.get(i).contains(m) && primeDp.get(j).contains(m)
                                                && primeDp.get(k).contains(m)
                                                && primeDp.get(l).contains(m)) {
                                            a = primes.get(i);
                                            b = primes.get(j);
                                            c = primes.get(k);
                                            d = primes.get(l);
                                            e = primes.get(m);
                                            long sum = a + b + c + d + e;
                                            if (sum < min) {
                                                min = sum;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.printf("%5d %5d %5d %5d %5d\nSum: %d\n=======\n", a, b, c, d, e, min);
        return "";
    }

    private static ArrayList<HashSet<Integer>> getPrimeDP(int lim) {
        PrimeUtil.generatePrimesUptoN(lim);
        ArrayList<Long> primes = PrimeUtil.primes;

        int[] powers = new int[]{0, 10, 100, 1000, 10000, 100000};
        ArrayList<HashSet<Integer>> primeDp = new ArrayList<>();
        int[] powerMultiple = new int[primes.size()];

        for (int i = 0; i < primes.size(); i++) {
            try {
                powerMultiple[i] = powers[(int) Math.floor(Math.log10(primes.get(i))) + 1];
            } catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        }


        for (int i = 0; i < loopLimit; i++) {

            HashSet<Integer> t = new HashSet<>(100);
            long primeI = primes.get(i);

            for (int j = i + 1; j < loopLimit; j++) {

                long primeJ = primes.get(j);

                try {

                    int pre = (int) (primeI * powerMultiple[j] + primeJ);
                    int post = (int) (primeJ * powerMultiple[i] + primeI);
                    if (PrimeUtil.isPrime(pre) && PrimeUtil.isPrime(post)) {
                        t.add(j);
                    }

                } catch (ArrayIndexOutOfBoundsException e) {

                    e.printStackTrace();

                }
            }

            primeDp.add(t);
        }

        return primeDp;
    }

    //read multiple strings from a file
    private static String[] rmsff(String fileName) throws IOException {
        BufferedReader br = brff(fileName);

        ArrayList<String> stringArrayList = new ArrayList<>(1000);
        String line;
        while ((line = br.readLine()) != null) {
            stringArrayList.add(line);
        }

        return litoStrArr(stringArrayList);
    }

    //Assumes str arr contains numbers
    private static int[] strToIntArr(String[] arr) {
        int[] intArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            intArr[i] = i(arr[i]);
        }

        return intArr;
    }

    //gets a buffered reader for a file, bufferred reader for a file
    private static BufferedReader brff(String fileName) throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        return br;
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

    //print array
    private static <T> void par(T[] arr) {
        for (T a : arr) {
            System.out.println(a.toString());
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
}
