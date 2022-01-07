package com.benworld.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        // 1. 길이를 기준으로 정렬
        // 2. 최소 길이의 문자열의 길이만큼 반복
        // 3. str.startsWith()을 통해서 모든 문자열이 해당하는지 확인
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        String answer = "";
        String compareString = "";
        for (String strArr : strs[0].split("")) {
            compareString += strArr;
            for (String str : strs) {
                if (!str.startsWith(compareString)) {
                    return answer;
                }
            }
            answer = compareString;
        }
        return answer;
    }
}
