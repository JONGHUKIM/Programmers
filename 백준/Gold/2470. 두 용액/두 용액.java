import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =
            new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        
        StringTokenizer st =
            new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());            
        }
        
        Arrays.sort(a);
        
        int start = 0;
        int end = n - 1;
        int minSum = Integer.MAX_VALUE;
        int ansLeft = 0;
        int ansRight = 0;
        
        while (start < end) {
            int sum = a[start] + a[end];
            
            if (Math.abs(sum) < Math.abs(minSum)) {
                minSum = sum;
                ansLeft = a[start];
                ansRight = a[end];
            }
            
            if (sum < 0) {
                start++;
            } else if (sum > 0) {
                end--;
            } else {
                break;
            }
        }        
        bw.write(String.valueOf(ansLeft + " " + ansRight));
        bw.flush();
        bw.close();
        br.close();
    }
}