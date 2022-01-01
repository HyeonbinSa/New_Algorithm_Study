# 알고리즘  공부

---

## [🖥 프로그래머스 문제](https://github.com/HyeonbinSa/New_Algorithm_Study/tree/master/Programmers) 

### - [Summer/Winter 코딩](https://github.com/HyeonbinSa/New_Algorithm_Study/tree/master/Programmers/SummerWinter%EC%BD%94%EB%94%A9)

### - [카카오 문제](https://github.com/HyeonbinSa/New_Algorithm_Study/tree/master/Programmers/%EC%B9%B4%EC%B9%B4%EC%98%A4%EB%AC%B8%EC%A0%9C)

###  - [코드 챌린지](https://github.com/HyeonbinSa/New_Algorithm_Study/tree/master/Programmers/%EC%BD%94%EB%93%9C%EC%B1%8C%EB%A6%B0%EC%A7%80)

### - [Dev Matching](https://github.com/HyeonbinSa/New_Algorithm_Study/tree/master/Programmers/Devmatching)

### - [연습문제](https://github.com/HyeonbinSa/New_Algorithm_Study/tree/master/Programmers/%EC%97%B0%EC%8A%B5%EB%AC%B8%EC%A0%9C)

### - [완전탐색](https://github.com/HyeonbinSa/study-algorithm/tree/master/Programmers/%EC%99%84%EC%A0%84%ED%83%90%EC%83%89)

---

## 📄 학습 내용 

- String 클래스 split()메소드 

  - split(String regex, int limit) : 인자로 구분자(regex)와 limit을 입력
  - 인자 limit 
    - limit > 0 : regex로 입력한 문자를 기준으로 분리하되 limit의 개수만큼 배열을 생성
    - limit = 0 : regex로 입력한 문자를 기준으로 분리 (길이가 0인 문자열은 무시)
    - limit < 0 : regex로 입력한 문자를 기준으로 분리하되 길이가 0인 문자열도 포함

- Integer Class 내장 메소드

  - Integer.bitCount() : int타입의 숫자를 2진수로 변환한 값에서 1의 개수를 반환해주는 메서드
  - Integer.toBinaryString() : String Type으로 입력한 숫자의 2진수값을 반환해주는 메서드

- Pattern.matches()

  ```java
  Pattern.matches("^[a-z]*$", "비교문자");
  ```

  - 영어 소문자만 존재하는지 확인하기 위한 정규식 사용 > 정규식은 추가 공부 필요(2022-01-01)

- ArrayList<Integer> -> int[] 변환

  ```java
  ArrayList<Integer> resultTuple = new ArrayList<>();
  ...
  int[] answer = resultTuple.stream().mapToInt(tuple->tuple).toArray();
  ```
  - stream.mapToInt()를 이용하여 변환할 수 있음.
  - `IntStream` (원시적 인 int 값의 시퀀스)을 반환하는`mapToInt()`메서드