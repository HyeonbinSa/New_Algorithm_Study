package com.benworld.programmers.kakaointernship2021;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 최종 결과값 : 해당 튜플을 배열에 담아 반환
 */
public class Tuple {
    private static ArrayList<Integer> resultTuple = new ArrayList<>();
    public int[] solution(String s) {
        int[] answer = {};
        // 1. 전체를 감싼 괄호 제거
        s = removeTotalBracket(s);
        // 2. 각 집합으로 분리
        ArrayList<String> tupleList = splitByBracket(s);
        // 3. 집합 List를 길이 기준으로 정렬
        tupleList = sortTupleList(tupleList);
        System.out.println(tupleList);
        // 4. 튜플 원소 저장
        for(String tuple : tupleList){
            createTuple(tuple);
        }
        System.out.println(resultTuple);
        answer = resultTuple.stream().mapToInt(tuple->tuple).toArray();
        return answer;
    }

    // 1. 전체를 둘러싼 괄호 제거
    private String removeTotalBracket(String s) {
        s = s.substring(1);
        s = s.substring(0, s.length() - 1);
        return s;
    }

    private ArrayList<String> splitByBracket(String s) {
        ArrayList<String> tupleList = new ArrayList<>();
        for (String str : s.split("\\{")) {
            if (str.length() == 0) {
                continue;
            }
            if (str.charAt(str.length() - 1) == ',') {
                str = str.substring(0, str.length() - 2);
            } else {
                str = str.substring(0, str.length() - 1);
            }
            tupleList.add(str);
        }
        return tupleList;
    }

    private ArrayList<String> sortTupleList(ArrayList<String> tupleList) {
        Collections.sort(tupleList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        return tupleList;
    }
    private void createTuple(String s){
        for(String unit : s.split(",")){
            int integerUnit = Integer.parseInt(unit);
            if(resultTuple.contains(integerUnit)){
                continue;
            }
            resultTuple.add(integerUnit);
        }
    }
}
