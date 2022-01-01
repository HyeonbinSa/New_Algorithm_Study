package com.benworld.programmers.bruteforce;

import java.util.ArrayList;

/**
 * 최종 결과값 : 카펫의 가로,세로의 크기를 반환
 * <p>
 * 1. brown + yellow = 가로 * 세로
 * 2. 가로 > 세로
 */
public class Carpet {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        // 1. brown+yellow의 약수
        int total = brown + yellow;
        ArrayList<Integer> divisorList = getDivisor(total);
        // 2. 각 약수 Case별 Yellow, Brown 개수만큼 나오는지 체크
        for (int divisor : divisorList) {
            System.out.println(divisor);
            int height = divisor;
            int weight = total / height;
            int yellowCount = (weight - 2) * (height - 2);
            int brownCount = (weight * 2) + (2 * (height - 2));
            System.out.println("brown : " + brownCount);
            System.out.println("yellow : " + yellowCount);
            if (yellowCount == yellow && brownCount == brown) {
                answer[0] = weight;
                answer[1] = height;
                break;
            }
        }
        System.out.println("[" + answer[0] + ", " + answer[1] + "]");
        return answer;
    }

    // total의 약수 List(높이 기준)
    private ArrayList<Integer> getDivisor(int total) {
        ArrayList<Integer> divisorList = new ArrayList<>();
        for (int h = 1; h <= Math.sqrt(total); h++) {
            if (total % h == 0) {
                divisorList.add(h);
            }
        }
        return divisorList;
    }
}
