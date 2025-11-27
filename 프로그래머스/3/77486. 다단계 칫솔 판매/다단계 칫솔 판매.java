import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        // 상사관계를 정의할 HashMap 선언
        // ex) jaimie의 추천인은 mary
        Map<String, String> boss = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            boss.put(enroll[i], referral[i]);
        }
        
        // 수익금을 저장할 HashMap선언
        // mary -> 958
        Map<String, Integer> pay = new HashMap<>();
        
        for (int i = 0; i < seller.length; i++) {
            // 현재 판매원
            String curName = seller[i];
            
            // 칫솔을 판매한 총 금액
            int money = amount[i] * 100;
            
            // 남은 돈이 0원보다 많고 센터가 아닐 때까지 수익금 떼주기
            while (money > 0 && !curName.equals("-")) {
                // 10%를 제외한 금액은 현재 사람의 수익 (ex -> 1000원이라면 900원)
                // 만약 20%라면 (money * 20 / 100)
                // 10%에 해당하는 금액은 위 사람에게 넘길 돈
                pay.put(curName, pay.getOrDefault(curName, 0) + money - (money / 10));                
                // 다음 사람으로 이동(위에 있는 상사로 이동)
                curName = boss.get(curName);
                // 10%의 수익금을 다시 위로 올림
                // (수수료 100원에서 10원을 위로 올림)
                money /= 10;
            }
        }
        
        // 다단계에 빠져든 사람만큼의 배열 선언
        int[] answer = new int[enroll.length];
        
        for (int i = 0; i < enroll.length; i++) {
            // 각 사람의 번 돈을 가져옴
            answer[i] = pay.getOrDefault(enroll[i], 0);
        }
            
        return answer;
    }
}