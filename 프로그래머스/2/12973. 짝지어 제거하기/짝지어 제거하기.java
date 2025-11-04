import java.util.*;

class Solution {
    public int solution(String s) {
        // 스택 선언
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 스택의 맨 위와 값이 같다면 pop
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();                
            } else {
                // push
                stack.push(c);
            }                           
        }
        // 스택이 비어있으면 1 아니면 0
        return stack.isEmpty() ? 1 : 0;
    }
}