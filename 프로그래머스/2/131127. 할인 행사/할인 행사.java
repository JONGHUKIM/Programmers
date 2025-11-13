import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        // 원하는 물품과 필요한 수량을 HashMap에 저장
        HashMap<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        
        // discount 배열에서 연속 10일 동안의 품목을 검사
        for (int i = 0; i < discount.length - 9; i++) {
            
            // 현재 10일간 등장하는 물품의 종류와 개수를 저장
            HashMap<String, Integer> discount10 = new HashMap<>();
                        
             // i일부터 i+9일까지(총 10일)의 품목 개수를 카운트
            for (int j = i; j < i + 10; j++) {
                if (wantMap.containsKey(discount[j])) { // 원래 필요한 물품만 카운트
                    discount10.put(discount[j], discount10.getOrDefault(
                    discount[j], 0) + 1);
                }    
            }        
            // 원하는 물품과 세일 품목이 같으면 answer++
            if (wantMap.equals(discount10)) {
                answer++;
            }
        }                
        return answer;
    }
}