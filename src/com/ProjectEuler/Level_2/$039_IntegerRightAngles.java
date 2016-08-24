package com.ProjectEuler.Level_2;

import com.ProjectEuler.Utils.GCDUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by deepanshu on 17/05/16, 6:55 AM.
 */
class $039_IntegerRightAngles {
    private static final String SPLIT_CHAR = " ";
    private static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = rsi(br);
        while (T > 0) {
            double curMills = System.currentTimeMillis();

            System.out.println(getResult());

            double nowMills = System.currentTimeMillis();
            System.out.println("Time to execute test case: " + (nowMills - curMills) / 1000 + " seconds");
            T--;
        }
    }

    private static String getResult() {
        int max = 0;
        int maxI = 0;

        for (int i = 1; i <= 1000; i++) {
            int num = numberOfRightAngleTriplets(i);
            if (num > 0) {
                //System.out.println("\nTriplets for " + i + "\n=====================\n");
            }
            if (num > max) {
                max = num;
                maxI = i;
            }
        }

        return maxI + "";
    }

    private static int numberOfRightAngleTriplets(int s) {
        int count = 0;

        int s2 = s >> 1;
        int mlimit = (int) Math.ceil(Math.sqrt(s2)) - 1;
        for (int m = 2; m <= mlimit; m++) {
            if (s2 % m == 0) {
                int sm = s2 / m;
                while ((sm & 1) == 0) {
                    sm >>= 1;
                }

                int k = m + 1 + (m & 1);
                while (k < 2 * m && k <= sm) {
                    if (sm % k == 0 && GCDUtil.gcdNum(k, m) == 1) {
//                        int d = s2 / (k * m);
//                        int n = k - m;
//                        int a = d * (m * m - n * n);
//                        int b = 2 * d * m * n;
//                        int c = d * (m * m + n * n);
//                        System.out.printf("%3d %3d %3d\n", a, b, c);
                        count++;
                    }
                    k += 2;
                }
            }
        }

        return count;
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
