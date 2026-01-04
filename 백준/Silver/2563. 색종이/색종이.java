import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        // 흰색 도화지 선언
        boolean[][] map = new boolean[101][101];
        int count = 0; // 색종이 넓이
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = 
                new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // 세로 변
            int y = Integer.parseInt(st.nextToken()); // 가로 변
            
            // 가로 10칸, 세로 10칸
            for (int r = x; r < x + 10; r++) {
                for (int c = y; c < y + 10; c++){
                    if(!map[r][c]) {
                        map[r][c] = true;
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
        br.close();
    }
}