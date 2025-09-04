import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = 
            new BufferedReader (new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        
        StringTokenizer st = new StringTokenizer (br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(a);
        
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            int target = a[i];
            int l = 0;
            int r = n - 1;
            
            while (l < r) {
                if (l == i) {
                    l++;
                    continue;
                }
                if (r == i) {
                    r--;
                    continue;
                }
                int sum = a[l] + a[r];
                
                if (sum == target) {
                    count++;
                    break;
                } else if (sum < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        System.out.println(count);
        br.close();
 
    }
}