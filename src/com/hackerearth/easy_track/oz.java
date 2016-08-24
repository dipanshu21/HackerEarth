package com.hackerearth.easy_track;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by deepanshu on 29/12/15.
 */
public class oz {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        while (N > 0) {
            line = br.readLine();
            System.out.println(getResult(line));
            N--;
        }
    }

    public static int getResult(String oz) {
        int last = oz.length() - 1;
        int swaps = 0;
        int max;
        for (int i = last; i > -1; i--) {
            char ch = oz.charAt(i);
            if (ch == 'Z') {
                swaps += (last - i);
                last--;
            }
        }
        max = swaps;
        swaps = 0;
        last = oz.length() - 1;
        for (int i = last; i > -1; i--) {
            char ch = oz.charAt(i);
            if (ch == 'O') {
                swaps += (last - i);
                last--;
            }
        }

        return Math.min(max, swaps);
    }
}