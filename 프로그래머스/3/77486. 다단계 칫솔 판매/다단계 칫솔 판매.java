import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        Map<String, String> boss = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            boss.put(enroll[i], referral[i]);
        }
        
        Map<String, Integer> pay = new HashMap<>();
        for (int i = 0; i < seller.length; i++) {
            String curName = seller[i];
            
            int money = amount[i] * 100;
            
            while (money > 0 && !curName.equals("-")) {
                pay.put(curName, pay.getOrDefault(curName, 0) + money - (money / 10));
                curName = boss.get(curName);
                money /= 10;
            }
        }
        int[] answer = new int[enroll.length];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = pay.getOrDefault(enroll[i], 0);
        }
        
        return answer;
    }
}