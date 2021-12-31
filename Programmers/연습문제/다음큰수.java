package com.benworld.programmers.practice;

public class NextBigNumber {
    public int solution(int n) {
        int answer = 0;
        int bitCount = Integer.bitCount(n);
        while (true) {
            n += 1;
            if (bitCount == Integer.bitCount(n)) {
                answer = n;
                break;
            }
        }
        System.out.println(answer);
        return answer;
    }
}