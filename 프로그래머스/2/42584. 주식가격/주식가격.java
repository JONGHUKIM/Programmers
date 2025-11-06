import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        // 주식의 인덱스를 저장할 스택 선언
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int n = prices.length;
        int[] answer = new int[n];
        
        stack.push(0); // 비굣값을 위한 초기 인덱스
        
        // 인덱스와 비교하기 위해 1부터
        for (int i = 1; i < n; i++) {
            // 현재 주식의 가격과 과거 주식의 가격을 비교
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                // 주식의 인덱스를 j에 저장
                int j = stack.pop();
                answer[j] = i - j; // 현재 인덱스 - 과거 인덱스 (3 - 2) 1초를 answer에 저장
            }
            stack.push(i);
        }
        
        // 스택에 남아있는 숫자 처리
        while(!stack.isEmpty()) {
            int j = stack.pop();
            // (5 - 1) - 3 = 1초로 answer 리턴
            answer[j] = (n - 1) - j;
        }
        
        return answer;
    }
}