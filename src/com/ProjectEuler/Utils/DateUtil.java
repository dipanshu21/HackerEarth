package com.ProjectEuler.Utils;

/**
 * Created by deepanshu on 07/05/16, 6:17 PM.
 */
public class DateUtil {
    private static int daysMonths[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};


    public static boolean isLeapYear(int y) {
        if (y % 4 == 0) {
            if (y % 100 == 0) {
                if (y % 400 == 0) {
                    return true;
                }
            } else {
                return true;
            }
        }
        return false;
    }

    public static int dayInMonthYear(int m, int y) {
        int d = daysMonths[m - 1];

        if (m == 2 && isLeapYear(y)) {
            d++;
        }

        return d;
    }
}
