package com.benworld.programmers.summberwinter;

/**
 * nums = {1,2,3,4}
 * result = 1
 * 프로그램 결과 : 주어진 배열에서 3개의 수를 더했을 때 소수가되는 경우의 수
 */
public class PrimeNumber {
    private static final int SIZE = 3000;
    private static final boolean[] PRIME_ARRAY = new boolean[SIZE];

    public int solution(int[] nums) {
        int answer = 0;
        makePrimeNumberArray();
        for (int index1 = 0; index1 < nums.length - 2; index1++) {
            for (int index2 = index1 + 1; index2 < nums.length - 1; index2++) {
                for (int index3 = index2 + 1; index3 < nums.length; index3++) {
                    int sum = nums[index1] + nums[index2] + nums[index3];
                    if(!PRIME_ARRAY[sum]){
                        answer++;
                    }
                }
            }
        }
        System.out.println(answer);
        return answer;
    }

    public void makePrimeNumberArray() {
        PRIME_ARRAY[0] = true;
        PRIME_ARRAY[1] = true;
        for (int number = 2; number * number <= SIZE; number++) {
            if (!PRIME_ARRAY[number]) {
                for (int next = number * number; next < SIZE; next += number) {
                    PRIME_ARRAY[next] = true;
                }
            }
        }
    }
}
