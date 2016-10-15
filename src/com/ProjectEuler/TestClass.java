package com.ProjectEuler;

import com.ProjectEuler.Prob_51_75.$069_070_TotientMaximum;
import com.ProjectEuler.Utils.GCDUtil;

/**
 * Created by deepanshu on 09/10/16, 14:48.
 */
class TestClass {
    public static void main(String[] args) {
        $069_070_TotientMaximum.getResult();

        int[] n = {3, 351, 1053};

        for (int i = 0; i < n.length; i++) {
            int actual = calBF(n[i]);
            if (actual == $069_070_TotientMaximum.dp[n[i]]) {
                System.out.println("Passed for " + n[i] + " ans: " + actual);
            } else {
                System.out.println("Failed for " + n[i] + " calc: " + $069_070_TotientMaximum.dp[n[i]] + " actual: " + actual);
            }
        }
    }

    public static int calBF(int n) {
        int c = 0;
        for (int i = 1; i < n; i++) {
            if (GCDUtil.gcdNum(i, n) == 1) {
                c++;
            }
        }

        return c;
    }
}
