package com.ProjectEuler.Level_3;

import com.ProjectEuler.Utils.Log;
import com.ProjectEuler.Utils.TimeLogger;
import com.ProjectEuler.Utils.TimeUnit;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by deepanshu on 08/10/16, 21:58.
 */
class $068_Magic5_gonRing {
    private static final String TESTCASE_TIME_LOG_MESSAGE = "Time to execute testcase: ";
    private static final FastScanner sc = new FastScanner(new BufferedReader(new InputStreamReader(System.in)));
    private static final ArrayList<String> list = new ArrayList<>();
    private static final ArrayList<int[]> listSoFar = new ArrayList<>();
    private static PrintWriter out = new PrintWriter(System.out);
    private static TimeLogger tl = new TimeLogger(TESTCASE_TIME_LOG_MESSAGE, TimeUnit.MILLI_SECONDS, out);
    private static int RING_SIZE = 5;
    private static int MAX_NUMS = 2 * RING_SIZE;
    private static int MIN_SUM = MAX_NUMS + 3;
    private static int MAX_SUM = 2 * MAX_NUMS;
    private static int COUNT = 0;
    private static boolean[] numMap = new boolean[MAX_NUMS + 1];

    private static void reset(int ringSize) {
        RING_SIZE = ringSize;
        MAX_NUMS = 2 * RING_SIZE;
        MIN_SUM = MAX_NUMS + 3;
        MAX_SUM = 2 * MAX_NUMS;
        COUNT = 0;
        numMap = new boolean[MAX_NUMS + 1];
        numMap[0] = true;
    }

    public static void main(String[] args) throws Exception {
        Log.enableLogging(out);
        int T = sc.nextInt();
        while (T > 0) {
            int rs = sc.nextInt();
            reset(rs);
            tl.startTracking();
            String res = getResult();
            tl.pauseTracking();
            print(res);
            tl.stopTrackingAndLog();
            T--;
        }
        if (out != null) {
            out.close();
        }
    }

    private static void print(String str) {
        if (out == null) {
            System.out.println(str);
        } else {
            out.println(str);
        }
    }

    private static String getResult() {
        for (int i = MIN_SUM; i <= MAX_SUM; i++) {
            getSum(i);
        }

        Log.logString(COUNT + "");
        /*for(String s: list) {
            Log.logString(s);
        }*/
        return "";
    }

    private static void getSum(int sum) {
        for (int i = 1; i < numMap.length; i++) {
            toggleMap(i);
            ArrayList<int[]> list = getPossibleXYForSum(sum - i);
            for (int[] cur : list) {
                toggleMap(cur);
                add(cur, i);
                figureOutNGonRing(sum);
                removeLast();
                toggleMap(cur);
            }
            toggleMap(i);
        }
    }

    private static void figureOutNGonRing(int sum) {
        if (listSoFar.size() == (RING_SIZE - 1)) {
            int b = getLastLast();
            int c = listSoFar.get(0)[1];
            int a = sum - (b + c);
            if (a > 0 && a < numMap.length && !numMap[a]) {
                add(a, b, c);
                COUNT++;
                //addMinClockWiseString(sum);
                removeLast();
            }
            return;
        }

        int b = getLastLast();

        ArrayList<int[]> cur = getPossibleXYForSum(sum - b);
        for (int[] vals : cur) {
            toggleMap(vals);
            add(vals, b);
            figureOutNGonRing(sum);
            removeLast();
            toggleMap(vals);
        }
    }

    private static void add(int a, int b, int c) {
        listSoFar.add(new int[]{a, b, c});
    }

    private static void add(int[] vals, int b) {
        add(vals[0], b, vals[1]);
    }

    private static void removeLast() {
        listSoFar.remove(listSoFar.size() - 1);
    }

    private static int getLastLast() {
        return listSoFar.get(listSoFar.size() - 1)[2];
    }

    private static void addMinClockWiseString(int sum) {
        StringBuilder sb = new StringBuilder(18);

        int min = 0;

        for (int i = 1; i < listSoFar.size(); i++) {
            if (listSoFar.get(i)[0] < listSoFar.get(min)[0]) {
                min = i;
            }
        }

        int i = min;

        do {
            buildString(sb, listSoFar.get(i));
            i++;
            i %= listSoFar.size();
        } while (i != min);

        String s = sum + " => " + sb.toString();
        if (!list.contains(s)) {
            list.add(s);
        }
    }

    private static void buildString(StringBuilder sb, int[] a) {
        sb.append(a[0]);
        sb.append(',');
        sb.append(a[1]);
        sb.append(',');
        sb.append(a[2]);
        sb.append(';');
        sb.append(' ');
    }


    private static void toggleMap(int i) {
        numMap[i] = !numMap[i];
    }

    private static void toggleMap(int[] vals) {
        for (int i : vals) {
            toggleMap(i);
        }
    }

    private static ArrayList<int[]> getPossibleXYForSum(int sum) {
        ArrayList<int[]> res = new ArrayList<>();

        int i = 1, j = numMap.length - 1;

        while (i < j) {
            int s = i + j;
            if (numMap[i]) {
                i++;
            } else if (numMap[j]) {
                j--;
            } else if (s > sum) {
                j--;
            } else if (s < sum) {
                i++;
            } else {
                res.add(new int[]{i, j});
                res.add(new int[]{j, i});
                i++;
                j--;
            }
        }

        return res;
    }

    //Convert string to integer
    private static int i(String s) {
        return Integer.parseInt(s);
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

        public int nextInt() throws Exception {
            return i(nextToken());
        }
    }
}
