package template;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by deepanshu on 03/01/16, 3:40 PM.
 */
class LongestContinuousSubSequence {
    private static final String SPLIT_CHAR = " ";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = rsi(br);
        while (T > 0) {
            int[] vals = rmi(br);
            System.out.println(getResult(vals));
            T--;
        }
    }

    private static int getResult(int[] vals) {
        int prevSum = vals[0];
        int len = 1;
        int zeroLen = prevSum == 0 ? 1 : 0;
        for (int i = 1; i < vals.length; i++) {
            int tmp = prevSum + vals[i];
            if (tmp >= prevSum) {
                len++;
                if (tmp == 0 && zeroLen < len) {
                    zeroLen = len;
                }
            } else {
                prevSum = vals[i];
                len = 0;
            }
        }

        return zeroLen;
    }

    //Read multiple integer values
    private static int[] rmi(BufferedReader br) throws IOException {
        String[] arr = br.readLine().split(SPLIT_CHAR);
        int[] vals = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            vals[i] = i(arr[i]);
        }

        return vals;
    }

    //Read single integer value
    private static int rsi(BufferedReader br) throws IOException {
        return rmi(br)[0];
    }

    //Read string values
    private static String[] rv(BufferedReader br) throws IOException {
        return br.readLine().split(SPLIT_CHAR);
    }

    //Convert string to integer
    private static int i(String s) {
        return Integer.parseInt(s);
    }

    //Convert string to long
    private static long l(String s) {
        return Long.parseLong(s);
    }
}
