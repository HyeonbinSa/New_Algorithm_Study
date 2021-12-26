package com.benworld.programmers.codechallenge;

import java.util.Stack;

public class Ternary {
    private static final int THREE = 3;

    public int solution(int n) {
        int answer = 0;
        Stack<Integer> list = getReverseTernaryList(n);
        answer = getTernaryInteger(list);
        System.out.println(answer);
        return answer;
    }

    private Stack<Integer> getReverseTernaryList(int n) {
        Stack<Integer> list = new Stack<>();
        while (n > 0) {
            list.add(n % THREE);
            n /= THREE;
        }
        return list;
    }

    private int getTernaryInteger(Stack<Integer> list) {
        int ternary = 1;
        int result = 0;
        while (!list.isEmpty()) {
            result += list.pop() * ternary;
            ternary *= THREE;
        }
        return result;
    }
}
