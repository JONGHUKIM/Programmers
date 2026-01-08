import java.util.*;
import java.io.*;

public class Main {
    
    private static int n, m;
    private static boolean[] visited;
    private static ArrayList<Integer> graph[];
    
    private static void dfs(int x) {
        visited[x] = true;
        
        for (int next : graph[x]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
                new StringTokenizer(br.readLine());
        
        int count = 0;
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        visited = new boolean[n + 1];
        graph = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            graph[u].add(v);
            graph[v].add(u);
        }
        
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }
        
        System.out.println(count);
    }
}