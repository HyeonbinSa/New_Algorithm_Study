package com.benworld.programmers.kakaointernship2021;

import java.util.Stack;

/**
 * board :
 * {{0,0,0,0,0},
 * {0,0,1,0,3},
 * {0,2,5,0,1},
 * {4,2,4,4,2},
 * {3,5,1,3,1}}
 * moves : [1,5,3,5,1,2,1,4]
 * 결과 : 4
 * 최종 결과값 : 크레인을 모두 작동시킨 후 사라진 인형의 수를 반화나
 */
public class CrainDoll {
    private static Stack<Integer> dollStack = new Stack<>();

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        for (int move : moves) {
            int doll = findDollInLine(board, move);
            if (stackCrainDoll(doll) && doll != -1) {
                answer += 2;
            }
        }
        System.out.println(answer);
        return answer;
    }

    // moves에서 입력받은 Line에서 인형 찾기
    private int findDollInLine(int[][] board, int move) {
        int doll = -1;
        for (int i = 0; i < board.length; i++) {
            if (board[i][move - 1] == 0) {
                continue;
            }
            doll = board[i][move - 1];
            board[i][move - 1] = 0;
            return doll;
        }
        return doll;
    }

    // 옮긴 인형 목록(Stack)에 추가 (2개가 겹칠 경우 제거 후 점수 반영)
    private boolean stackCrainDoll(int doll) {
        if (dollStack.isEmpty()) {
            dollStack.add(doll);
            return false;
        }
        if (dollStack.peek() == doll) {
            dollStack.pop();
            return true;
        }
        dollStack.add(doll);
        return false;
    }
}
