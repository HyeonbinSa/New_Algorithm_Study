package com.benworld.programmers.codechallenge;

/**
 * 최종 결과값 : 입력받은 n을 나누었을 때 나머지가 1이 되는 최소의 숫자
 */
public class RemainOneNumber {
    public int solution(int n) {
        int answer = 0;
        for (int index = 2; index < n; index++) {
            if (n % index == 1) {
                answer = index;
                return answer;
            }
        }
        return answer;
    }
}
