import java.util.*;

class Solution {
    public String solution(String number, int k) {
        
        ArrayDeque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        
        // 입력받은 숫자 문자열을 한 글자씩 순서대로 확인
        for (char c : number.toCharArray()) {
            
            // 스택에 비교할 앞사람이 있고
            // 아직 숫자를 지울 기회가 남았으며
            // 내 바로 앞사람이 나보다 작다면?
            while (!stack.isEmpty() && k > 0 && stack.peekLast() < c) {
                // 앞사람은 큰 수를 만드는 데 방해되므로 제거
                stack.pollLast();
                // 제거했으니 기회 1회 사용
                k--;
            }
            
            // 현재 숫자는 일단 스택에 줄을 슴
            // 나중에 나보다 더 큰 녀석이 뒤에 오면 나도 쫓겨날 수 있음
            stack.addLast(c);
        }
        
        // 만약 54321처럼 이미 내림차순이라서 위 while문에서 한 번도 제거되지 않았거나,
        // 같은 숫자 등으로 인해 아직 지워야 할 횟수(k)가 남았다면?
        // 뒤에 있는 숫자들을 남은 횟수만큼 잘라냄
        while (k > 0) {
            stack.pollLast();
            k--;
        }
        
        // 스택에 살아남은 숫자들을 문자열로 합치기
        // ArrayDeque는 앞에서부터 순서대로(First -> Last) 나오므로 순서 걱정 없음
        for (char c : stack) {
            sb.append(c);
        }
        
        return sb.toString();
    }
}