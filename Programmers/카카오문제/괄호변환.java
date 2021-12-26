package com.benworld.programmers.kakaointernship2021;

public class BracketChange {
    private static final String OPEN = "(";
    private static final String CLOSE = ")";
    private static final String SPILT_REGEX = "";
    private static final int EMPTY = 0;

    public String solution(String p) {
        String answer = "";
        answer = splitString(p);
        return answer;
    }

    private String splitString(String p) {
        if (isEmpty(p)) {
            return p;
        }
        String u;
        String v;
        int index = 0;
        int openCount = 0;
        int closeCount = 0;
        for (String str : p.split(SPILT_REGEX)) {
            if (str.equals(OPEN)) {
                openCount++;
            }
            if (str.equals(CLOSE)) {
                closeCount++;
            }
            if (openCount == closeCount) {
                break;
            }
            index++;
        }
        u = p.substring(0, index + 1);
        v = p.substring(index + 1);

        if (isRightBracket(u)) {
            v = splitString(v);
        } else {
            u = changeNoneRightBracket(u, v);
            return u;
        }
        return u + v;
    }

    private boolean isEmpty(String p) {
        return p.length() == EMPTY;
    }

    private boolean isRightBracket(String u) {
        return u.startsWith(OPEN);
    }

    private String changeNoneRightBracket(String u, String v) {
        String temp = OPEN;
        temp += splitString(v);
        temp += CLOSE;
        temp += changeStringU(u);

        return temp;
    }

    private String changeStringU(String u) {
        String temp = "";
        u = u.substring(1);
        u = u.substring(0, u.length() - 1);
        for (String splitU : u.split(SPILT_REGEX)) {
            if (splitU.equals(OPEN)) {
                temp += CLOSE;
                continue;
            }
            if (splitU.equals(CLOSE)) {
                temp += OPEN;
                continue;
            }
        }
        return temp;
    }
}
