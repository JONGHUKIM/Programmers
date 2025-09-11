import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        
        boolean result = true;
        int num = 1; // 오름차순 정렬
        StringBuffer sf = new StringBuffer();
        
        for (int i = 0; i < n; i++) {
            int su = Integer.parseInt(br.readLine());
            if (su >= num) {
                while (su >= num) {
                    stack.push(num++);
                    sf.append("+\n");
                }
                stack.pop();
                sf.append("-\n");
            } else {
                int m = stack.pop();
                if (m > su) {
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    sf.append("-\n");
                }
            }
        }
        if (result) {
            System.out.println(sf.toString());
        }
        
    }
}