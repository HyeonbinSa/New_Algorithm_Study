package com.benworld.programmers.kakaointernship2021;

public class RecommendID {
    private  static final String DOUBLE_POINT ="..";
    private  static final String SINGLE_POINT =  ".";
    private  static final String NULL_STRING =  "";
    private  static final char ALPHA_START = 'a';
    private  static final char ALPHA_END = 'a';
    private  static final char NUMBER_START = '0';
    private  static final char  NUMBER_END = '9';
    private static final int MINIMUM_LENGTH = 3;
    private static final int MAXIMUM_LENGTH = 15;
    private static final int LOOP_STRING_LENGTH = 3;

    public String solution(String new_id) {
        String answer = "";
        new_id = changeLower(new_id);
        new_id = removeOtherCharacter(new_id);
        new_id = removeDuplicatePoint(new_id);
        new_id = removeStartOrEndPoint(new_id);
        new_id = isNullString(new_id);
        new_id = checkStringLengthLimit(new_id);
        new_id = makeMinimumLength(new_id);
        answer = new_id;
        return answer;
    }

    // Level 1
    private String changeLower(String new_id) {
        return new_id.toLowerCase();
    }

    // Level 2
    private String removeOtherCharacter(String new_id) {
        String result = "";
        for (String unit : new_id.split(NULL_STRING)) {
            if (unit.charAt(0) >= NUMBER_START && unit.charAt(0) <= NUMBER_END) {
                result += unit;
                continue;
            }
            if (unit.charAt(0) >= ALPHA_START && unit.charAt(0) <= ALPHA_END) {
                result += unit;
                continue;
            }
            if (unit.charAt(0) == '-' || unit.charAt(0) == '_' || unit.charAt(0) == '.') {
                result += unit;
                continue;
            }
        }
        return result;
    }

    // Level 3
    private String removeDuplicatePoint(String new_id) {
        while (new_id.contains(DOUBLE_POINT)) {
            new_id = new_id.replace(DOUBLE_POINT, SINGLE_POINT);
        }
        return new_id;
    }

    // Level 4
    private String removeStartOrEndPoint(String new_id) {
        if (new_id.length() < 1) {
            return new_id;
        }
        if (new_id.charAt(0) == DOUBLE_POINT.charAt(0)) {
            new_id = new_id.substring(1);
        }
        if (new_id.length() >= 1 && new_id.charAt(new_id.length() - 1) == DOUBLE_POINT.charAt(0)) {
            new_id = new_id.substring(0, new_id.length() - 1);
        }
        return new_id;
    }

    // Level 5
    private String isNullString(String new_id) {
        if (new_id.equals(NULL_STRING)) {
            new_id = "a";
        }
        return new_id;
    }

    //  Level 6
    private String checkStringLengthLimit(String new_id) {
        if (new_id.length() >= MAXIMUM_LENGTH+1) {
            new_id = new_id.substring(0, MAXIMUM_LENGTH);
            new_id = removeStartOrEndPoint(new_id);
        }
        return new_id;
    }

    //  Level 7
    private String makeMinimumLength(String new_id) {
        while (new_id.length() < MINIMUM_LENGTH) {
            if (new_id.length() <= LOOP_STRING_LENGTH) {
                new_id += new_id.charAt(new_id.length() - 1);
            }
        }
        return new_id;
    }
}
