package com.benworld.leetcode;

public class ImplementstrStr {
    public int strStr(String haystack, String needle) {
        int size = needle.length();
        // 1. needle이 empty String일 경우
        if (size == 0) {
            return 0;
        }

        for (int index = 0; index <= haystack.length() - size; index++) {
            String compare = haystack.substring(index, index + size);
            // 2. haystack 내에 needle이 존재할 경우 index 반환
            if (compare.equals(needle)) {
                return index;
            }
        }
        // 3. haystack 내에 needle이 없는 경우
        return -1;
    }
}
