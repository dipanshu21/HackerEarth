package com.ProjectEuler.Prob_51_75;

import com.ProjectEuler.Utils.Log;
import com.ProjectEuler.Utils.MutableInteger;
import com.ProjectEuler.Utils.TimeLogger;
import com.ProjectEuler.Utils.TimeUnit;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by deepanshu on 13/06/16, 4:14 PM.
 */
class $064_OddPeriodSquareRoots {
    private static final String SPLIT_CHAR = " ";
    private static final int MOD = 1000000007;
    private static final String FILE_NAME = ".txt";
    private static final String TESTCASE_TIME_LOG_MESSAGE = "Time to execute testcase: ";
    private static final String INPUT_TIME_LOG_MESSAGE = "Time to take input: ";
    private static TimeLogger tl = new TimeLogger(TESTCASE_TIME_LOG_MESSAGE, TimeUnit.MILLI_SECONDS);
    private static int[] squareRootCeil = new int[10001];
    private static int[] squareRootFloor = new int[10001];
    private static int[] squares = new int[101];

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

    private static void fillDP() {
        int prevSqr = 1;
        int curSqr = 0;
        squares[1] = 1;
        for (int i = 2; i < 101; i++) {
            curSqr = i * i;
            squares[i] = curSqr;
            squareRootCeil[curSqr] = squareRootFloor[curSqr] = -1;
            for (int j = prevSqr + 1; j < curSqr; j++) {
                squareRootFloor[j] = i - 1;
                squareRootCeil[j] = i;
            }
            prevSqr = curSqr;
        }
    }

    private static String getResult() {
        fillDP();

        return "";
    }

    private static void getNextTermAndAlpha(int numerator, int n, int sub, MutableInteger alpha, MutableInteger newSub, MutableInteger newNumerator) {
        MutableInteger newDenom = new MutableInteger();
        changeForm(n, sub, numerator, newDenom);

    }

    private static void changeForm(int n, int alpha, int numerater, MutableInteger newDenom) {
        int denom = n - alpha * alpha;
        newDenom.n = denom / numerater;
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
