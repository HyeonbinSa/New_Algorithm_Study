package com.benworld.leetcode;

import java.util.HashSet;
import java.util.Set;

/*
[217. Contains Duplicate]
최종 결과값 : 배열 내에 동일 값이 존재하는지 판단 (boolean)
1. Set을 이용하여 개수 판단.
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.size() != nums.length;
    }
}
