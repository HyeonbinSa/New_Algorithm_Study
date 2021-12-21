package com.benworld.programmers.codechallenge;

public class PlusNoneExistNumber {
    public int solution(int[] numbers) {
        int answer = 0;
        int[] countArray = new int[10];

        for (int number : numbers) {
            countArray[number]++;
        }

        for(int index=0;index<10;index++){
            if(countArray[index] == 0){
                answer += index;
            }
        }

        return answer;
    }
}
