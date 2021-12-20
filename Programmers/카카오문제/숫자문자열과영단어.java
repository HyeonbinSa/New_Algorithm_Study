package com.benworld.programmers.kakaointernship2021;

import java.util.HashMap;

// 목표 : 1478 <- one4seveneight
public class NumberStringAndEnglish {
    public int solution(String s) {
        int answer = 0;

        HashMap<String, String> numberMap = new HashMap<>();
        String[] engStringArr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] numberStringArr = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

        for(int index=0;index<10;index++) {
            numberMap.put(engStringArr[index], numberStringArr[index]);
        }

        for(String engString : numberMap.keySet()){
            s= s.replace(engString, numberMap.get(engString));
        }

        answer = Integer.parseInt(s);
        return answer;
    }
}
