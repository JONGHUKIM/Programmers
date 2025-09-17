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
        
        Deque<Node> deq = new LinkedList<>();
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(st.nextToken());
            while (!deq.isEmpty() && deq.getLast().value > now) {
                deq.removeLast();
            }
            deq.add(new Node(now, i));
            if (deq.getFirst().index <= i - l) {
                deq.removeFirst();
            }
            bw.write(deq.getFirst().value + " ");
        }      
        
        bw.flush();
        bw.close();
        br.close();
    }
    
    private static class Node {
        int value;
        int index;
        Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}