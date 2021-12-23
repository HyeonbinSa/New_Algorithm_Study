package com.benworld.programmers.kakaointernship2021;

import java.util.Arrays;
import java.util.List;

public class Keypad {
    private static final List<Integer> LEFT_NUMBER = Arrays.asList(1, 4, 7, 10);
    private static final List<Integer> RIGHT_NUMBER = Arrays.asList(3, 6, 9, 12);
    private static final List<Integer> CENTER_NUMBER = Arrays.asList(2, 5, 8, 11);
    private static final int LEFT_START = 10;
    private static final int RIGHT_START = 12;
    private static final String LEFT_HAND = "L";
    private static final String RIGHT_HAND = "R";

    public String solution(int[] numbers, String hand) {
        String answer = "";
        int leftHand = LEFT_START;
        int rightHand = RIGHT_START;
        for (int number : numbers) {
            System.out.println(answer);
            if (number == 0) {
                number = 11;
            }
            System.out.println(leftHand +", "+rightHand  +", "+number);
            if (LEFT_NUMBER.contains(number)) {
                leftHand = number;
                answer += LEFT_HAND;
                continue;
            }
            if (RIGHT_NUMBER.contains(number)) {
                rightHand = number;
                answer += RIGHT_HAND;
                continue;
            }
            if (CENTER_NUMBER.contains(number)) {
                String result = selectCenterNumber(leftHand, rightHand, number, hand);
                if (result.equals(LEFT_HAND)) {
                    leftHand = number;
                    answer += result;
                    continue;
                }
                rightHand = number;
                answer += result;
            }
        }
        return answer;
    }

    private String selectCenterNumber(int leftHand, int rightHand, int number, String hand) {
        int leftDistance = 0;
        int rightDistance = 0;
        if (LEFT_NUMBER.contains(leftHand)) {
            leftDistance += 1;
            leftHand += 1;
        }
        if (RIGHT_NUMBER.contains(rightHand)) {
            rightDistance += 1;
            rightHand -= 1;
        }
        leftDistance += Math.abs(number - leftHand) / 3;
        rightDistance += Math.abs(number - rightHand) / 3;
        if (leftDistance == rightDistance) {
            if (hand.equals("right")) {
                return RIGHT_HAND;
            }
            return LEFT_HAND;
        }
        if (leftDistance < rightDistance) {
            return LEFT_HAND;
        }
        return RIGHT_HAND;
    }
}

