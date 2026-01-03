import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        
        int[] q = new int[n];
        int front = 0;
        int back = -1;
        
        for (int i = 0; i < n; i++) {
            String cmd = br.readLine();
            
            if (cmd.startsWith("push")) {
                int x = Integer.parseInt(cmd.substring(5));
                q[++back] = x;
            } else if(cmd.equals("pop")) {
                if (front > back) sb.append(-1).append("\n");
                else sb.append(q[front++]).append("\n");
            } else if(cmd.equals("size")) {
                sb.append(back - front + 1).append("\n");
            } else if(cmd.equals("empty")) {
                sb.append(front > back ? 1 : 0).append("\n");
            } else if(cmd.equals("front")) {
                if (front > back) sb.append(-1).append("\n");
                else sb.append(q[front]).append("\n");
            } else if(cmd.equals("back")) {
                if (front > back) sb.append(-1).append("\n");
                else sb.append(q[back]).append("\n");
            }
        }
        System.out.println(sb.toString());
        br.close();
    }
}