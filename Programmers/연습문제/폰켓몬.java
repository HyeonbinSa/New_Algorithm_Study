package com.benworld.programmers.practice;

import java.util.HashSet;
import java.util.Set;

/**
 * 최종 결과값 : N마리 중 N/2마리를 가질 때 가질 수 있는 종류의 최대의 수
 */
public class Phonecketmon {
    public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> monsterSet = new HashSet<>();
        for (int num : nums) {
            monsterSet.add(num);
        }
        answer = nums.length / 2;
        if (monsterSet.size() < nums.length / 2) {
            answer = monsterSet.size();
        }
        return answer;
    }
}
