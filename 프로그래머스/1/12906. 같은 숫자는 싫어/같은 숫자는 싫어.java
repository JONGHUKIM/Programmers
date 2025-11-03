import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        // 스택 선언
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        // 스택이 비어있거나, peek과 다를때만 push
        for (int n : arr) {
            if (stack.isEmpty() || stack.peek() != n) {
                stack.push(n);
            }
        }
        
        int[] answer = new int[stack.size()];
        
        // 스택은 LIFO(역순), pop
        for (int i = answer.length - 1; i >= 0; i--) {
            answer[i] = stack.pop();
        }

        return answer;
    }
}