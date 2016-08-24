
package com.hackerearth.easy_track;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by deepanshu on 29/12/15.
 */
public class number_of_r {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        while (N > 0) {
            line = br.readLine();
            System.out.println(getCount(line));
            N--;
        }
    }

    public static int getCount(String str) {
        int count = 0;
        char[] charArr = str.toCharArray();
        for (char c : charArr) {
            if (c == 'R') {
                count++;
            }
        }

        int i = 0, j = charArr.length - 1;
        int max = charArr.length - count;
        int residueR = 0;

        while (i <= j) {

            int total = j - i + 1;
            int rInTotal = count - residueR;
            int maxByFlip = total - rInTotal;
            int totalPossible = residueR + maxByFlip;

            if (max < totalPossible) {
                max = totalPossible;
            }

            if (charArr[i] == 'R') {
                i++;
                residueR++;
            } else if (charArr[j] == 'R') {
                j--;
                residueR++;
            } else {
                i++;
                j--;

            }

        }
        return max;
    }

}

