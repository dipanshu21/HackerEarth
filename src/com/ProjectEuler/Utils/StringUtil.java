package com.ProjectEuler.Utils;

/**
 * Created by deepanshu on 22/05/16, 4:49 PM.
 */
public class StringUtil {
    public static String reverseString(String str) {
        StringBuilder sb = new StringBuilder(str.length());

        for (int i = str.length() - 1; i > -1; i--) {
            sb.append(str.charAt(i));
        }

        return sb.toString();
    }
}
