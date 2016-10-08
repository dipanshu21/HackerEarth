package com.ProjectEuler.Level_3;

import com.ProjectEuler.Utils.Log;
import com.ProjectEuler.Utils.TimeLogger;
import com.ProjectEuler.Utils.TimeUnit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by deepanshu on 26/06/16, 12:19 PM.
 */
class $066_Diophantine_Equation {
    private static final String SPLIT_CHAR = " ";
    private static final String TESTCASE_TIME_LOG_MESSAGE = "Time to execute testcase: ";
    private static TimeLogger tl = new TimeLogger(TESTCASE_TIME_LOG_MESSAGE, TimeUnit.MILLI_SECONDS);

    public static void main(String[] args) throws IOException {
        Log.enableLogging();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = rsi(br);
        while (T > 0) {
            int in = rsi(br);
            tl.startTracking();
            String res = getResult(in);
            tl.pauseTracking();
            System.out.println(res);
            tl.stopTrackingAndLog();
            T--;
        }
    }

    private static String getResult(int d) {
        int range = 10000;

        long[] squares = new long[range];
        HashMap<Long, Long> squaresHash = new HashMap<>(range);
        long t = 0;

        for (long i = 0; i < squares.length; i++) {
            t = i * i;
            squares[(int) i] = t;
            squaresHash.put(t, i);
        }

        getMinXForD(squares, squaresHash, d);
        return "";
    }

    private static long getMinXForD(long[] sqrs, Map<Long, Long> sqrMap, long d) {
        long x = -243;
        long fac;
        for (int y = 1; y < sqrs.length; y++) {
            fac = (sqrs[y] * d) + 1;
            if (sqrMap.containsKey(fac)) {
                long a = sqrMap.get(fac);
                Log.logString(a + "^2 + (" + d + " * " + y + "^2) = 1");
                return sqrMap.get(fac);
            }
        }

        return x;
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

    //Convert string to integer
    private static int i(String s) {
        return Integer.parseInt(s);
    }
}
