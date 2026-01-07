import java.util.*;

class Solution {
    
    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};
    
    private int[][] map;
    private boolean[][] visited;
    
    private int numberOfArea, maxSizeOfOneArea, m, n, tempSize;
    
    private void dfs (int x, int y) {
        visited[x][y] = true;
        tempSize++;
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
            if (visited[nx][ny]) continue;
            if (map[x][y] == map[nx][ny]) {
                dfs(nx, ny);                
            }
        }
    }
        
    
    public int[] solution(int m, int n, int[][] picture) {
        numberOfArea = 0;
        maxSizeOfOneArea = 0;
        
        this.m = m;
        this.n = n;
        
        map = picture;
        visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                if (map[i][j] != 0 && !visited[i][j]) {
                    numberOfArea++;
                    
                    tempSize = 0;
                    
                    dfs(i, j);
                    
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, tempSize);
                }
                
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}