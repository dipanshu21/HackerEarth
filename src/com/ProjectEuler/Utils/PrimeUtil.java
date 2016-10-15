package com.ProjectEuler.Utils;

import java.util.ArrayList;

/**
 * Created by deepanshu on 30/04/16, 8:05 AM.
 */
public class PrimeUtil {
    public static ArrayList<Long> primes = new ArrayList<>(1000);

    public static long getNextPrime() {
        if (primes.isEmpty()) {
            primes.add(2l);
            return 2;
        } else {
            long i = primes.get(primes.size() - 1) + 1;
            boolean isPrimeFound = false;

            while (!isPrimeFound) {
                int j = 0;
                long curNum = primes.get(j);
                final int sqr = (int) Math.sqrt(i);

                boolean isDivided = false;
                while (curNum <= sqr && j < primes.size()) {
                    if (i % curNum == 0) {
                        isDivided = true;
                        break;
                    }
                    j++;
                    curNum = primes.get(j);
                }

                if (!isDivided) {
                    isPrimeFound = true;
                } else {
                    i++;
                }

            }

            primes.add(i);
            return i;
        }
    }

    public static boolean isPrime(long number) {
        long sqrt = (long) Math.sqrt(number) + 1;

        int i = 0;

        while (i < primes.size() && primes.get(i) < sqrt) {
            if (number % primes.get(i) == 0) {
                return false;
            }
            i++;
        }

        if (i != primes.size()) {
            return true;
        }

        long next = getNextPrime();
        while (number % next != 0 && next < sqrt) {
            next = getNextPrime();
        }

        return next >= sqrt;
    }

    public static void clear() {
        primes.clear();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10001; i++) {
            System.out.println(PrimeUtil.getNextPrime());
        }
    }

    public static void generatePrimesUptoN(long n) {
        primes.clear();
        long i = getNextPrime();
        while (i < n) {
            i = getNextPrime();
        }
    }

    /**
     * Generates primes upto n and stores individual primes in primes arraylist also returns a boolean array
     * containing false at the index of the number which is prime.
     *
     * @param n
     * @return
     */
    public static boolean[] generatePrimesUptoNSieve(int n) {
        primes.clear();
        primes = new ArrayList<>(n / 1000);
        boolean[] sieve = new boolean[n];
        sieve[0] = sieve[1] = true;
        for (int i = 2; i < sieve.length; i++) {
            if (!sieve[i]) {
                primes.add((long) i);

                int j = 2;
                while (j * i < sieve.length) {
                    sieve[j * i] = true;
                    j++;
                }
            }
        }

        return sieve;
    }

    /**
     * Generates primes upto n and returns a boolean array
     * containing false at the index of the number which is prime.
     * @param n
     * @return
     */
    public static boolean[] generatePrimesUptoNSieveReturnDP(int n) {
        boolean[] sieve = new boolean[n];
        sieve[1] = true;
        for (int i = 2; i < sieve.length; i++) {
            if (!sieve[i]) {


                int j = 2;
                while (j * i < sieve.length) {
                    sieve[j * i] = true;
                    j++;
                }
            }
        }

        return sieve;
    }
}
