import java.io.*;
import java.util.*;

// 1 2 3 4
// 2 3 4 5
// 3 4 5 6
// 4 5 6 7

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = 
            new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[][] d = new long[n + 1][n + 1];
        
        for (int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                d[i][j] = d[i][j-1] + d[i-1][j] - d[i-1][j-1] 
                    + Integer.parseInt(st.nextToken());
            }
        }
        
        for (int q = 0; q < m; q++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            System.out.println(d[x2][y2] - d[x1-1][y2] - d[x2][y1-1] + d[x1-1][y1-1]);
        }
        
        br.close();
    }
}