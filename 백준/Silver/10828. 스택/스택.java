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
                int push = Integer.parseInt(cmd.substring(5));
                stack[++top] = push;
            } else if (cmd.equals("pop")) {
                if (top == -1) sb.append(-1).append("\n");
                else sb.append(stack[top--]).append("\n");
            } else if (cmd.equals("size")) {
                sb.append(top + 1).append("\n");
            } else if(cmd.equals("empty")) {
                sb.append(top == -1 ? 1 : 0).append("\n");
            } else if(cmd.equals("top")) {
                if (top == -1) sb.append(-1).append("\n");
                else sb.append(stack[top]).append("\n");
            }
        }
        System.out.println(sb.toString());
        br.close();
    }
}