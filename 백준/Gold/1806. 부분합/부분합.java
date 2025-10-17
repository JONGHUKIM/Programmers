import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
            new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;    
        int sum = 0;
        
        while (true) {
            if (sum >= s) {
                minLen = Math.min(minLen, right - left);
                sum -= a[left++];
            } else if (right == n) {
                break;
            } else {
                sum += a[right++];
            }
        }
        br.close();
        if (minLen == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(minLen);
        }
    }
}