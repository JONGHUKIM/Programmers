import java.util.*;
import java.io.*;

public class Main {    
    
    static int cpu, network;
    // 바이러스 걸린 컴퓨터의 갯수
    static int count = 0;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    
    // DFS (깊이 우선 탐색)
    private static void dfs(int index) {
        // 방문 처리
        visited[index] = true;
        
        // 연결 된 노드 탐색
        for (int next : graph[index]) {
            
            // 바이러스가 아직 감염이 안됐다면
            if(!visited[next]) {
                // 바이러스 감염
                count++;
                // 연결되어 있는 다음 컴퓨터 탐색
                dfs(next);
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =
            new BufferedWriter(new OutputStreamWriter(System.out));
        
        // cpu : 정점
        cpu = Integer.parseInt(br.readLine());
        // network : 간선
        network = Integer.parseInt(br.readLine());
        
        // 그래프 초기화
        graph = new ArrayList[cpu + 1];
        for (int i = 1; i <= cpu; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 방문 배열 선언
        visited = new boolean[cpu + 1];
        
        // 간선 정보 입력
        for (int i = 0; i < network; i++) {
            StringTokenizer st =
                new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            // 양방향 연결
            graph[x].add(y);
            graph[y].add(x);
        }
        
        // 정렬은 안해도 되나 혹시 모르니 정렬
        for (int i = 1; i <= cpu; i++) {
            Collections.sort(graph[i]);
        }
        
        // dfs 실행
        dfs(1);
        
        // 정답 출력
        bw.write(String.valueOf(count));
        
        bw.flush();
        bw.close();
        br.close();
    }
}