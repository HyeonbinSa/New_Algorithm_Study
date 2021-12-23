package com.benworld.programmers.codechallenge;

/**
 * 최종 결과값 : count번 타게 되었을 때 부족한 금액
 * price : 놀이기구 이용료
 * money : 소유 금액
 * count : 이용 횟수
 * 조건 : 이용한 횟수만큼 이용료의 배수
 */
public class InsufficientPrice {
    public long solution(long price, long money, int count) {
        long answer = -1;
        long needMoney = price * (long) factorial(count);
        answer = needMoney - money;
        if (answer < 0) {
            answer = 0;
        }
        System.out.println(answer);
        return answer;
    }

    private int factorial(int count) {
        if (count == 1) {
            return 1;
        }
        return count + factorial(count - 1);
    }
}
