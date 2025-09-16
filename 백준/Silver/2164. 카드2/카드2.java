import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =
            new BufferedWriter(new OutputStreamWriter(System.out));
        
        Queue<Integer> que = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        
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
            bw.write(String.valueOf(que.poll()));
        }
        bw.flush();
        bw.close();
        br.close();
        
    }
}