// dfs

import java.util.*;

class Solution {
    
    // 각 노드에 뭐가 있는지 저장 (0 : 양, 1: 늑대 - 1: 빈 곳)
    int[] node;
    // 지도 (어디랑 어디가 연결 되어있는지 확인)
		ArrayList<Integer>[] graph;
    // 방문기록 (현재노드, 양, 늑대)
    boolean[][][] visited;
    // 양의 최대 마리 수
    int maxS;
    
    // pos: 현재위치, s: 양, w: 늑대
    private void dfs(int pos, int s, int w) {
        // 방문 체크 : 이미 똑같은 상태(같은 위치, 같은 양/늑대 개수)로 온 적이 있다면?
        // 더 볼 필요 없음
        if (visited[pos][s][w]) {
            return;
        }
        
        // 현재 상태 방문 처리
        visited[pos][s][w] = true;
        
        // 백업: 나중에 되돌아올 때 복구하기 위해 현재 값을 기억해둠 (백트래킹)
        int backupS = s;
        int backupW = w;
        int backupNode = node[pos];
        
        // 수집: 현재 위치에 있는 동물 확인
        if (node[pos] == 0) { // 양이면
            // 양 증가
            s++;
        } else if (node[pos] == 1) { // 늑대면
            // 늑대 증가
            w++;
        }
        
        // 중요: 현재 노드의 동물을 가져갔으므로 빈 곳(-1)으로 변경
        // 이렇게 해야 다시 이 노드를 지나갈 때 양/늑대 카운트가 중복으로 안 늘어남
        node[pos] = -1;
        
        // 조건 확인, 이동: 늑대가 양보다 적을 때만 계속 탐색 가능
        if (w < s) {
            // 지금까지 찾은 양의 최댓값 갱신
            maxS = Math.max(maxS, s);
            // 연결된 모든 곳(부모, 자식 상관없이)으로 이동 시도
            for (int next : graph[pos]) {
                dfs(next, s, w);
            }
        }
        
        // 원상복구, 백트래킹
        // 함수가 끝나고 이전 갈림길로 돌아가기 위해, 바꿨던 것들을 모두 되돌림
        node[pos] = backupNode;
        visited[pos][backupS][backupW] = false;
        
        // s와 w는 지역변수라서 굳이 복구 안 해도 함수 끝나면 사라짐
    }
    
    public int solution(int[] info, int[][] edges) {
        // 멤버 변수 연결
        node = info;
        
        graph = new ArrayList[node.length];
        
        // 노드 갯수에 맞게 그래프 초기화
        for (int i = 0; i < node.length; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 양방향 연결 (트리를 그래프처럼)
        for (int[] edge : edges) {
            // 부모 -> 자식
            graph[edge[0]].add(edge[1]);
            // 자식 -> 부모
            graph[edge[1]].add(edge[0]);
        }
        
        // 방문 배열 초기화 [노드번호][양개수][늑대개수]
        // 노드 17개, 양 최대 17마리, 늑대 최대 17마리 넉넉하게 잡음
        visited = new boolean[17][18][18];
        maxS = 0;
        
        // 0번 노드(루트), 양 0마리, 늑대 0마리 상태로 시작
        dfs(0, 0, 0);
        
        return maxS;
    }
}