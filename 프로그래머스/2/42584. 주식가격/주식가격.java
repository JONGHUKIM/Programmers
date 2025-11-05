import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        // 스택에 푸쉬하는 값은 주식의 가격이 아닌 주식의 인덱스
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int n = prices.length;
        int[] answer = new int[n];
        
        // 최초엔 비교 대상이 없으므로 0 푸쉬
        stack.push(0);
        
        // 인덱스 1번부터 비교
        for (int i = 1; i < n; i++) {
            // 스택에 값이 있고 현재 주식가격(i)가 과거 주식가격(prices[stack.peek()])보다 떨어지면 pop
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {                
                int j = stack.pop();
                // 현재 인덱스 i - 과거 인덱스 j
                // 값이 아닌 인덱스의 간격을 구함
                answer[j] = i - j;
            }
            stack.push(i);
        }
        
        // 남아있는 스택 즉, 마지막까지 가격이 안떨어짐
        while (!stack.isEmpty()) {
            // 스택은 인덱스를 저장
            int j = stack.pop();
            // (5 - 1) - 4 = 0 인덱스의 길이로 계산
            answer[j] = (n - 1) - j;
        }
        return answer;
    }
}