package com.ProjectEuler.Utils;

import java.util.ArrayList;

/**
 * Created by deepanshu on 30/04/16, 8:28 AM.
 */
public class NumberUtil {

    public static boolean isPalindrome(long num) {
        long c = num;
        long r = 0;
        while (num != 0) {
            r = (r * 10) + (num % 10);
            num /= 10;
        }

        return c == r;
    }

    public static boolean isPalindrome(int num) {
        return isPalindrome((long) num);
    }

    public static int getNumOfDivisors(int n, ArrayList<Long> primes) {
        int lim = (int) Math.sqrt(n);

        int divisor = 1;

        for (int i = 0; i < primes.size(); i++) {
            int c = 0;
            long curPrime = primes.get(i);
            if (curPrime < lim) {
                while (n % curPrime == 0) {
                    n /= curPrime;
                    c++;
                }
                divisor *= c + 1;
                if (n == 1) {
                    break;
                }
            } else {
                break;
            }
        }

        return divisor;
    }

    public static int getSumOfDivisors(int n) {
        int lim = (int) Math.sqrt(n);

        int sum = 1 + (n % lim == 0 ? (lim * lim == n ? lim : lim + n / lim) : 0);

        for (int i = 2; i < lim; i++) {
            if (n % i == 0) {
                sum += i + n / i;
            }
        }

        return sum;
    }

    public static int getSumOfDivisorsUsingPrimeFactorisation(int n, ArrayList<Long> primes) {
        int lim = (int) Math.sqrt(n);
        int divisor = 1;

        for (int i = 0; i < primes.size(); i++) {
            int c = 0;
            long curPrime = primes.get(i);
            long curPrimePow = 1;
            if (curPrime <= lim) {
                while (n % curPrime == 0) {
                    n /= curPrime;
                    curPrimePow *= curPrime;
                    c++;
                }

                if (c != 0) {
                    curPrimePow *= curPrime;
                    divisor *= (curPrimePow - 1) / (curPrime - 1);
                }

                if (n == 1) {
                    break;
                }
            } else {
                break;
            }
        }

        return divisor;
    }

    public static ArrayList<int[]> getPrimeFactorisation(int n, ArrayList<Long> primes) {
        ArrayList<int[]> factors = new ArrayList<>();
        int lim = (int) Math.sqrt(n);
        for (int i = 0; i < primes.size(); i++) {
            int c = 0;
            long curPrime = primes.get(i);
            if (curPrime <= n) {
                while (n % curPrime == 0) {
                    n /= curPrime;
                    c++;
                }

                if (c != 0) {
                    factors.add(new int[]{(int) curPrime, c});
                }

                if (n == 1) {
                    break;
                }
            } else {
                break;
            }
        }

        return factors;
    }

    //assumes num of digit is always greater than 2
    public static boolean[] generateAllPalindromesUptoDidigt(int numOfDigit) {
        ArrayList<Integer>[] palins = new ArrayList[numOfDigit];
        palins[0] = new ArrayList<>(10);
        palins[1] = new ArrayList<>(10);

        boolean[] palinDP = new boolean[(int) Math.pow(10, numOfDigit)];

        for (int k = 0; k < 10; k++) {
            int t = 10 * k + k;
            palins[0].add(k);
            palins[1].add(t);
            palinDP[k] = true;
            palinDP[t] = true;
        }

        int fact = 100;
        for (int i = 2; i < numOfDigit; i++) {
            int prevInd = i - 2;
            palins[i] = new ArrayList<>(palins[prevInd].size() * 12);

            int tempFact = 10;
            while (prevInd >= 0) {
                int k = 1;
                while (k < 10) {
                    int fixedSum = k * fact + k;
                    for (int l = 0; l < palins[prevInd].size(); l++) {
                        int t = fixedSum + (palins[prevInd].get(l) * tempFact);
                        palins[i].add(t);
                        palinDP[t] = true;
                    }
                    k++;
                }
                prevInd -= 2;
                tempFact *= 10;
            }
            fact *= 10;
        }

        return palinDP;
    }

    public static boolean isPalindrome(int n, int base) {
        int rev = 0;
        int k = n;

        while (k > 0) {
            rev = rev * 10 + k % base;
            k /= base;
        }

        return n == rev;
    }

    public static int makePalinDrome(int n, int base, boolean isOddLength) {
        if (base == 2) return makePalinDromBase2(n, isOddLength);
        int res = n;
        if (isOddLength) n /= base;

        while (n > 0) {
            res = base * res + n % base;
            n /= base;
        }

        return res;
    }

    public static int makePalinDromBase2(int n, boolean isOddLength) {
        int res = n;
        if (isOddLength) n >>= 1;

        while (n > 0) {
            res = 2 * res + (n & 1);
            n >>= 1;
        }

        return res;
    }

    public static boolean is1to9Pandigital(String num) {
        boolean[] isPan = new boolean[10];
        isPan[0] = true;
        if (num.length() != 9) return false;

        for (char c : num.toCharArray()) {
            int ind = c - '0';
            if (!isPan[ind]) {
                isPan[ind] = true;
            } else {
                return false;
            }
        }

        return true;
    }

    public static boolean isPandigital(int num) {
        boolean[] isPan = new boolean[10];
        isPan[0] = true;

        int c = 0;

        while (num != 0) {
            c++;
            int ind = num % 10;
            if (!isPan[ind]) {
                isPan[ind] = true;
            } else {
                return false;
            }
            num /= 10;
        }

        boolean res = true;

        for (int i = 1; i <= c && res; i++) {
            res &= isPan[i];
        }
        return res;
    }

    public static long[] getListOfSquares(int n) {
        long[] sqr = new long[n];

        for (int i = 1; i < n; i++) {
            sqr[i] = 2l * i * i;
        }

        return sqr;
    }

    public static boolean isSquare(long n) {
        long m;

        // start with mod 128 rejection. 82% rejection rate
        // VERY fast, can read bits directly
        m = n & 127; // n mod 128
        if (((m * 0x8bc40d7d) & (m * 0xa1e2f5d1) & 0x14020a) > 0) return false;


        //Other modulii share one BigInt modulus.
        long largeMod = n % (63L * 25 * 11 * 17 * 19 * 23 * 31); // SLOW, bigint modulus

        // residues mod 63. 75% rejection
        m = largeMod % 63; // fast, all 32-bit math
        if (((m * 0x3d491df7) & (m * 0xc824a9f9) & 0x10f14008) > 0) return false;

        // residues mod 25. 56% rejection
        m = largeMod % 25;
        if (((m * 0x1929fc1b) & (m * 0x4c9ea3b2) & 0x51001005) > 0) return false;

        // residues mod 31. 48.4% rejection
        //  Bloom filter has a little different form to keep it perfect
        m = 0xd10d829a * (largeMod % 31);
        if ((m & (m + 0x672a5354) & 0x21025115) > 0) return false;


        // residues mod 23. 47.8% rejection
        m = largeMod % 23;
        if (((m * 0x7bd28629) & (m * 0xe7180889) & 0xf8300) > 0) return false;

        // residues mod 19. 47.3% rejection
        m = largeMod % 19;
        if (((m * 0x1b8bead3) & (m * 0x4d75a124) & 0x4280082b) > 0) return false;

        // residues mod 17. 47.1% rejection
        m = largeMod % 17;
        if (((m * 0x6736f323) & (m * 0x9b1d499) & 0xc0000300) > 0) return false;

        // residues mod 11. 45.5% rejection
        m = largeMod % 11;
        if (((m * 0xabf1a3a7) & (m * 0x2612bf93) & 0x45854000) > 0) return false;


        // Net nonsquare rejection rate: 99.92%
        // We COULD extend to another round, doing another BigInt modulus and
        // then followup rejections here, using
        // primes of  13 29 37 41 43 53.  That'd give 98% further rejection.
        // Empirical timing shows this second round would be useful for n>10^100 or so.

        double a = Math.sqrt(n);

        return (a * a) == n;
    }

}
