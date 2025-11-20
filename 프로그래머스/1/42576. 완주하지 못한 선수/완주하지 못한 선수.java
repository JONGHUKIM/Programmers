// 복습

import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String str : participant) {
                // 키(플레이어 이름), 벨류(1 or 2)
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        
        for (String str : completion) {
            map.put(str, map.get(str) - 1);
        }
        
        // {leo, leo, kiki} -> leo = 2, kiki = 1
        // 2 - 1 = 1, 1 - 1 = 0
        // 결국 leo = 1
        // 따라서 key값이 0이 아니면 완주를 하지 못한 선수 
        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                answer = key;
                break;
            }
        }
        
        return answer;
    }
}