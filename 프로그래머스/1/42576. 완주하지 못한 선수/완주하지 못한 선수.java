import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        // put get getOrDefault
        HashMap<String, Integer> map = new HashMap<>();
        
        // Participant 선수 명단 HashMap에 저장
        for (String player : participant) {            
            map.put(player, map.getOrDefault(player, 0) + 1); // 동명이인 계산
        }
        
        // Completion 선수 명단 HashMap에 저장
        for (String player : completion) {
            map.put(player, map.get(player) - 1); // 모든 키값에 - 1
        }
        
        // 키 호출
        for (String key : map.keySet()) {
            if (map.get(key) != 0) { // 0 아니고 1이 남는다면 완주 못한 선수
                answer = key;
                break;
            }
        }
        
        return answer;
    }
}