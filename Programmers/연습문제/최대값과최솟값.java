package com.benworld.programmers.practice;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 최종 결과값 : "최소값 최대값" 형태로 반환
 * 1. " "(공백)으로 문자열을 분리 => 문자열 배열
 * 2. ArrayList<Integer> 형태로 분리한 문자열 저장
 * 3. 2번에서 생성한 List 정렬
 * 4. 최소값과 최대값을 통해 결과 문자열 생성
 */
public class MaximumAndMinimum {
    public String solution(String s) {
        String answer = "";
        String[] sArray = s.split(" ");
        ArrayList<Integer> list = changeIntegerList(sArray);
        Collections.sort(list);
        answer += list.get(0) + " " + list.get(list.size() - 1);
        return answer;
    }

    private ArrayList<Integer> changeIntegerList(String[] sArray) {
        ArrayList<Integer> list = new ArrayList<>();
        for (String unit : sArray) {
            list.add(Integer.parseInt(unit));
        }
        return list;
    }
}
