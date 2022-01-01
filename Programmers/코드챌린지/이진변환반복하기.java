package com.benworld.programmers.codechallenge;

public class RecursiveChangeBinary {
    private static final String ZERO = "0";
    private static final String NULL_SPACE = "";
    private static final String LAST_ONE = "1";
    private static int zeroCount = 0;
    private static int repeatCount = 0;

    public int[] solution(String s) {
        int[] answer = new int[2];
        while (true) {
            if (s.equals(LAST_ONE)) {
                break;
            }
            // 1. 이진 문자열에서 0을 제거 -> 반환값은 0이 제거된 문자열의 길이
            int sizeAfterRemoveZero = removeZero(s);
            // 2. 1번의 반환값의 이진값으로 변환
            s = changeBinary(sizeAfterRemoveZero);
        }
        answer[0] = repeatCount;
        answer[1] = zeroCount;
        return answer;
    }

    // 1. 이진 문자열에서 0을 제거 -> 반환값은 0이 제거된 문자열의 길이
    private int removeZero(String string) {
        int originalSize = string.length();
        string = string.replaceAll(ZERO, NULL_SPACE);
        int removeZeroSize = string.length();
        repeatCount++;
        zeroCount += originalSize - removeZeroSize;
        return removeZeroSize;
    }

    // 2. 1번의 반환값의 이진값으로 변환
    private String changeBinary(int number) {
        String binary = "";
        while (number >= 1) {
            binary += number % 2;
            number /= 2;
        }
        binary = new StringBuilder(binary).reverse().toString();
        System.out.println(binary);
        return binary;
    }
}
