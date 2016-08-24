package com.hackerearth.easy_track;

/**
 * Created by deepanshu on 01/11/15.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class dhoom4 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] temp;
        final String saperator = " ";
        temp = line.split(saperator);
        int myKey = Integer.parseInt(temp[0]);
        int desiredKey = Integer.parseInt(temp[1]);
        final int MOD = 100000;
        int N = Integer.parseInt(br.readLine());
        line = br.readLine();
        temp = line.split(saperator);
        int[] availableKeys = new int[N];

        for (int i = 0; i < N; i++) {
            availableKeys[i] = Integer.parseInt(temp[i]);
        }

        int[] graph = new int[MOD];

        ArrayList<Integer> list = new ArrayList<>(N);
        boolean isOver = false;

        for (int i : availableKeys) {
            int res = (int) (((long) myKey * (long) i) % MOD);
            graph[res] = 1;
            if (res == desiredKey) {
                System.out.println(1);
                isOver = true;
                break;
            }
            list.add(res);
        }

        while (!isOver) {
            ArrayList<Integer> tempList = new ArrayList<>(list.size());
            boolean anyResult = false;
            for (int i : list) {
                if (isOver) {
                    break;
                } else {
                    for (int j : availableKeys) {
                        if (isOver) {
                            break;
                        } else {
                            int res = (int) (((long) i * (long) j) % MOD);
                            if (graph[res] == 0) {
                                anyResult = true;
                                graph[res] = graph[i] + 1;
                                tempList.add(res);
                                if (res == desiredKey) {
                                    System.out.println(graph[res]);
                                    isOver = true;
                                }
                            }
                        }
                    }
                }
            }
            list = tempList;
            if (!anyResult) {
                System.out.println(-1);
                break;
            }
        }
    }
}