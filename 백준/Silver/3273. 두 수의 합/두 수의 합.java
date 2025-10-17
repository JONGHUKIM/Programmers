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
        
        int total = Integer.parseInt(br.readLine());
        int start = 0;
        int end = n - 1;
        int count = 0;
        
        while (start < end) {
            int sum = a[start] + a[end];
            if (sum == total) {
                count++;
                start++;
                end--;
            } else if (sum < total) {
                start++;
            } else {
                end--;
            }
        }
        System.out.println(count);
        br.close();
    }
}