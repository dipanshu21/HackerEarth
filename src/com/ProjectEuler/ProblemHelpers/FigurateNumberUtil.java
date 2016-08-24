package com.ProjectEuler.ProblemHelpers;

/**
 * Created by deepanshu on 12/06/16, 9:49 AM.
 */
public class FigurateNumberUtil {

    public int getTriangleNumber(int n) {
        return (n * (n + 1)) / 2;
    }

    public int getSquareNumber(int n) {
        return n * n;
    }

    public int getPentagonalNumber(int n) {
        return (n * (3 * n - 1)) / 2;
    }

    public int getHexagonalNumber(int n) {
        return n * (2 * n - 1);
    }

    public int getHeptagonalNumber(int n) {
        return (n * (5 * n - 3)) / 2;
    }

    public int getOctagonalNumber(int n) {
        return n * (3 * n - 2);
    }
}
