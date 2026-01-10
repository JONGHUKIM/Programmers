import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
            new StringTokenizer(br.readLine());
        
        ArrayDeque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        String num = br.readLine().trim();
        
        for (char c : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peekLast() < c) {
                stack.pollLast();
                
                k--;
            }
            stack.addLast(c);
        } 
        
        while (k > 0) {
            stack.pollLast();
            k--;
        }
        
        for (char c : stack) {
            sb.append(c);
        }
        
        System.out.println(sb.toString());
        br.close();
    }
}