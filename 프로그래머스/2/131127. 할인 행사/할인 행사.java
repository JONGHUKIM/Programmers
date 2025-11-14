import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        HashMap<String, Integer> wish = new HashMap<>();
        // 원하는 품목 및 개수 저장
        for (int i = 0; i < want.length; i++) {
            wish.put(want[i], number[i]);
        }
        
        for (int i = 0; i < discount.length - 9; i++) {
            HashMap<String, Integer> dis10days = new HashMap<>();
            
            for (int j = i; j < i + 10; j++) {
                if (wish.containsKey(discount[j])) {
                    dis10days.put(discount[j], dis10days.getOrDefault(discount[j], 0) + 1);
                }
            }
            
            if (wish.equals(dis10days)) {
                answer++;
            }
        }
        
        return answer;
    }
}