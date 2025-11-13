import java.util.*;

class Solution {

    // 노드 클래스
    private class Node {
        boolean removed; // 삭제 확인
        Node next;
        Node prev;
    }
    
    // 노드 배열 선언
    Node nodeArr[] = new Node[1000000];
    
    public String solution(int n, int k, String[] cmd) {
        for (int i = 0; i < n; i++) {
            nodeArr[i] = new Node();
        }
        
        for (int i = 1; i < n; i++) {
            nodeArr[i - 1].next = nodeArr[i];
            nodeArr[i].prev = nodeArr[i - 1];
        }
        
        Node curr = nodeArr[k];
        ArrayDeque<Node> stack = new ArrayDeque<>();
        
        for (String str : cmd) {
            if (str.charAt(0) == 'U') {
                int x = Integer.parseInt(str.substring(2));
                for (int i = 0; i < x; i++) {
                    curr = curr.prev;
                }
            } else if (str.charAt(0) == 'D') {
                int x = Integer.parseInt(str.substring(2));
                for (int i = 0; i < x; i++) {
                    curr = curr.next;
                }
            } else if (str.charAt(0) == 'C') {
                stack.push(curr);
                curr.removed = true;
                Node up = curr.prev;
                Node down = curr.next;
                
                if (up != null) {
                    up.next = down;               
                }
                if (down != null) {
                    down.prev = up;
                    curr = down;
                } else {
                    curr = up;
                }
            } else {
                Node node = stack.pop();
                node.removed = false;
                Node up = node.prev;
                Node down = node.next;
                
                if (up != null) {
                    up.next = node;
                }
                if (down != null) {
                    down.prev = node;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            if (nodeArr[i].removed) {
                sb.append('X');
            } else {
                sb.append('O');
            }
        }
        
        return sb.toString();
        
    }
}