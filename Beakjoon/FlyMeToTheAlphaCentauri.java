package com.benworld.boj;

import java.util.Scanner;

public class FlyMeToTheAlphaCentauri {
    public void solution() {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        for (int i = 0; i < testCase; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int distance = y - x;
            System.out.println(calc(distance));
        }
    }

    private int calc(int distance) {
        // 16일 경우
        int sqrt = (int) Math.ceil(Math.sqrt(distance)); // 4
        int squaredDist = (int) (Math.pow(sqrt, 2)) - distance; // 0 ~ sqrt-1 까지는 -1 /  이후는 -2
        int answer = sqrt * 2 - 1;
        if (squaredDist >= sqrt) {
            answer -= 1;
        }
        return answer;
    }
}

/*
최종 결과값 : 이동장치 작동 최소값
규칙
1  => 1        1
2  => 11       2
3  => 12       2
4  => 121      3
5  => 1211     4
6  => 1221     4
7  => 12211    5
8  => 12221    5
9  => 12321    5
10 => 123211   6
11 => 123221   6
12 => 123321   6
13 => 1233211  7
14 => 1233221  7
15 => 1233321  7
16 => 1234321  7
17 => 12343211 8
18 => 12343221 8
19 => 12343321 8
20 => 12344321 8
21 => 123443211 9
22 => 123443221 9
23 => 123443321 9
24 => 123444321 9
25 => 123454321 9
 */
