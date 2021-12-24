package com.benworld.programmers.codechallenge;

public class MinimumSquare {
    public int solution(int[][] sizes) {
        int answer = 0;
        int maxLongLength = Integer.MIN_VALUE;
        int maxShortLength = Integer.MIN_VALUE;
        int longLength;
        int shortLength;
        for (int[] size : sizes) {
            if (size[0] < size[1]) {
                shortLength = size[0];
                longLength = size[1];
            } else {
                shortLength = size[1];
                longLength = size[0];
            }
            if (maxLongLength < longLength) {
                maxLongLength = longLength;
            }
            if (maxShortLength < shortLength) {
                maxShortLength = shortLength;
            }
        }
        answer = maxLongLength * maxShortLength;
        System.out.println(answer);
        return answer;
    }
}
