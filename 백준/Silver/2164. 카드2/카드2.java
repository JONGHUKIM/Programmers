import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> que = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            que.add(i);
        }
        
        while (que.size() > 1) {
            que.poll();
            if (!que.isEmpty()) {
                que.add(que.poll());
            }
        }
        if (!que.isEmpty()) {
            System.out.println(que.poll());
        }
        br.close();
    }
}