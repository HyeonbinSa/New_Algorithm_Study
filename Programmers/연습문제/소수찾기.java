package com.benworld.programmers.practice;

/**
 * 최종 결과값 : 1 ~ 입력받은 n 사이에 있는 소수의 개수를 반환
 */
public class FindPrimeNumber {

    public int solution(int n) {
        boolean[] isPrime = new boolean[n + 1];
        int answer = 0;
        isPrime = makePrimeArray(isPrime, n);
        for (int number = 2; number <= n; number++) {
            if (!isPrime[number]) {
                answer++;
            }
        }
        return answer;
    }

    private boolean[] makePrimeArray(boolean[] isPrime, int n) {
        isPrime[0] = isPrime[1] = true;
        for (int number = 2; number * number <= n; number++) {
            if (!isPrime[number]) {
                for (int next = number + number; next <= n; next += number) {
                    isPrime[next] = true;
                }
            }
        }
        return isPrime;
    }
}
