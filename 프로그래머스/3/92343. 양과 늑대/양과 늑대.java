import java.util.*;

class Solution {
    
    private int[] info;
    private int maxS;
    private ArrayList<Integer>[] graph;
    private boolean[][][] visited;
    
    private void dfs(int pos, int s, int w) {
        if (visited[pos][s][w]) {
            return;
        }
        
        visited[pos][s][w] = true;
        
        int backupS = s;
        int backupW = w;
        int backupI = info[pos];
        
        if (info[pos] == 0) {
            s++;
        } else if(info[pos] == 1) {
            w++;
        }
        
        info[pos] = -1;
        
        if (w < s) {
            maxS = Math.max(maxS, s);
            for (int next : graph[pos]) {
                dfs(next, s, w);
            }
        }
        
        info[pos] = backupI;
        visited[pos][backupS][backupW] = false;
        
    }
    
    public int solution(int[] info, int[][] edges) {
        this.info = info;
        
        graph = new ArrayList[info.length];
        for (int i = 0; i < info.length; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        
        visited = new boolean[17][18][18];        
        maxS = 0;
        
        dfs(0, 0, 0);
        
        return maxS;
    }
}