import java.util.*;

// {}, (), []을 HashMap에 저장한다
// A:for 문을 이용해서 괄호를 비교한다
// 스택을 push한다
// 스택을 pop한다

class Solution {
    public int solution(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        
        // 원본 문자열 길이 저장
        int n = s.length();
        // 원본 문자열 뒤에 원본 문자열을 이어 붙여서 2번 나오도록 함
        s += s;            
        int answer = 0;
        
        A:for (int i = 0; i < n; i++) {
            ArrayDeque<Character> stack = new ArrayDeque<>();
            for (int j = i; j < i + n; j++) {
                char c = s.charAt(j);
                // 해시맵안에 해당 키가 없다면 열리는 괄호
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