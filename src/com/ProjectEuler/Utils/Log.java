package com.ProjectEuler.Utils;

import java.io.PrintWriter;

/**
 * Created by deepanshu on 22/05/16, 9:48 AM.
 */
public class Log {
    private static boolean isLoggingEnabled = false;
    private static String SEPARATOR = " ";
    private static PrintWriter out = null;

    public static void setSeparator(String separator) {
        SEPARATOR = separator;
    }

    public static void enableLogging() {
        isLoggingEnabled = true;
    }

    public static void enableLogging(PrintWriter out) {
        enableLogging();
        Log.out = out;
    }

    public static void disableLogging() {
        isLoggingEnabled = false;
    }

    public static void logString(String log) {
        if (isLoggingEnabled) {
            print(log);
        }
    }

    private static void print(String str) {
        if (out == null) {
            System.out.println(str);
        } else {
            out.println(str);
        }
    }

    public static <T> void logString(String log, T... args) {
        if (isLoggingEnabled) {
            StringBuilder toLog = new StringBuilder();
            toLog.append(toLog);
            for (T i : args) {
                toLog.append(SEPARATOR + i);
            }
            System.out.println(toLog.toString());
        }
    }
}
