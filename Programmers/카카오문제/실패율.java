package com.benworld.programmers.kakaointernship2021;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * 최종 결과값 : 실패율이 높은 스테이지의 배열
 * N : 전체  스테이지의 수
 * stages : 현재 멈춘 스테이지의 번호
 */
class Fail {
    int stage;
    double failure;

    public Fail(int stage, double failure) {
        this.stage = stage;
        this.failure = failure;
    }
}

public class Failure {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        ArrayList<Fail> failList = new ArrayList<>();
        int[] lastStages = new int[N + 2];
        for (int stage : stages) {
            lastStages[stage]++;
        }
        int remainUser = stages.length;
        for (int stage = 1; stage <= N; stage++) {
            double fail;
            if (lastStages[stage] == 0) {
                fail = 0;
            } else {
                fail = (double) lastStages[stage] / (double) remainUser;
                remainUser -= lastStages[stage];
            }
            failList.add(new Fail(stage, fail));
        }
        failList.sort(new Comparator<Fail>() {
            @Override
            public int compare(Fail o1, Fail o2) {
                return Double.compare(o2.failure, o1.failure);
            }
        });
        int index = 0;
        for (Fail fail : failList) {
            answer[index++] = fail.stage;
        }
        return answer;
    }
}
