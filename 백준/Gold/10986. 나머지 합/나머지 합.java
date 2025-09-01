import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = 
            new BufferedReader (new InputStreamReader(System.in));
        StringTokenizer st = 
            new StringTokenizer (br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] d = new long[n];
        long[] c = new long[m];
        long answer = 0;
        
        st = new StringTokenizer(br.readLine());
        d[0] = Long.parseLong(st.nextToken());

        int remainder0 = (int)((d[0] % m + m) % m);
        if (remainder0 == 0) answer++;
        c[remainder0]++;
        
        for (int i = 1; i < n; i++) {
            d[i] = d[i - 1] + Integer.parseInt(st.nextToken());
            int remainder = (int)((d[i] % m + m) % m);
            if (remainder == 0) answer++;
            c[remainder]++;
        }

        for (int i = 0; i < m; i++) {
            if (c[i] > 1) {
                answer += (c[i] * (c[i] - 1)) / 2;
            }
        }
        
        System.out.println(answer);
        
        br.close();
        
    }
}