package com.benworld.programmers.practice;

/**
 * 최종 결과값 : 주어진 문자열의 짝수번째 인덱스는 대문자, 홀수번째 인덱스는 소문자
 * 조건 : " "(공백)을 통해 구분되며 각 구분된 문자열의 인덱스 번호에 따름
 * <p>
 * 추가 확인 : split() 메서드를 사용할 때 limit 인자
 * - limit > 0 : regex로 입력한 문자를 기준으로 분리하되 limit의 개수만큼 배열을 생성
 * - limit = 0 : regex로 입력한 문자를 기준으로 분리 (Zero Length String은 무시)
 * - limit < 0 : regex로 입력한 문자를 기준으로 분리하되 Zero Length String도 포함
 */
public class OddString {
    public String solution(String s) {
        String answer = "";
        s = s.toLowerCase();
        String[] stringArray = s.split(" ", -1);
        System.out.println(stringArray.length);
        int index = 0;
        for (String string : stringArray) {
            string = changeString(string);
            stringArray[index++] = string;
        }
        answer = String.join(" ", stringArray);
        System.out.println(answer);
        return answer;
    }

    private String changeString(String string) {
        String result = "";
        for (int index = 0; index < string.length(); index++) {
            if (index % 2 == 0) {
                result += (char) (string.charAt(index) - 32);
                continue;
            }
            result += string.charAt(index);
        }
        return result;
    }
}
