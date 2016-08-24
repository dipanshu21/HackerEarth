package com.ProjectEuler.Utils;

/**
 * Created by deepanshu on 21/08/16, 1:10 PM.
 */
public class MathUtil {
    public static long[] getSquares(int num) {
        long[] squares = new long[num + 1];

        for (int i = 0; i < num; i++) {
            squares[i] = i * i;
        }

        return squares;
    }
}
