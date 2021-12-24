package com.benworld.programmers.practice;

/**
 * 최종 결과값 : 2016년 1월 1일은 금요일, 입력한 일자의 요일을 반환
 */
public class Year2016 {
    private static final String[] WEEKS = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    private static final int[] MONTH = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public String solution(int a, int b) {
        String answer = "";
        int startDay = 5;
        int day = -1;
        if (a >= 2) {
            day += getDays(a);
        }
        day += b;
        int weekIndex = (day + startDay) % 7;
        answer = WEEKS[weekIndex];
        return answer;
    }

    private int getDays(int month) {
        int days = 0;
        for (int index = 0; index < month - 1; index++) {
            days += MONTH[index];
        }
        return days;
    }
}
