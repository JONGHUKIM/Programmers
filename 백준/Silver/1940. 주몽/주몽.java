import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        
        
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        
        StringTokenizer st =
            new StringTokenizer(br.readLine());
        
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(a);
        int count = 0;
        int left = 0;
        int right = n - 1;
        
            while (left < right) {
                int sum = a[left] + a[right];
                if (sum == m) {
                    count++;
                    left++;
                    right--;
                } else if (sum > m) {
                    right--;
                } else {
                    left++;
                }
            }
        
        System.out.println(count);
        br.close();
    }
}