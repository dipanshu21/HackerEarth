package com.hackerearth.TCS_CodeVita_1;

import java.util.Scanner;

class Problem_1 {
    private static final String SALLY = "Sally";
    private static final String Darrell = "Darrell";
    private static final String SPLIT_CHAR = " ";

    public static void main(String[] args) {

        Scanner br = new Scanner(System.in);
        int N = i(br.nextLine());
        if (N % 2 != 0 || N <= 0 || N > 10) {
            invalidate();
            return;
        }

        int sallyPts = 0, darrellPts = 0;
        String firstPlayer = null;
        String secondPlayer = null;
        String lastPlayer = null;
        while (N > 0) {
            String ques = br.nextLine();
            String q_player = "";
            String q_str = "";
            String a_player = "";
            String a_str = "";
            int ans = 0;
            if (!ques.equals("")) {
                String[] qParts = ques.split(SPLIT_CHAR);
                if (qParts.length == 2 && isName(qParts[0])) {
                    q_player = qParts[0];
                    q_str = qParts[1];
                    String[] numbers = qParts[1].split(",");
                    if (numbers.length < 2 || numbers.length > 7) {
                        invalidate();
                        return;
                    } else {
                        ans = lcm(numbers);
                    }
                } else {
                    invalidate();
                    return;
                }
            } else {
                invalidate();
                return;
            }

            String answer = br.nextLine();

            if (!answer.equals("")) {
                String[] aParts = answer.split(SPLIT_CHAR);
                if (aParts.length == 3 && aParts[0].equals("A") && isName(aParts[1])) {
                    a_player = aParts[1];
                    a_str = aParts[2];
                } else {
                    invalidate();
                    return;
                }
            }

            if (a_player.equals(q_player)) {
                invalidate();
                return;
            }

            printQStr(q_player, q_str);
            boolean isAnsCorrect = printAStr(a_player, a_str, ans);
            int ptsToBeAdded = isAnsCorrect ? 10 : 0;

            if (a_player.equals(SALLY)) {
                sallyPts += ptsToBeAdded;
            } else {
                darrellPts += ptsToBeAdded;
            }

            if (firstPlayer == null) {
                firstPlayer = q_player;
                secondPlayer = a_player;
                lastPlayer = q_player;
            } else if (lastPlayer.equals(q_player)) {
                invalidate();
                return;
            } else {
                lastPlayer = q_player;
            }

            N -= 2;
        }

        System.out.println("Total Points:");

        if (firstPlayer.equals(SALLY)) {
            System.out.println(SALLY + ": " + sallyPts + "points");
            System.out.println(Darrell + ": " + darrellPts + "points");
        } else {
            System.out.println(Darrell + ": " + darrellPts + "points");
            System.out.println(SALLY + ": " + sallyPts + "points");
        }
        System.out.print("Game Result: ");
        if (sallyPts > darrellPts) {
            System.out.println(SALLY + " is winner");
        } else if (darrellPts > sallyPts) {
            System.out.println(Darrell + " is winner");
        } else {
            System.out.println("Draw");
        }

    }

    private static void printQStr(String player, String qStr) {
        System.out.println(player + "'s question is: " + qStr);
    }

    private static boolean printAStr(String player, String aStr, int actualAns) {
        if (aStr.equals("PASS")) {
            System.out.println("Question is PASSed");
            System.out.println("Answer is: " + actualAns);
            System.out.println(player + ": 0points");
            return false;
        } else {
            int a = i(aStr);
            if (a == actualAns) {
                System.out.println("Correct Answer");
                System.out.println(player + ": 10points");
                return true;
            } else {
                System.out.println("Wrong Answer");
                System.out.println(player + ": 0points");
                return false;
            }
        }
    }

    private static void invalidate() {
        System.out.println("Invalid Input");
    }

    private static boolean isName(String s) {
        return s.equals(SALLY) || s.equals(Darrell);
    }

    private static int lcm(String[] numbers) {
        int lcm = lcm(i(numbers[0]), i(numbers[1]));

        for (int i = 2; i < numbers.length; i++) {
            lcm = lcm(lcm, i(numbers[i]));
        }

        return lcm;
    }

    private static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    private static int gcd(int a, int b) {
        int t = Math.min(a, b);
        b = a + b - t;
        a = t;

        //a < b
        while (a != 0) {
            t = b % a;
            b = a;
            a = t;
        }

        return b;
    }

    //Convert string to integer
    private static int i(String s) {
        return Integer.parseInt(s.trim());
    }
}
