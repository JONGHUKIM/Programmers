import java.util.*;

class Solution {
    
    // 상하좌우 
    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    
    // 멤버변수 선언
    private boolean[][] visited;
    private int[][] maps;    
    private int n,m;
    
    private int bfs() {
        ArrayDeque<int[]> que = new ArrayDeque<>();
        
        visited[0][0] = true;
        que.add(new int[]{0, 0, 1});
        
        while(!que.isEmpty()) {
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
                
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (maps[nx][ny] == 0) continue;
                if (visited[nx][ny]) continue;
                
                visited[nx][ny] = true;
                que.add(new int[]{nx, ny, dist + 1});
            }            
        }
        return -1;
    }
    
    public int solution(int[][] maps) {
        
        this.maps = maps;
        
        n = maps.length;
        m = maps[0].length;
        
        visited = new boolean[n][m];
        maps = new int[n][m];
        
        return bfs();
    }
}