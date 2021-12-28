package com.benworld.programmers.stackqueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 최종 결과값 : 모든 트럭이 다리를 건널 때 걸리는 최소 시간
 * weight : 다리가 견딜 수 있는  무게
 * bridge_length : 다리의 길이
 * truck_weight : 트럭들의 무게
 */
public class TruckOnBridge {
    private static Queue<Integer> waitQueue = new LinkedList<>();

    // 7,4,5,6  / 10
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = bridge_length;
        Queue<Integer> bridgeQueue = new LinkedList<>(); // 다리 위 Queue
        initWaitQueue(truck_weights);
        int bridgeWeight = 0;
        while (!waitQueue.isEmpty()) {
            int truck = waitQueue.poll();
            while (true) {
                // 1. 다리가 비어있을 때
                if (bridgeQueue.isEmpty()) {
                    bridgeQueue.add(truck);
                    bridgeWeight += truck;
                    answer++;
                    break;
                }
                // 2. 다리가 꽉찼을 때
                if (bridgeQueue.size() == bridge_length) {
                    bridgeWeight -= bridgeQueue.poll();
                    continue;
                }
                // 3. 다리가 버틸 수 있는 무게일 때
                if (bridgeWeight + truck <= weight) {
                    bridgeQueue.add(truck);
                    bridgeWeight += truck;
                    answer++;
                    break;
                    // 4. 다리가 버틸 수 없는 무게일 때
                } else {
                    bridgeQueue.add(0);
                    answer++;
                }
            }
        }
        System.out.println(answer);
        return answer;
    }

    // 대기 트럭 Queue 초기화
    private void initWaitQueue(int[] truck_weights) {
        for (int truck : truck_weights) {
            waitQueue.add(truck);
        }
    }
}
