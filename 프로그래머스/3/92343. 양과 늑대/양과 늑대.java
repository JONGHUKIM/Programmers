import java.util.*;

class Solution {
    
    int[] node;
    ArrayList<Integer>[] graph = new ArrayList[17];
    int maxS;
    boolean[][][] visited;
    
    private void dfs(int pos, int s, int w) {
        // 이미 방문했다면 리턴        
        if (visited[pos][s][w]) {
            return;
        }
        
        // 현재 상태 방문처리
        visited[pos][s][w] = true;
        
        // 되돌아가기 위해 백업 처리
        int backupS = s;
        int backupW = w;
        int backupNode = node[pos];
        
        // 노드가 0이면 양 증가
        if (node[pos] == 0) {
            s++;
            // 노드가 1이면 늑대 증가
        } else if (node[pos] == 1) {
            w++;
        }
        // 노드가 비어있다면 -1
        node[pos] = -1;
        
        // 양이 늑대보다 많다면
        if (w < s) {
            // 양의 최댓값 갱신
            maxS = Math.max(maxS, s);
            for (int next : graph[pos]) {
                // 다음으로 이동
                dfs(next, s, w);
            }
        }
        
        node[pos] = backupNode;
        visited[pos][backupS][backupW] = false;
    }
    
    public int solution(int[] info, int[][] edges) {
        // 멤버 변수와 연결
        node = info;
        // 노드 갯수에 맞게 그래프 초기화
        for (int i = 0; i < node.length; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 양방향 연결
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]); // 부모 -> 자식
            graph[edge[1]].add(edge[0]); // 자식 -> 부모
        }
        
        maxS = 0;
        visited = new boolean[17][18][18];
        
        dfs(0, 0 ,0);
        
        return maxS;
    }
}