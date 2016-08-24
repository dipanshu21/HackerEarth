package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by deepanshu on 05/01/16, 8:32 AM.
 */
class EggDroppingPuzzle {
    private static final String SPLIT_CHAR = " ";
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = rsi(br);
        while (T > 0) {
            int[] val = rmi(br);
            dp = new int[val[0] + 1][val[1] + 1];
            System.out.println(getResult(1, val[0], val[1]));
            T--;
        }
    }

    private static int getResult(int fromFloor, int toFloor, int e) {
        int f = toFloor - fromFloor;

        if (f < 0) {
            return 0;
        }

        if (f == 0 || f == 1) {
            return f;
        }

        if (e == 1) {
            return f;
        }
        int dpSol = dp[f][e];

        if (dpSol != 0) {
            return dpSol;
        }


        int min = Integer.MAX_VALUE;
        int resultFloor = 0;
        for (int i = fromFloor; i <= toFloor; i++) {
            int broke = getResult(fromFloor, i - 1, e - 1);
            int survived = getResult(i + 1, toFloor, e);
            int individualDropping = Math.max(broke, survived) + 1;
            if (individualDropping < min) {
                min = individualDropping;
                resultFloor = i;
            }
        }

        dp[f][e] = resultFloor;

        return resultFloor;
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
