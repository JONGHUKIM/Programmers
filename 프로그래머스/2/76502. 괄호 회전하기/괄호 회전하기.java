import java.util.*;
// 어렵다


class Solution {
    public int solution(String s) {
        // 해쉬맵 선언
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        
        // S의 길이만큼 선언
        int n = s.length();
        // 이어붙이기를 위해 s += s
        s += s;
        int answer = 0;
        
        A:for (int i = 0; i < n; i++) {
            ArrayDeque<Character> stack = new ArrayDeque<>();
            for (int j = i; j < i + n; j++){
                char c = s.charAt(j);
                
                if (!map.containsKey(c)) {
                    stack.push(c);
                } else {
                    if (stack.isEmpty() || !stack.pop().equals(map.get(c))) {
                        continue A;
                    }                
                }   
            }
            if (stack.isEmpty()) {
                answer++;
            }
        }
        return answer;
    }
}