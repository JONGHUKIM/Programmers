import java.util.*;

class Solution {
    
    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};
    
    private int[][] maps;
    private boolean[][] visited;
    private int m, n;
    
    private int bfs() {
        ArrayDeque<int[]> que = new ArrayDeque<>();
        
        visited[0][0] = true;
        que.add(new int[]{0, 0, 1});
        
        while(!que.isEmpty()) {
            int[] cur = que.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];
            
            if (x == m - 1 && y == n - 1) {
                return dist;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                if (visited[nx][ny]) continue;
                if (maps[nx][ny] == 0) continue;
                
                visited[nx][ny] = true;
                que.add(new int[]{nx, ny, dist + 1});
            }            
        }
        return -1;
    }
    
    
    public int solution(int[][] maps) {
        this.maps = maps;
        
        m = maps.length;
        n = maps[0].length;
        
        visited = new boolean[m][n];
        
        return bfs();
    }
}