import java.util.*;

class Solution {
    public String solution(String number, int k) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        
        for (char c : number.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peekLast() < c) {
                stack.pollLast();
                
                k--;
            }
            stack.addLast(c);
        }
        
        while (k > 0) {
            stack.pollLast();
            k--;
        }
        
        for (char c : stack) {
            sb.append(c);
        }
        
        return sb.toString();
    }
}