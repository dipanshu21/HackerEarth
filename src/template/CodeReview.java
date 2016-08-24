package template;

import java.util.ArrayList;

class Solution {
    int len;
    ArrayList<Integer> sorted;
    ArrayList<Integer> freq;

    public static void main(String[] a) {
        String[] arr = {
                //"asasdsdsadasdadsadasdsa",
                //"sdsa",
                //"sadsaasd",
                "UGfKcNYgPceReTYpDVLR"
                //,"a"
        };
        for (String s : arr) {
            System.out.println(s + ": \n" + new Solution().findRank(s));
        }
    }

    public int findRank(String a) {
        len = a.length();
        sorted = new ArrayList<Integer>();
        freq = new ArrayList<Integer>();

        int x = 0;
        for (int i = 0; i < len; i++) {
            x = (int) a.charAt(i);
            insert(x);
        }

        long rank = 0;
        int calclen = len;

        for (int i = 0; i < len; i++) {
            x = (int) a.charAt(i);
            for (int j = 0; j < sorted.size(); j++) {
                if (x == sorted.get(j) && freq.get(j) > 0) {
                    long subrank = 0;
                    --calclen;
                    long num = getfactorial(calclen);
                    long deno = 0;
                    for (int k = 0; k < j; k++) {
                        if (freq.get(k) > 0) {
                            deno = getdiv(k);
                            long deno1 = simplify(deno);
                            subrank += num * deno1;
                            if (subrank > 1000003)
                                subrank %= 1000003;
                        }
                    }
                    refreshlists(j);
                    rank += subrank;
                    rank %= 1000003;
                }
            }
        }
        return (int) (rank + 1) % 1000003;
    }

    public long simplify(long num) {
        long pow = num;

        for (int i = 1; i < 1000001; i++) {
            pow *= num;
            if (pow > 1000003)
                pow %= 1000003;
        }
        return (pow % 1000003);
    }

    public void refreshlists(int j) {
        int g = freq.get(j);
        freq.set(j, g - 1);
    }

    public long getdiv(int h) {
        long div = 1;
        for (int s = 0; s < freq.size(); s++) {
            if (freq.get(s) > 0) {
                int f = freq.get(s);
                if (s == h) {
                    div *= getfactorial(f - 1);
                } else {
                    div *= getfactorial(f);
                }
                div %= 1000003;
            }
        }
        return div;
    }

    public void insert(int x) {
        for (int j = 0; j < sorted.size(); j++) {

            if (sorted.get(j) < x) continue;
            if (sorted.get(j) == x) {
                freq.set(j, freq.get(j) + 1);
                return;
            }
            sorted.add(j, x);
            freq.add(j, 1);
            return;

        }
        sorted.add(x);
        freq.add(1);
    }

    public long getfactorial(int num) {
        long fact = 1;
        for (int i = 2; i < num + 1; i++) {
            fact *= i;
            fact = fact > 1000003 ? fact % 1000003 : fact;

        }
        return fact;
    }
}
