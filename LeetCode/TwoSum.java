package com.benworld.leetcode;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        // <target-검색숫자, 검색 숫자의 index>
        HashMap<Integer, Integer> numMap = new HashMap<>();
        int index = 0;
        for(int num : nums){
            Integer numberIndex = numMap.get(num);
            if(numberIndex != null){
                answer[0] = numberIndex;
                answer[1] = index;
                break;
            }
            numMap.put(target-num, index);
            index++;
        }
        return answer;
    }
}
