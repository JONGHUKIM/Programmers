import java.util.*;
import java.io.*;

public class Main {
    
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    
    private static int n, m;
    private static boolean[][] visited;
    private static int[][] graph;
    
    private static int bfs() {
        ArrayDeque<int[]> que = new ArrayDeque<>();
        visited[0][0] = true;
        que.add(new int[]{0, 0, 1});
        
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];
            
            if (x == n - 1 && y == m - 1) {
                return dist;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                if (graph[nx][ny] == 0) {
                    continue;
                }
                if (visited[nx][ny]) {
                    continue;
                }
                
                visited[nx][ny] = true;
                que.add(new int[]{nx, ny, dist + 1});
            }
        }
        return -1;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =
            new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st =
            new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        visited = new boolean[n][m];
        graph = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = line.charAt(j) - '0';
            }
        }
        bw.write(String.valueOf(bfs()));
        
        bw.flush();
        bw.close();
        br.close();
    }
}