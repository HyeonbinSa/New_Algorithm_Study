package com.benworld.programmers.codechallenge;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 최종 결과값 : 주어진 Numbers 배열에서 서로 다른 2개의 숫자를 뽑아 만들 수 있는 배열(오름차순)
 * Keyword : stream(), mapToInt()
 */
public class TwoNumberPlus {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        int[] answer = {};
        int number;
        for (int index1 = 0; index1 < numbers.length - 1; index1++) {
            for (int index2 = index1 + 1; index2 < numbers.length; index2++) {
                number = numbers[index1] + numbers[index2];
                set.add(number);
            }
        }
        answer = set.stream().sorted().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}
