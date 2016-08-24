package com.hackerearth.easy_track;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * Created by deepanshu on 30/12/15.
 */
class LittleAashish {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        HashSet<Long> prices = new HashSet<>(13000);
        while (N > 0) {
            line = br.readLine();
            String[] temp = line.split(" ");

            int desiredNumber = Integer.parseInt(temp[1]);

            line = br.readLine();
            temp = line.split(" ");

            prices.clear();

            for (String s : temp) {
                prices.add(Long.parseLong(s));
            }
            String output = "";

            if (prices.size() == desiredNumber) {
                output = "Perfect husband";
            } else if (prices.size() > desiredNumber) {
                output = "Lame husband";
            } else {
                output = "Bad husband";
            }

            System.out.println(output);
            N--;
        }
    }
}
