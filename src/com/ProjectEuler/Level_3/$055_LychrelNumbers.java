package com.ProjectEuler.Level_3;

import com.ProjectEuler.Utils.Log;
import com.ProjectEuler.Utils.StringUtil;
import com.ProjectEuler.Utils.TimeLogger;
import com.ProjectEuler.Utils.TimeUnit;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by deepanshu on 22/05/16, 4:46 PM.
 */
class $055_LychrelNumbers {
    private static final String SPLIT_CHAR = " ";
    private static final int MOD = 1000000007;
    private static final String FILE_NAME = ".txt";
    private static final String TESTCASE_TIME_LOG_MESSAGE = "Time to execute testcase: ";
    private static final String INPUT_TIME_LOG_MESSAGE = "Time to take input: ";
    private static TimeLogger tl = new TimeLogger(TESTCASE_TIME_LOG_MESSAGE, TimeUnit.SECONDS);

    public static void main(String[] args) throws IOException {
        Log.enableLogging();
        tl.setTitleUnit("Testcase", TimeUnit.MILLI_SECONDS);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = rsi(br);
        while (T > 0) {
            tl.startTracking();
            String res = getResult();
            tl.pauseTracking();
            System.out.println(res);
            tl.stopTrackingAndLog();
            T--;
        }
    }

    private static String getResult() {
        final int lim = 10001;
        final int iter_lim = 50;
        int count = 0;

        for (int i = 1; i < lim; i++) {
            int j = 0;
            BigInteger prev = new BigInteger(i + "");
            BigInteger rev = reverseBigInt(prev);
            while (j < iter_lim) {
                BigInteger newNum = prev.add(rev);
                rev = reverseBigInt(newNum);
                prev = newNum;
                if (newNum.toString().equals(rev.toString())) {
                    Log.logString("#" + i);
                    Log.logString("Iteration: " + (j + 1));
                    Log.logString(newNum.toString());
                    Log.logString("");
                    count++;
                    break;
                }
                j++;
            }
        }
        return 10000 - count + "";
    }

    public static BigInteger reverseBigInt(BigInteger bi) {
        return new BigInteger(StringUtil.reverseString(bi.toString()));
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
