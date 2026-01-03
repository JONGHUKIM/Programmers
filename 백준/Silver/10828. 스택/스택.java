import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        int[] stack = new int[n];
        int top = -1;
        
        for (int i = 0; i < n; i++) {
            String cmd = br.readLine();
            
            if (cmd.startsWith("push")) {
                int x = Integer.parseInt(cmd.substring(5));
                // 인덱스가 -1에서 0이 되어 stack[0] = 2가 됨
                // 또 다음 추가가 되면 stack[1]
                stack[++top] = x;
            } else if (cmd.equals("pop")) {
                if (top == -1) sb.append(-1).append("\n");
                else sb.append(stack[top--]).append('\n');                
            } else if (cmd.equals("top")) {
                if (top == -1) sb.append(-1).append("\n");                
                else sb.append(stack[top]).append("\n");
            } else if (cmd.equals("size")) {
                sb.append(top + 1).append("\n");
            } else if (cmd.equals("empty")) {
                sb.append(top == -1 ? 1 : 0).append("\n");
            }
        }
       
        System.out.println(sb.toString());
        br.close();
    }
}