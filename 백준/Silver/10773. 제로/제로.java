import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        int sum = 0;
        int k = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < k; i++) {
            int n = Integer.parseInt(br.readLine());
            
            if (n == 0) {
                stack.pop();
            } else {
                stack.push(n);
            }
        }
        
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        
        System.out.println(sum);
        br.close();
    }
}