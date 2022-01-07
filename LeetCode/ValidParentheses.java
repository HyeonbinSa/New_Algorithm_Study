package com.benworld.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 1. Parentheses : 괄호
 * 최종 결과값 : 주어진 문자열이 올바른 괄호가 맞는지
 * 주어지는 괄호 : (), {}, []
 * ([)]
 * ([])
 */
public class ValidParentheses {
    private static final String SQUARE_START = "[";
    private static final String SQUARE_END = "]";
    private static final String ROUND_START = "(";
    private static final String ROUND_END = ")";
    private static final String CURLY_START = "{";
    private static final String CURLY_END = "}";
    private static final List<String> START_BRACKET = Arrays.asList(SQUARE_START, ROUND_START, CURLY_START);

    public boolean isValid(String s) {
        Stack<String> stack = new Stack<>();
        for (String unit : s.split("")) {
            if (stack.isEmpty() || START_BRACKET.contains(unit)) {
                stack.add(unit);
                continue;
            }
            String lastOfStack = stack.peek();
            if (checkRightBracket(lastOfStack, unit)) {
                stack.pop();
                continue;
            }
            return false;
        }
        return stack.isEmpty();
    }

    private boolean checkRightBracket(String start, String end) {
        if (start.equals(SQUARE_START) && end.equals(SQUARE_END)) {
            return true;
        }
        if (start.equals(ROUND_START) && end.equals(ROUND_END)) {
            return true;
        }
        if (start.equals(CURLY_START) && end.equals(CURLY_END)) {
            return true;
        }
        return false;
    }
}
