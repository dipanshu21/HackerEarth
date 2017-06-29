package com.ProjectEuler.Prob_51_75;

import com.ProjectEuler.Utils.Log;
import com.ProjectEuler.Utils.TimeLogger;
import com.ProjectEuler.Utils.TimeUnit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by deepanshu on 12/11/16, 12:20.
 */
class $079_PasscodeDerivation {
    private static final String SPLIT_CHAR = " ";
    private static final int MOD = 1000000007;
    private static final String FILE_NAME = "p079_keylog.txt";
    private static final String TESTCASE_TIME_LOG_MESSAGE = "Time to execute testcase: ";
    private static final String INPUT_TIME_LOG_MESSAGE = "Time to take input: ";
    private static final FastScanner sc = new FastScanner(new BufferedReader(new InputStreamReader(System.in)));
    private static FastScanner fsc = null;
    private static PrintWriter out = new PrintWriter(System.out);
    private static TimeLogger tl = new TimeLogger(TESTCASE_TIME_LOG_MESSAGE, TimeUnit.SECONDS, out);

    public static void main(String[] args) throws Exception {
        initFileScanner();
        Log.enableLogging();
        int T = sc.nextInt();
        while (T > 0) {
            //int in = rsi(br);
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

    private static void initFileScanner() throws Exception {
        fsc = new FastScanner(new BufferedReader(new FileReader(FILE_NAME)));
    }

    private static String getResult() {
        String codeString = "";
        ArrayList<String> codeList = new ArrayList<>(50);
        ArrayList<String> incrementalCodeList = new ArrayList<>(50);

        try {
            while (true) {
                String currentCode = fsc.next();
                codeList.add(currentCode);
                char[] currentChars = currentCode.toCharArray();
                int indexA = codeString.indexOf(currentChars[0]),
                        indexB = codeString.indexOf(currentChars[1]),
                        indexC = codeString.indexOf(currentChars[2]);


                if (indexA == -1) {
                    codeString += currentChars[0];
                    indexA = codeString.length() - 1;
                }

                if (indexB == -1) {
                    codeString += currentChars[1];
                    indexB = codeString.length() - 1;
                }

                if (indexC == -1) {
                    codeString += currentChars[2];
                    indexC = codeString.length() - 1;
                }

                if (indexC < indexB || indexC < indexA) {
                    codeString = moveChar(codeString, indexC, Math.max(indexA, indexB));
                    indexA = codeString.indexOf(currentChars[0]);
                    indexB = codeString.indexOf(currentChars[1]);
                }

                if (indexB < indexA) {
                    codeString = moveChar(codeString, indexB, indexA);
                }
                incrementalCodeList.add(codeString);
            }
        } catch (Exception e) {
        }

        for (String code : codeList) {
            int indexA = codeString.indexOf(code.charAt(0)),
                    indexB = codeString.indexOf(code.charAt(1)),
                    indexC = codeString.indexOf(code.charAt(2));

            if (!(indexA < indexB && indexB < indexC)) {
                print("Not correct");
            }
        }

        return codeString + "";
    }

    private static String moveChar(String s, int originalIndex, int newIndex) {
        char[] chars = s.toCharArray();
        char charToShift = chars[originalIndex];

        if (originalIndex < newIndex) {
            shiftChars(chars, originalIndex + 1, newIndex, -1);
        } else if (originalIndex > newIndex) {
            shiftChars(chars, newIndex, originalIndex - 1, 1);
        }

        chars[newIndex] = charToShift;

        return new String(chars);
    }

    private static void shiftChars(char[] chars, int begIndex, int endIndex, int shiftBy) {
        if (shiftBy > 0) {
            while (endIndex >= begIndex) {
                chars[endIndex + shiftBy] = chars[endIndex];
                endIndex--;
            }
        } else if (shiftBy < 0) {
            while (begIndex <= endIndex) {
                chars[begIndex + shiftBy] = chars[begIndex];
                begIndex++;
            }
        }
    }

    private static long factorial(int num) {
        long res = 1;

        for (int i = 2; i <= num; i++) {
            res = (res * i) % MOD;
        }

        return res;
    }

    private static long findModuloInverse(long n, long m) {
        return fast_pow(n, m - 2, m);
    }

    private static long fast_pow(long base, long n, long M) {
        if (n == 0)
            return 1;
        if (n == 1)
            return base;
        long halfn = fast_pow(base, n / 2, M);
        if (n % 2 == 0)
            return (halfn * halfn) % M;
        else
            return (((halfn * halfn) % M) * base) % M;
    }

    //Assumes str arr contains numbers
    private static int[] strToIntArr(String[] arr) {
        int[] intArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            intArr[i] = i(arr[i]);
        }

        return intArr;
    }

    //Convert string to integer
    private static int i(String s) {
        return Integer.parseInt(s);
    }

    //Convert string to long
    private static long l(String s) {
        return Long.parseLong(s);
    }

    //Convert string to double
    private static double d(String s) {
        return Double.parseDouble(s);
    }

    //fil array
    private static <T> void filArr(T[] a, T v) {
        for (int i = 0; i < a.length; i++) {
            a[i] = v;
        }
    }

    //printArrayList
    private static <T> void parli(ArrayList<T> list) {
        for (T a : list) {
            out.println(a.toString());
        }
    }

    //print array
    private static <T> void par(T[] arr) {
        for (T a : arr) {
            out.println(a.toString());
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

        public String next() throws Exception {
            return nextToken();
        }

        public int nextInt() throws Exception {
            return i(nextToken());
        }

        public long nextLong() throws Exception {
            return l(nextToken());
        }

        public double nextDouble() throws Exception {
            return d(nextToken());
        }

        public int[] nextInt(int n) throws Exception {
            int[] res = new int[n];

            for (int i = 0; i < n; i++) {
                res[i] = nextInt();
            }

            return res;
        }

        public long[] nextLong(int n) throws Exception {
            long[] res = new long[n];

            for (int i = 0; i < n; i++) {
                res[i] = nextLong();
            }

            return res;
        }

        public double[] nextDouble(int n) throws Exception {
            double[] res = new double[n];

            for (int i = 0; i < n; i++) {
                res[i] = nextDouble();
            }

            return res;
        }

        public String[] next(int n) throws Exception {
            String[] res = new String[n];

            for (int i = 0; i < n; i++) {
                res[i] = next();
            }

            return res;
        }
    }
}