package com.hackerearth.easy_track;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by deepanshu on 29/12/15.
 */
public class ICPC_team_management {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        while (N > 0) {
            line = br.readLine();
            String[] temp = line.split(" ");
            int t = Integer.parseInt(temp[0]);
            int groupLim = Integer.parseInt(temp[1]);
            int groups[] = new int[101];

            for (int i = 0; i < t; i++) {
                int len = br.readLine().length();
                groups[len]++;
            }

            System.out.println(getResult(groups, groupLim));
            N--;
        }
    }

    public static String getResult(int[] lens, int c) {

        for (int i : lens) {
            if (i != 0 && i != c) {
                return "Not Possible";
            }
        }

        return "Possible";
    }

}

