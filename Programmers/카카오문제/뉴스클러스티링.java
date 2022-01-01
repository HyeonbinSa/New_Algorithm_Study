package com.benworld.programmers.kakaointernship2021;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class NewsClustering {
    public int solution(String str1, String str2) {
        int answer = 0;
        // 1. 대소문자를 구분 X -> 소문자변환
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        // 2. 2글자씩 자른 문자열 리스트 생성 & 2-1 알파벳 이외 문자 제거
        ArrayList<String> listOfStr1 = new ArrayList<>();
        ArrayList<String> listOfStr2 = new ArrayList<>();
        createListOfStr(listOfStr1, str1);
        createListOfStr(listOfStr2, str2);
        System.out.println(listOfStr1);
        System.out.println(listOfStr2);

        // 3. 교집합 만들기
        ArrayList<String> interSection = createIntersection(listOfStr1, listOfStr2);
        ArrayList<String> union = createUnion(listOfStr1, listOfStr2);
        System.out.println("교집합 : " + interSection);
        System.out.println("합집합 : " + union);

        // 4. 자카드 유사도 계산
        double jaccardNumber = calcJaccard(interSection, union);
        System.out.println(jaccardNumber);

        // 5. 자카드 유사도에 65536 곱하고 소수점 버리기
        answer = (int) Math.floor(jaccardNumber * 65536);
        System.out.println(answer);
        return answer;
    }

    private void createListOfStr(ArrayList<String> listOfStr, String str) {
        for (int index = 0; index < str.length() - 1; index++) {
            String splitStr = str.substring(index, index + 2);
            // 1. 두글자씩 끊기, 2. 공백, 숫자 등이 들어갈 시 버림.
            if (Pattern.matches("^[a-z]*$", splitStr)) {
                listOfStr.add(str.substring(index, index + 2));
            }
        }
    }

    private ArrayList<String> createIntersection(ArrayList<String> listOfStr1, ArrayList<String> listOfStr2) {
        ArrayList<String> tempListOfStr1 = new ArrayList<>();
        tempListOfStr1.addAll(listOfStr1);
        ArrayList<String> tempListOfStr2 = new ArrayList<>();
        tempListOfStr2.addAll(listOfStr2);
        ArrayList<String> interSection = new ArrayList<>();
        for (String str1 : tempListOfStr1) {
            if (tempListOfStr2.contains(str1)) {
                tempListOfStr2.remove(str1);
                interSection.add(str1);
            }
        }
        return interSection;
    }

    private ArrayList<String> createUnion(ArrayList<String> listOfStr1, ArrayList<String> listOfStr2) {
        ArrayList<String> tempListOfStr1 = new ArrayList<>();
        tempListOfStr1.addAll(listOfStr1);
        ArrayList<String> tempListOfStr2 = new ArrayList<>();
        tempListOfStr2.addAll(listOfStr2);
        ArrayList<String> union = new ArrayList<>();
        for (String str2 : tempListOfStr2) {
            if (tempListOfStr1.contains(str2)) {
                tempListOfStr1.remove(str2);
                continue;
            }
        }
        union.addAll(tempListOfStr1);
        union.addAll(tempListOfStr2);
        return union;
    }

    private double calcJaccard(ArrayList<String> interSection, ArrayList<String> union) {
        if (interSection.size() == 0 && union.size() == 0) {
            return 1.0;
        }
        return (double) interSection.size() / (double) union.size();
    }
}
