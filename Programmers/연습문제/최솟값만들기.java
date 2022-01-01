package com.benworld.programmers.practice;

import com.sun.tools.javac.util.ArrayUtils;

import java.util.Arrays;
import java.util.Collections;

/**
 * 최종 결과값 : 2개의 배열에서 각각 하나씩 뽑아 곱하여 누적시켰을 때 최소값을 반환
 * A를 내림차순 정렬
 * B를 오름차순 정렬
 */
public class MakeMinimum {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for (int index = 0; index < A.length; index++) {
            answer += A[index] * B[B.length - 1 - index];
        }
        System.out.println(answer);
        return answer;
    }
}
