package com.hackerearth.easy_track;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class prom_night {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        while (N > 0) {
            br.readLine();
            line = br.readLine();
            String[] temp = line.split(" ");
            int[] boys = new int[201];

            for (String s : temp) {
                boys[Integer.parseInt(s)]++;
            }

            line = br.readLine();
            temp = line.split(" ");

            int[] girls = new int[201];

            for (String s : temp) {
                girls[Integer.parseInt(s)]++;
            }
            System.out.println(getResult(boys, girls));
            N--;
        }
    }

    private static String getResult(int[] b, int[] g) {
        String result = "YES";

        for (int i = b.length - 1; i > -1; i--) {
            int boysToCover = b[i];
            if (boysToCover > 0) {
                for (int j = i - 1; j > -1; j--) {
                    int diff = g[j] - boysToCover;
                    if (diff < 0) {
                        boysToCover -= g[j];
                        g[j] = 0;
                    } else {
                        boysToCover = 0;
                        g[j] = diff;
                        break;
                    }
                }

                if (boysToCover != 0) {
                    return "NO";
                }
            }
        }

        return result;
    }
}