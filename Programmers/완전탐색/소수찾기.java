package com.benworld.programmers.bruteforce;

import java.util.HashSet;
import java.util.Set;

/**
 * 최종 결과값 : 입력받은 numbers로 만들 수 있는 숫자 중 소수의 개수를 반환
 * 1. 소수 판단 배열 생성 - 사이즈는 numbers의 자리수의 최대수
 * 2. Set을 통해 만들 수 있는 숫자 조합 생성
 * 3. Set에 생성된 숫자의 소수 판단
 */

public class FindPrimeNumber {
    private static boolean[] isPrime;
    private static Set<Integer> set = new HashSet<>();

    public int solution(String numbers) {
        int answer = 0;
        int num = (int) Math.pow(10, numbers.length());
        isPrime = new boolean[num];
        boolean[] visited = new boolean[numbers.length()];
        makePrimeArray(num);
        makeNumber("", numbers.split(""), visited);
        for (int number : set) {
            if (!isPrime[number]) {
                answer++;
            }
        }
        System.out.println(set);
        System.out.println(answer);
        return answer;
    }

    // 소수 판단할 수 있는 배열 생성
    private void makePrimeArray(int num) {
        isPrime[0] = isPrime[1] = true;
        for (int number = 2; number * number < num; number++) {
            if (!isPrime[number]) {
                for (int next = number * number; next < num; next += number) {
                    isPrime[next] = true;
                }
            }
        }
    }

    // String numbers를 통해 만들 수 있는 숫자 생성
    private void makeNumber(String string, String[] numbers, boolean[] visited) {
        String str = string;
        if (string.length() != 0) {
            set.add(Integer.parseInt(str));
            if (str.length() == numbers.length) {
                return;
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            if (!visited[i]) {
                str += numbers[i];
                visited[i] = true;
                makeNumber(str, numbers, visited);
                str = string;
                visited[i] = false;
            }
        }
    }
}
