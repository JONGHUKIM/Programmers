import java.util.*;

class Solution {
    
    int[] node;
    boolean[][][] visited;
    ArrayList<Integer>[] graph;
    int maxS;
    
    private void dfs(int pos, int s, int w) {
        if (visited[pos][s][w]) {
            return;
        }
        
        visited[pos][s][w] = true;
        
        int backupS = s;
        int backupW = w;
        int backupNode = node[pos];
        
        if (node[pos] == 0) {
            s++;
        } else if (node[pos] == 1) {
            w++;
        }
        
        node[pos] = -1;
        
        if (w < s) {
            maxS = Math.max(maxS, s);
            for (int next : graph[pos]) {
                dfs(next, s, w);
            }
        }
        
        node[pos] = backupNode;
        visited[pos][backupS][backupW] = false;
        
    }
    
    public int solution(int[] info, int[][] edges) {
        
        node = info;
        
        graph = new ArrayList[node.length];
        
        for (int i = 0; i < node.length; i++) {
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