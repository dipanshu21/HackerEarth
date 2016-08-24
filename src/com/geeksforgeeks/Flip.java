package com.geeksforgeeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by deepanshu on 31/01/16, 5:31 AM.
 */
class Flip {
    private static final String SPLIT_CHAR = " ";
    private static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = rsi(br);
        while (T > 0) {
            System.out.println(getResult(rmial(br)));
            T--;
        }

    }

    private static String getResult(ArrayList<Integer> a) {
        Collections.sort(a, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });

        int num = 0;
        for (int i = 0; i < a.size() - 1; i++) {
            if (a.get(i) == a.get(i + 1)) {
                num = a.get(i);
                break;
            }
        }

        return num + "";
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

    //Read multiple integer values
    private static ArrayList<Integer> rmial(BufferedReader br) throws IOException {
        String[] arr = br.readLine().split(SPLIT_CHAR);
        ArrayList<Integer> vals = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            vals.add(i(arr[i]));
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
}
