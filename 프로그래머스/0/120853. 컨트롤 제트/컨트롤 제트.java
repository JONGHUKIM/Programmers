import java.util.*;

class Solution {
    public int solution(String s) {
        // 스택선언        
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int answer = 0;
        
        // 공백을 제거하고 w에 저장
        for (String w : s.split(" ")) {
            if (w.equals("Z")) { // Z가 나오면
                if (!stack.isEmpty()) {
                    answer -= stack.pop(); // 직전에 더했던 값을 뺌
                }
            } else {
                int num = Integer.parseInt(w);
                stack.push(num);
                answer += num; // Z가 없다면 누적합
            }
        }
        return answer;        
    }
}