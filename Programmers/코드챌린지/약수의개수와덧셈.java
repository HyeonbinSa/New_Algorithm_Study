package com.benworld.programmers.codechallenge;

/**
 * 최종 결과값 : left ~ right 사이의 숫자 중 약수가 홀수면 (-), 짝수면 (+)의 총합 ㄴ
 */
public class DivisorCountPlus {
    public int solution(int left, int right) {
        int answer = 0;
        for (int number = left; number <= right; number++) {
            int sqrt = (int) Math.sqrt(number);
            if (sqrt * sqrt == number) {
                answer -= number;
                continue;
            }
            answer += number;
        }
        return answer;
    }
}
