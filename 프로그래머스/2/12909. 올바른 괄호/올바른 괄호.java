import java.util.*;

class Solution {
    boolean solution(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        // 괄호를 저장할 배열 선언
        char[] a = s.toCharArray();
        for (char c : a) {
            // c와 '('가 같은지 비교 후 '('라면 push
            if (c == '(') {
                stack.push(c);
            } else {
                // 닫힌 괄호가 들어오면 바로 false;
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}