import java.util.*;
import java.io.*;

public class Main {
    
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int N, M, V;
    
    private static void dfs(int index) {
        
        System.out.print(index + " ");
        
        visited[index] = true;
        
        for (int next : graph[index]) {
            if(!visited[next]) {
                dfs(next);
            }
        }
    }
    
    private static void bfs() {
        ArrayDeque<Integer> que = new ArrayDeque<>();
        
        visited = new boolean[N + 1];
        
        que.add(V);
        visited[V] = true;
        
        while (!que.isEmpty()) {
            int index = que.poll();
            System.out.print(index + " ");
            
            for (int next : graph[index]) {
                if (!visited[next]) {
                    visited[next] = true;
                    que.add(next);
                }
            }
            
        }
    }
       
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
            new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList[N + 1];
        
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            graph[x].add(y);
            graph[y].add(x);
        }
        
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }
        
        visited = new boolean[N + 1];
        
        dfs(V);
        
        System.out.println();
        
        bfs();
        
        br.close();
        
    }
}