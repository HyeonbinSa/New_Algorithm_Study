package com.benworld.programmers.summberwinter;

import java.util.ArrayList;
import java.util.HashMap;

public class SkillTree {
    private static HashMap<String, Integer> skillNumbers = new HashMap<>();
    private static ArrayList<String> skillList = new ArrayList<>();

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        // 1. skill에서 각 skill의 순서를 저장
        int index = 0;
        for (String oneSkill : skill.split("")) {
            skillNumbers.put(oneSkill, index++);
        }

        // 2. 각 skill_tree별 스킬 트리 만족 검사
        for (String skillTree : skill_trees) {
            if (validateSkillTree(skillTree)) {
                answer++;
            }
        }
        
        System.out.println(answer);
        return answer;
    }

    // 스킬트리 만족 검사
    private boolean validateSkillTree(String skillTree) {
        int index = -1;
        for (String skill : skillTree.split("")) {
            for (String skillNumber : skillNumbers.keySet()) {
                if (skill.equals(skillNumber)) {
                    // 저장된 직전 인덱스가 현재 인덱스보다 클 경우
                    // 선행 스킬 트리를 거치지 않고 스킬을 습득한 경우
                    if (index >= skillNumbers.get(skillNumber) || skillNumbers.get(skillNumber) - index != 1) {
                        return false;
                    }
                    index = skillNumbers.get(skillNumber);
                }
            }
        }
        return true;
    }
}
