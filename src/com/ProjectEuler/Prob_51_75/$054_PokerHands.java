package com.ProjectEuler.Prob_51_75;

import com.ProjectEuler.ProblemHelpers.CardParser;
import com.ProjectEuler.ProblemHelpers.PokerHandComparator;
import com.ProjectEuler.Utils.Log;
import com.ProjectEuler.Utils.TimeLogger;
import com.ProjectEuler.Utils.TimeUnit;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by deepanshu on 21/05/16, 2:32 PM.
 */
class $054_PokerHands {
    private static final String SPLIT_CHAR = " ";
    private static final int MOD = 1000000007;
    private static final String FILE_NAME = "p054_poker.txt";
    private static final String TESTCASE_TIME_LOG_MESSAGE = "Time to execute testcase: ";
    private static final String INPUT_TIME_LOG_MESSAGE = "Time to take input: ";
    private static TimeLogger tl = new TimeLogger(TESTCASE_TIME_LOG_MESSAGE, TimeUnit.SECONDS);
    private static int[][][][] input;

    public static void main(String[] args) throws IOException {
        Log.enableLogging();

        //Taking input
        tl.setTitleUnit(INPUT_TIME_LOG_MESSAGE, TimeUnit.MILLI_SECONDS);
        tl.startTracking();
        String[] cases = rmsff(FILE_NAME);
        input = parseInput(cases);
        tl.stopTrackingAndLog();

        tl.setTitleUnit(TESTCASE_TIME_LOG_MESSAGE, TimeUnit.MILLI_SECONDS);
        //Executing test cases
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

    private static String getResult() throws IOException {
        int len = input.length;
        Log.disableLogging();
        for (int i = 0; i < len; i++) {
            Log.logString("#" + (i + 1));
            Log.logString("Hand 1: " + CardParser.getMinifiedStringForHand(input[i][0]));
            Log.logString("Hand 2: " + CardParser.getMinifiedStringForHand(input[i][1]));
            int win = PokerHandComparator.getWinner(input[i][0], input[i][1]);
            Log.logString("Winner: Player " + win);
        }

        return "";
    }

    private static int[][][][] parseInput(String[] cases) {
        int[][][][] in = new int[cases.length][2][5][2];

        for (int i = 0; i < cases.length; i++) {
            String[] t = cases[i].split(SPLIT_CHAR);
            for (int j = 0; j < 5; j++) {
                in[i][0][j] = CardParser.parseCard(t[j]);
                in[i][1][j] = CardParser.parseCard(t[j + 5]);
            }
        }

        return in;
    }

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
    private static <T> void parli(List<T> list) {
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
