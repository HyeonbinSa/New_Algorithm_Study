package com.benworld.programmers.devmatching;

import java.util.HashSet;
import java.util.Set;

/**
 * 최종 결과값 : 맞을 수 있는 최고 결과값과 최저 결과값을 반환
 * 조건 : 알아볼 수 없는 번호를 0으로 표기기
 */
public class LottoRanking {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        Set<Integer> set = new HashSet<>();
        int zeroCount = 0;
        for (int win_num : win_nums) {
            set.add(win_num);
        }
        for (int lotto : lottos) {
            if (lotto == 0) {
                zeroCount++;
                continue;
            }
            set.add(lotto);
        }
        int loseCount = set.size() - win_nums.length;
        int minWinNumber = lottos.length - zeroCount - loseCount;
        int maxWinNumber = minWinNumber + zeroCount;
        answer[0] = getRank(maxWinNumber);
        answer[1] = getRank(minWinNumber);
        System.out.println(answer[0] + "," + answer[1]);
        return answer;
    }

    private int getRank(int winNumber) {
        if (winNumber == 6) {
            return 1;
        }
        if (winNumber == 5) {
            return 2;
        }
        if (winNumber == 4) {
            return 3;
        }
        if (winNumber == 3) {
            return 4;
        }
        if (winNumber == 2) {
            return 5;
        }
        return 6;
    }
}
