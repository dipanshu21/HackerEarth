package com.ProjectEuler;

import com.ProjectEuler.ProblemHelpers.FigurateNumberUtil;
import com.ProjectEuler.Utils.Log;
import com.ProjectEuler.Utils.TimeLogger;
import com.ProjectEuler.Utils.TimeUnit;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by deepanshu on 12/06/16, 9:48 AM.
 */
class $061_CyclicFigurateNumbers {
    private static final String SPLIT_CHAR = " ";
    private static final int MOD = 1000000007;
    private static final String FILE_NAME = ".txt";
    private static final String TESTCASE_TIME_LOG_MESSAGE = "Time to execute testcase: ";
    private static final String INPUT_TIME_LOG_MESSAGE = "Time to take input: ";
    private static final String[] nums = new String[]{"Triangle", "Square", "Penta", "Hexa", "Hepta", "Octa"};
    private static TimeLogger tl = new TimeLogger(TESTCASE_TIME_LOG_MESSAGE, TimeUnit.MILLI_SECONDS);

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
        FigurateNumberUtil fbu = new FigurateNumberUtil();

        int[][][] dp = new int[6][100][2];
        init(dp);

        for (int i = 0; i < 140; i++) {
            store(dp, 0, fbu.getTriangleNumber(i));
            store(dp, 1, fbu.getSquareNumber(i));
            store(dp, 2, fbu.getPentagonalNumber(i));
            store(dp, 3, fbu.getHexagonalNumber(i));
            store(dp, 4, fbu.getHeptagonalNumber(i));
            store(dp, 5, fbu.getOctagonalNumber(i));

        }
        //print(dp);
        findAll(dp);
        return "";
    }

    private static void init(int[][][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                for (int k = 0; k < dp[i][j].length; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
    }

    private static void store(int[][][] dp, int index, int n) {
        if (n > 999 && n < 9999) {
            int f = n / 100;
            int e = n % 100;
            if (e > 9) {
                int i;
                if (dp[index][f][0] == -1) {
                    i = 0;
                } else {
                    i = 1;
                }

                dp[index][f][i] = e;
            }
        }
    }

    private static void print(int[][][] dp) {
        int count = 0;
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            Log.logString(nums[i]);
            int indC = 0;
            for (int j = 0; j < dp[i].length; j++) {
                for (int k = 0; k < dp[i][j].length; k++) {
                    if (dp[i][j][k] != -1) {
                        Log.logString(j + "" + dp[i][j][k]);
                        count++;
                        indC++;
                        max = Math.max(max, k);
                    }
                }
            }
            Log.logString("==================");
            Log.logString(indC + "");
            Log.logString("==================");
        }

        Log.logString(count + "");
        Log.logString(max + "");
    }

    public static void findAll(int[][][] dp) {
        for (int k = 0; k < 6; k++) {
            boolean[] soFar = new boolean[6];
            soFar[k] = true;
            int[] numsoFar = new int[6];
            for (int i = 0; i < 100; i++) {
                boolean breaks = false;
                for (int j = 0; j < 2; j++) {
                    int t = dp[k][i][j];
                    if (t != -1) {
                        numsoFar[k] = i * 100 + t;
                        if (findNumber(dp, soFar, numsoFar, 1, t, k)) {
                            //par(numsoFar);
                            Log.logString("===============");
                            breaks = true;
                            break;
                        }
                        numsoFar[k] = 0;
                    }
                }

                if (breaks) {
                    break;
                }
            }
        }
    }

    public static boolean findNumber(int[][][] dp, boolean[] soFar, int[] soFarNum, int curType, int curNum, int start) {
        soFar[curType] = true;

        for (int j = 0; j < 2; j++) {
            int t = dp[curType][curNum][j];
            if (t != -1) {
                soFarNum[curType] = curNum * 100 + t;
                if (arrAnd(soFar)) {
                    if (soFarNum[start] / 100 == t) {
                        par(soFarNum);
                        System.out.println("sum: " + sum(soFarNum));
                        soFarNum[curType] = 0;
                        soFar[curType] = false;
                        return true;
                    } else {
                        soFarNum[curType] = 0;
                        soFar[curType] = false;
                        return false;
                    }
                }
                for (int i = 0; i < soFar.length; i++) {
                    if (!soFar[i]) {
                        if (findNumber(dp, soFar, soFarNum, i, t, start)) {
                            soFarNum[curType] = 0;
                            soFar[curType] = false;
                            return true;
                        }
                    }
                }
                soFarNum[curType] = 0;
            }
        }
        soFar[curType] = false;
        return false;
    }

    private static int sum(int[] arr) {
        int sum = 0;

        for (int a : arr) {
            sum += a;
        }

        return sum;
    }

    private static void par(int[] arr) {
        for (int a : arr) {
            System.out.println(a);
        }
    }

    private static void removeDulplicates(boolean[][][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                for (int k = 0; k < dp[i][j].length; k++) {
                    if (dp[i][j][k]) {
                        boolean found = false;

                        for (int jp = j + 1; jp < dp[i].length; jp++) {
                            if (dp[i][jp][k]) {
                                found = true;
                                dp[i][jp][k] = false;
                            }
                        }

                        if (found) {
                            dp[i][j][k] = false;
                        }
                    }
                }
            }
        }
    }

    public static boolean arrAnd(boolean[] arr) {
        boolean res = true;
        for (boolean b : arr) {
            res &= b;
        }

        return res;
    }

    public static int getGreatestNotFound(boolean[] soFar) {
        for (int i = soFar.length - 1; i > -1; i--) {
            if (!soFar[i]) {
                return i;
            }
        }

        return -1;
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
