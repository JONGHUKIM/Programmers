import java.util.*;

class Solution {
    
    // 노드 선언 (LinkedList)
    private class Node {
        boolean removed; // 삭제 여부
        Node prev; // 이전 노드
        Node next; // 다음 노드
    }
    
    // 전체 노드를 관리하는 배열 (최대 1,000,000개)
    Node[] nodeArr = new Node[1000000];
    
    public String solution(int n, int k, String[] cmd) {      
        
        // 이중 연결 리스트 초기화 (각 노드를 앞뒤로 연결)
        for (int i = 0; i < n; i++) {
            nodeArr[i] = new Node();            
        }
        
        // 배열 인덱스만큼 선택하기 위해 i = 1부터
        for (int i = 1; i < n; i++) {
            nodeArr[i - 1].next = nodeArr[i];
            nodeArr[i].prev = nodeArr[i - 1];            
        }
        
        // 현재의 행(위치) nodeArr[2]
        Node curr = nodeArr[k];
        // 삭제된 노드를 저장하는 스택 (복구 시 사용)
        ArrayDeque<Node> stack = new ArrayDeque<>();
        
        // 명령어 처리        
        for (String str : cmd) {
            // cmd == U일 때
            if (str.charAt(0) == 'U') {
                int x = Integer.parseInt(str.substring(2)); // ex -> U 2
                // X만큼 이동 ex -> U 2 
                for (int i = 0; i < x; i++) {
                    curr = curr.prev; // 위로 2칸이동
                }
            } else if (str.charAt(0) == 'D') { // cmd == D 일때
                int x = Integer.parseInt(str.substring(2)); // ex -> D 2
                // X만큼 이동 ex -> D 2
                for (int i = 0; i < x; i++) {
                    curr = curr.next; // 아래로 2칸이동
                }                
            } else if (str.charAt(0) == 'C') { // cmd == C 일때
                // stack에 삭제 행 저장
                stack.push(curr);
                // 삭제된 행은 false -> true로 변경
                curr.removed = true;                
                Node up = curr.prev;
                Node down = curr.next;
                if (up != null) {
                    up.next = down; // 이전 노드와 다음 노드 연결
                }
                if (down != null) {
                    down.prev = up;
                    curr = down; // 다음 행으로 이동
                } else {
                    curr = up; // 마지막 행이면 이전 행으로
                }
            } else { // 명령어 Z
                // node에 삭제 되어있던 데이터 복귀
                Node node = stack.pop();
                // Node의 removed true -> false로 변경
                node.removed = false;                
                Node up = node.prev;
                Node down = node.next;
                // 현재 행이 복귀 되고 업이 null이 아니라면
                if (up != null) {
                    up.next = node;
                }
                // 현재 행이 복귀 되고 다운이 null이 아니라면
                if (down != null) {
                    down.prev = node;
                }                
            }
        }
        
        // 최종 상태 문자열 생성 (removed 여부에 따라 O/X 표시)
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            // 노드 배열에 removed가 true라면 X
            if (nodeArr[i].removed) {
                sb.append('X');
            } else {
                // 노드 배열에 removed가 false라면 O
                sb.append('O');
            }
        }
        return sb.toString();
        
    }
}