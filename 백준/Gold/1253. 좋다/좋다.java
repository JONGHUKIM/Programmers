import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        
        StringTokenizer st =
            new StringTokenizer(br.readLine());
        
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(a);
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;
            int t = a[i];
            
            while (left < right) {
                if (left == i) {
                    left++;
                    continue;
                }
                if (right == i) {
                    right--;
                    continue;
                }
                int sum = a[left] + a[right];
                if (sum == t) {
                    count++;
                    break;
                } else if (sum < t) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        System.out.println(count);
        br.close();
    }
}