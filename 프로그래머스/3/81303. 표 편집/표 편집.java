import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        // Node 객체 대신 int 배열 선언        
        int[] prev = new int[n];
        int[] next = new int[n];
        
        // 0 ~ n - 1까지 연결
        for (int i = 0; i < n; i++) {
            prev[i] = i - 1;
            next[i] = i + 1;
        }
        
        // 마지막 노드의 다음 노드는 없음
        next[n - 1] = -1;
        
        // 삭제된 행을 저장할 스택 선언
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        // 노드의 현재 위치
        int curr = k; 
        
        for (String c : cmd) {
            // 현재 입력된 명령어
            char op = c.charAt(0);
            
            // U라면
            if (op == 'U') {
                int x = Integer.parseInt(c.substring(2));
                while (x > 0) {
                    // 배열 인덱스를 타고 이동
                    curr = prev[curr];
                    x--;
                }
            } else if (op == 'D') {
                int x = Integer.parseInt(c.substring(2));
                while (x > 0) {
                    curr = next[curr];
                    x--;
                }
            } else if (op == 'C') {
                // 삭제된 행 스택에 추가
                stack.push(curr);
                
                // 연결 고리 끊기 (이전 노드와 다음 노드 연결)
                // prev[curr] 의 next = next[curr]이다
                if (prev[curr] != -1) {
                    next[prev[curr]] = next[curr];
                }
                if (next[curr] != -1) {
                    prev[next[curr]] = prev[curr];
                }
                
                if (next[curr] != -1) {
                    curr = next[curr];
                } else {
                    curr = prev[curr];
                }
            } else if (op == 'Z') {
                // 삭제 됐던 행 복구
                int removed = stack.pop();
                
                if (prev[removed] != -1) {
                    next[prev[removed]] = removed;
                }
                if (next[removed] != -1) {
                    prev[next[removed]] = removed;
                }
            }
        }
        
        // sb에 미리 O로 다 채우고 삭제된 것만 X로 변경
        StringBuilder sb = new StringBuilder("O".repeat(n));
        
        while(!stack.isEmpty()) {
            sb.setCharAt(stack.pop(), 'X');
        }        
        
        return sb.toString();
    }
}