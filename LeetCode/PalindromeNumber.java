package com.benworld.leetcode;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        // 1. 문자열 뒤집기
        String temp = "";
        for (String str : Integer.toString(x).split("")) {
            temp = str + temp;
        }
        // 2. 기존과 비교
        return temp.equals(Integer.toString(x));
    }
}
