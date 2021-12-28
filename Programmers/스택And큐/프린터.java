package com.benworld.programmers.stackqueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 최종 결과값 : 인쇄를 요청한 문서(Location)이 몇번째로 인쇄가 되는지 반환
 * 조건 1 : 인쇄 대기 목록 가장 앞의 문서를 꺼냈을 때 뒤에 중요도가 높은 문서가 존재하면 맨 뒤로 보냄.
 */

class File {
    int priority;
    int location;

    public File(int priority, int location) {
        this.priority = priority;
        this.location = location;
    }
}

public class Printer {
    private static Queue<File> waitQueue = new LinkedList<>();
    private static Queue<File> printQueue = new LinkedList<>();

    public int solution(int[] priorities, int location) {
        int answer = 0;
        initWaitFileQueue(priorities);
        makePrintQueue();
        answer = checkLocation(location);
        System.out.println(answer);
        return answer;
    }

    // 초기 인쇄물 대기큐 생성
    private void initWaitFileQueue(int[] priorities) {
        int location = 0;
        for (int priority : priorities) {
            waitQueue.add(new File(priority, location++));
        }
    }

    // 프린트 완료 큐 생성
    private void makePrintQueue() {
        while (!waitQueue.isEmpty()) {
            File getFile = waitQueue.poll();
            for (File file : waitQueue) {
                if (file.priority > getFile.priority) {
                    waitQueue.add(getFile);
                    getFile = null;
                    break;
                }
            }
            if (getFile != null) {
                printQueue.add(getFile);
            }
        }
    }

    // 선택한 인쇄물의 출력 순서 계산 함수
    private int checkLocation(int location) {
        int index = 1;
        for (File file : printQueue) {
            if (file.location == location) {
                break;
            }
            index++;
        }
        return index;
    }
}
