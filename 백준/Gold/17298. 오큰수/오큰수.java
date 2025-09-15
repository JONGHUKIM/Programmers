import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =
            new BufferedWriter(new OutputStreamWriter(System.out));
        
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] ans = new int[n];
        
        StringTokenizer st =
            new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty() && a[stack.peek()] < a[i]) {
                ans[stack.pop()] = a[i];
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            ans[stack.pop()] = -1;
        }
        for (int i = 0; i < n; i++) {
            bw.write(ans[i] + " ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
        br.close();
    }
}