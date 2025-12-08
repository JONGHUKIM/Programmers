import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> wear = new HashMap<>();
        
        for (int i = 0; i < clothes.length; i++) {
            String type = clothes[i][1];
            
            wear.put(type, wear.getOrDefault(type, 0) + 1);
        }
        
        for (int count : wear.values()) {
            answer *= (count + 1);
        }
        
        // 하나 꼭 빼기
        return answer - 1;
    }
}