import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        int num = 1;
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            int su = Integer.parseInt(br.readLine());
            if (su >= num) {
                while (su >= num) {
                    stack.push(num++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else {
                if (!stack.isEmpty() && stack.peek() == su) {
                    stack.pop();
                    sb.append("-\n");
                } else {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println(sb.toString());
        
    }
}
