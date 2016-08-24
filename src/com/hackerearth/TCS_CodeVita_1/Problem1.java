package com.hackerearth.TCS_CodeVita_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Problem1 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = rsi(br);
            getResult(N);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void getResult(int n) {
        int total = 2 * n + 1;

        for (int i = 1; i <= total; i++) {
            for (int j = 1; j <= total; j++) {
                boolean isIOdd = i % 2 != 0;
                boolean isJOdd = j % 2 != 0;
                boolean isStar = false;
                if (i == 1 || j == 1 || i == total || j == total) {
                    isStar = true;
                } else if ((isIOdd && j <= i) || (isJOdd && i <= j)) {
                    isStar = true;
                }

                if (isStar) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

    }

    //Read single integer value
    private static int rsi(BufferedReader br) throws IOException {
        return i(br.readLine());
    }

    //Convert string to integer
    private static int i(String s) {
        return Integer.parseInt(s);
    }
}
