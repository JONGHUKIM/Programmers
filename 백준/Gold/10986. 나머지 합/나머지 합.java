import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
            new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long answer = 0;
        long[] a = new long[n + 1];
        long[] c = new long[m];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = a[i - 1] + Integer.parseInt(st.nextToken());
            
            int remainder = (int) (a[i] % m);
            
            if (remainder == 0) {
                answer++;
            }
            c[remainder]++;
        }
        
        for (int i = 0; i < m; i++) {
            answer = answer + (c[i] * (c[i] - 1) / 2);
        }
        
        System.out.println(answer);
        br.close();
    }
}