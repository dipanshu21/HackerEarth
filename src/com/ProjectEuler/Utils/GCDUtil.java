package com.ProjectEuler.Utils;

/**
 * Created by deepanshu on 15/05/16, 6:24 AM.
 */
public class GCDUtil {
    public static int[][] gcdDP;


    public static int gcdNum(int a, int b) {
        int t = Math.min(a, b);
        b = a + b - t;
        a = t;

        //a < b
        while (a != 0) {
            t = b % a;
            b = a;
            a = t;
        }

        return b;
    }

    //generate from 1 to b all combs
    public static void generateGCD(int b) {
        gcdDP = new int[b][b];
        for (int i = 1; i < b; i++) {
            for (int j = 1; j < b; j++) {
                gcdDP[i][j] = gcdNum(i, j);
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 10; i < 20; i++) {
            for (int j = 10; j < 20; j++) {
                System.out.println(i + ", " + j + "\t" + gcdNum(i, j));
            }
        }
    }
}
