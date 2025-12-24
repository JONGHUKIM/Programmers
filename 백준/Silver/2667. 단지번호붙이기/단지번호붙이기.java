import java.util.*;
import java.io.*;

public class Main {
    
    private static int n, count;
    private static boolean[][] visited;
    private static int[][] map;
    
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};    
    
    private static void dfs(int x, int y) {
        visited[x][y] = true;
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
            if (visited[nx][ny]) continue;
            if (map[nx][ny] == 0) continue;
            
            count++;
            
            dfs(nx, ny);            
            
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =
            new BufferedWriter(new OutputStreamWriter(System.out));
        
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    count = 1;
                    dfs(i, j);
                    result.add(count);
                }
            }
        }
        
        Collections.sort(result);
        
        bw.write(result.size() + "\n");
        
        for (int num : result) {
            bw.write(num + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}