import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = 
            new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st =
            new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken()); // 숫자 데이터
        int l = Integer.parseInt(st.nextToken()); // 윈도우 크기
        Deque<Node> myDeque = new LinkedList<>(); // 덱 선언
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(st.nextToken());
            // 마지막이 비지 않거나 새로운 값이 들어올 때마다 현재 수보다 큰 값을 덱에서 제거
            while (!myDeque.isEmpty() && myDeque.getLast().value > now) {
                myDeque.removeLast();
            }
            myDeque.addLast(new Node(now, i));
            
            // 윈도우의 범위를 벗어난 값은 덱에서 제거
            if (myDeque.getFirst().index <= i - l) {
                myDeque.removeFirst();
            }
            bw.write(myDeque.getFirst().value + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    
    // 노드 클래스
    private static class Node {
        int value;
        int index;
        
        // 노드 생성자
        Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}