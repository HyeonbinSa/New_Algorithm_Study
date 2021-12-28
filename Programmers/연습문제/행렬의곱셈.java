package com.benworld.programmers.practice;

/**
 * 최종 결과값 : 행렬 2개의 곱셈 반환
 * arr1 = [x1][y1]
 * arr2 = [x2][y2]
 * result = [x1][y2]
 * 행렬 곱셈의 조건 y1 = x2
 */

public class MultipleMatrix {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        int x = arr1.length;
        int y = arr2[0].length;
        int m = arr1[0].length;
        for(int xNum=0;xNum<x;xNum++){
            for(int yNum=0;yNum<y;yNum++){
                for(int mNum=0;mNum<m;mNum++){
                    answer[xNum][yNum] += arr1[xNum][mNum]*arr2[mNum][yNum];
                }
            }
        }
        return answer;
    }
}
