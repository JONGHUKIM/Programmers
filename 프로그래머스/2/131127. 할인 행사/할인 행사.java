// 복습

import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        HashMap<String, Integer> wantMap = new HashMap<>();
        
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        
        // 연속된 10일 (슬라이딩 윈도우)
        for (int i = 0; i < discount.length - 9; i++) {
            HashMap<String, Integer> discount10 = new HashMap<>();
            
            for (int j = i; j < i + 10; j++) {
                if (wantMap.containsKey(discount[j])) {
                    discount10.put(discount[j], discount10.getOrDefault(discount[j], 0) + 1);
                }
            }
            if (wantMap.equals(discount10)) {
                answer++;
            }
        }
        
        return answer;
    }
}