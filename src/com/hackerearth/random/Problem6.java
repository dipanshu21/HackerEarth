package com.hackerearth.random;

import com.ProjectEuler.Utils.Log;
import com.ProjectEuler.Utils.TimeLogger;
import com.ProjectEuler.Utils.TimeUnit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by deepanshu on 21/08/16, 12:47 PM.
 */
class Problem6 {
    private static final String SPLIT_CHAR = " ";
    private static final String TESTCASE_TIME_LOG_MESSAGE = "Time to execute testcase: ";
    private static final String YES = "YES";
    private static final String NO = "NO";
    private static TimeLogger tl = new TimeLogger(TESTCASE_TIME_LOG_MESSAGE, TimeUnit.MILLI_SECONDS);
    private static int[][] cacheMul = new int[10][10];

    static {
        for (int i = 0; i < cacheMul.length; i++) {
            for (int j = 0; j < cacheMul.length; j++) {
                cacheMul[i][j] = (i * 10 + j) % 7;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Log.enableLogging();
        TimeLogger totalTime = new TimeLogger("Total time to execute full program", TimeUnit.MILLI_SECONDS);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        byte[] inputNumber = charToDigArr(rss(br).toCharArray());
        totalTime.startTracking();
        int T = rsi(br);
        while (T > 0) {
            int[] in = rmi(br);
            //tl.startTracking();
            boolean res = getResult(inputNumber, in);
            //tl.pauseTracking();
            System.out.println(res ? YES : NO);
            //tl.stopTrackingAndLog();
            T--;
        }
        totalTime.stopTrackingAndLog();
    }

    private static boolean getResult(byte[] input, int[] n) {
        int lim = n[1];
        int rem = 0;
        for (int i = n[0] - 1; i < lim; i++) {
            rem = cacheMul[rem][input[i]];
        }

        return rem == 0;
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

    private static byte[] charToDigArr(char[] arr) {
        byte[] res = new byte[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = (byte) (arr[i] - '0');
        }

        return res;
    }
}
