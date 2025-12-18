import java.util.*;

class Solution {
    
    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};
    
    boolean[][] visited;
    
    public int solution(int[][] maps) {
        
        ArrayDeque<int[]> que = new ArrayDeque<>();
        
        int n = maps.length;
        int m = maps[0].length;
        
        visited = new boolean[n][m];
        
        que.add(new int[]{0, 0, 1});
        visited[0][0] = true;
        
        while(!que.isEmpty()) {
            int[] cur = que.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];
            
            if (x == n - 1 && y == m - 1) {
                return dist;
            }
            
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                
                if (maps[nx][ny] == 0) {
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
}