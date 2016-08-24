package com.ProjectEuler.ProblemHelpers;

import com.ProjectEuler.Utils.Log;

/**
 * Created by deepanshu on 21/05/16, 5:21 PM.
 */
public class PokerHandComparator {

    private static final String ROYAL_FLUSH = "Royal flush";
    private static final String STRAIGHT_FLUSH = "Straight flush";
    private static final String STRAIGHT_FLUSH_WITH_HIGH = "Straight flush with high card: ";
    private static final String FOUR_OF_A_KIND_WITH_VAL = "Four of a kind with a value: ";
    private static final String FOUR_OF_A_KIND = "Four of a kind";
    private static final String FULL_HOUSE = "Full house";
    private static final String FULL_HOUSE_WITH = "Full house with";
    private static final String FLUSH = "Flush";
    private static final String FLUSH_WITH = "Flush with";
    private static final String STRAIGHT = "Straight";
    private static final String STRAIGHT_WITH = "Straight with";
    private static final String THREE_OF_A_KIND_WITH_HIGH = "Three of a kind with value: ";
    private static final String THREE_OF_A_KIND = "Three of a kind";
    private static final String TWO_PAIR_WITH_HIGH_PAIR = "Two pair with high pair: ";
    private static final String TWO_PAIR_WITH_LOW_PAIR = "Two pair with low pair: ";
    private static final String TWO_PAIR_WITH = "Two pair with";
    private static final String TWO_PAIR = "Two pair";
    private static final String ONE_PAIR_WITH_VAL = "One pair with value: ";
    private static final String ONE_PAIR_WITH = "One pair with";
    private static final String ONE_PAIR = "One pair";
    private static final String HIGH_CARD_WITH_VAL = "High card with value: ";


    //1 for hand1 and 2 for hand2
    public static int getWinner(int[][] hand1, int[][] hand2) {
        int[][] hc1 = getCardCountsSegregated(getCountArr(hand1));
        int[][] hc2 = getCardCountsSegregated(getCountArr(hand2));
        boolean isFlush1 = isFlush(hand1);
        boolean isFlush2 = isFlush(hand2);

        if (isFlush1 && hc1[3][0] == 14) {
            Log.logString(ROYAL_FLUSH);
            return 1;
        } else if (isFlush2 && hc2[3][0] == 14) {
            Log.logString(ROYAL_FLUSH);
            return 2;
        } else {
            boolean isSimpleStraight1 = hc1[3][0] - hc1[3][4] == 4;
            boolean isSpecialStraight1 = hc1[3][0] == 14 && hc1[3][1] - hc1[3][4] == 3 && hc1[3][4] == 2;
            boolean isSimpleStraight2 = hc2[3][0] - hc2[3][4] == 4;
            boolean isSpecialStraight2 = hc2[3][0] == 14 && hc2[3][1] - hc2[3][4] == 3 && hc2[3][4] == 2;

            boolean isStraight1 = isSimpleStraight1 || isSpecialStraight1;
            boolean isStraight2 = isSimpleStraight2 || isSpecialStraight2;

            boolean isStraightFlush1 = isStraight1 && isFlush1;
            boolean isStraightFlush2 = isStraight2 && isFlush2;

            if (isStraightFlush1 && isStraightFlush2) {
                int highCardStraight1 = isSimpleStraight1 ? hc1[3][0] : 1;
                int highCardStraight2 = isSimpleStraight2 ? hc2[3][0] : 1;
                if (highCardStraight1 > highCardStraight2) {
                    Log.logString(STRAIGHT_FLUSH_WITH_HIGH + CardParser.getStr(highCardStraight1));
                    return 1;
                } else {
                    Log.logString(STRAIGHT_FLUSH_WITH_HIGH + CardParser.getStr(highCardStraight2));
                    return 2;
                }
            } else if (isStraightFlush1) {
                Log.logString(STRAIGHT_FLUSH);
                return 1;
            } else if (isStraightFlush2) {
                Log.logString(STRAIGHT_FLUSH);
                return 2;
            } else {
                int fourOfAKindCard1 = hc1[0][0];
                int fourOfAKindCard2 = hc2[0][0];

                boolean isFourOfAKind1 = fourOfAKindCard1 != -1;
                boolean isFourOfAKind2 = fourOfAKindCard2 != -1;

                if (isFourOfAKind1 && isFourOfAKind2) {
                    if (fourOfAKindCard1 > fourOfAKindCard2) {
                        Log.logString(FOUR_OF_A_KIND_WITH_VAL + CardParser.getStr(fourOfAKindCard1));
                        return 1;
                    } else {
                        Log.logString(FOUR_OF_A_KIND_WITH_VAL + CardParser.getStr(fourOfAKindCard2));
                        return 2;
                    }
                } else if (isFourOfAKind1) {
                    Log.logString(FOUR_OF_A_KIND);
                    return 1;
                } else if (isFourOfAKind2) {
                    Log.logString(FOUR_OF_A_KIND);
                    return 2;
                } else {
                    int threeOfAKindCard1 = hc1[1][0];
                    int threeOfAKindCard2 = hc2[1][0];

                    boolean isThreeOfAKind1 = threeOfAKindCard1 != -1;
                    boolean isThreeOfAKind2 = threeOfAKindCard2 != -1;

                    int pairCardLow1 = hc1[2][1];
                    int pairCardLow2 = hc2[2][1];

                    int pairCardHigh1 = hc1[2][0];
                    int pairCardHigh2 = hc2[2][0];

                    boolean isPairLow1 = pairCardLow1 != -1;
                    boolean isPairLow2 = pairCardLow2 != -1;

                    boolean isPairHigh1 = pairCardHigh1 != -1;
                    boolean isPairHigh2 = pairCardHigh2 != -1;

                    boolean isTwoPair1 = isPairLow1 && isPairHigh1;
                    boolean isTwoPair2 = isPairLow2 && isPairHigh2;

                    boolean isFullHouse1 = isThreeOfAKind1 && isPairLow1;
                    boolean isFullHouse2 = isThreeOfAKind2 && isPairLow2;

                    if (isFullHouse1 && isFullHouse2) {
                        Log.logString(FULL_HOUSE_WITH);
                    } else if (isFullHouse1) {
                        Log.logString(FULL_HOUSE);
                        return 1;
                    } else if (isFullHouse2) {
                        Log.logString(FULL_HOUSE);
                        return 2;
                    }

                    if (isFlush1 && isFlush2) {
                        Log.logString(FLUSH_WITH);
                    } else if (isFlush1) {
                        Log.logString(FLUSH);
                        return 1;
                    } else if (isFlush2) {
                        Log.logString(FLUSH);
                        return 2;
                    }

                    if (isStraight1 && isStraight2) {
                        Log.logString(STRAIGHT_WITH);
                    } else if (isStraight1) {
                        Log.logString(STRAIGHT);
                        return 1;
                    } else if (isStraight2) {
                        Log.logString(STRAIGHT);
                        return 2;
                    }

                    if (isThreeOfAKind1 && isThreeOfAKind2) {
                        if (threeOfAKindCard1 > threeOfAKindCard2) {
                            Log.logString(THREE_OF_A_KIND_WITH_HIGH + CardParser.getStr(threeOfAKindCard1));
                            return 1;
                        } else {
                            Log.logString(THREE_OF_A_KIND_WITH_HIGH + CardParser.getStr(threeOfAKindCard2));
                            return 2;
                        }
                    } else if (isThreeOfAKind1) {
                        Log.logString(THREE_OF_A_KIND);
                        return 1;
                    } else if (isThreeOfAKind2) {
                        Log.logString(THREE_OF_A_KIND);
                        return 2;
                    }

                    if (isTwoPair1 && isTwoPair2) {
                        if (pairCardHigh1 > pairCardHigh1) {
                            Log.logString(TWO_PAIR_WITH_HIGH_PAIR + CardParser.getStr(pairCardHigh1));
                            return 1;
                        } else if (pairCardHigh1 < pairCardHigh2) {
                            Log.logString(TWO_PAIR_WITH_HIGH_PAIR + CardParser.getStr(pairCardHigh2));
                            return 2;
                        } else {
                            if (pairCardLow1 > pairCardLow2) {
                                Log.logString(TWO_PAIR_WITH_LOW_PAIR + CardParser.getStr(pairCardLow1));
                                return 1;
                            } else if (pairCardLow1 < pairCardLow2) {
                                Log.logString(TWO_PAIR_WITH_LOW_PAIR + CardParser.getStr(pairCardLow2));
                                return 2;
                            } else {
                                Log.logString(TWO_PAIR_WITH);
                            }
                        }
                    } else if (isTwoPair1) {
                        Log.logString(TWO_PAIR);
                        return 1;
                    } else if (isTwoPair2) {
                        Log.logString(TWO_PAIR);
                        return 2;
                    }

                    if (isPairLow1 && isPairLow2) {
                        if (pairCardLow1 > pairCardLow2) {
                            Log.logString(ONE_PAIR_WITH_VAL + CardParser.getStr(pairCardLow1));
                            return 1;
                        } else if (pairCardLow1 < pairCardLow2) {
                            Log.logString(ONE_PAIR_WITH_VAL + CardParser.getStr(pairCardLow2));
                            return 2;
                        } else {
                            Log.logString(ONE_PAIR_WITH);
                        }
                    } else if (isPairLow1) {
                        Log.logString(ONE_PAIR);
                        return 1;
                    } else if (isPairLow2) {
                        Log.logString(ONE_PAIR);
                        return 2;
                    }

                    for (int i = 0; i < 5; i++) {
                        if (hc1[3][i] > hc2[3][i]) {
                            Log.logString(HIGH_CARD_WITH_VAL + CardParser.getStr(hc1[3][i]));
                            return 1;
                        } else if (hc2[3][i] > hc1[3][i]) {
                            Log.logString(HIGH_CARD_WITH_VAL + CardParser.getStr(hc2[3][i]));
                            return 2;
                        }
                    }
                }
            }
        }

        return -1;
    }

    private static int[] getCountArr(int[][] hand) {
        int[] dp = new int[15];

        for (int i = 0; i < hand.length; i++) {
            dp[hand[i][0]]++;
        }

        return dp;
    }

    private static boolean isFlush(int[][] hand) {
        int s = hand[0][1];

        for (int i = 1; i < hand.length; i++) {
            if (s != hand[i][1]) {
                return false;
            }
        }

        return true;
    }

    private static int[][] getCardCountsSegregated(int[] dp) {
        int[][] res = new int[][]{
                {-1},
                {-1},
                {-1, -1},
                {-1, -1, -1, -1, -1}
        };

        int oneInd = 4;
        int twoInd = 1;
        for (int i = 2; i < dp.length; i++) {
            if (dp[i] == 1) {
                res[3][oneInd] = i;
                oneInd--;
            } else if (dp[i] == 2) {
                res[2][twoInd] = i;
                twoInd--;
            } else if (dp[i] == 3) {
                res[1][0] = i;
            } else if (dp[i] == 4) {
                res[0][0] = i;
            }
        }

        return res;
    }
}
