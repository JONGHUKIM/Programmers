// 완주하지 못한 1명의 선수 구하기
// 동명이인이 있을 수 있음

import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String pleyer : participant) {
            map.put(pleyer, map.getOrDefault(pleyer, 0) + 1);
        }
        
        for (String pleyer : completion) {
            map.put(pleyer, map.get(pleyer) - 1);
        }
        
        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                answer = key;
                break;
            }
        }
        
        return answer;
    }
}