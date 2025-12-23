import java.util.*;
import java.io.*;

public class Main {
    
    private static ArrayList<Integer>[] graph;
    private static boolean[] visited;
    private static int count;
    
    private static void dfs(int index) {
        visited[index] = true;
        
        for (int next : graph[index]) {
            if (!visited[next]) {
                count++;
                dfs(next);
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =
            new BufferedWriter(new OutputStreamWriter(System.out));
        
        int cpu = Integer.parseInt(br.readLine());
        int net = Integer.parseInt(br.readLine());
        
        graph = new ArrayList[cpu + 1];
        for (int i = 1; i <= cpu; i++) {
            graph[i] = new ArrayList<>();
        }
        
        visited = new boolean[cpu + 1];
        
        for (int i = 0; i < net; i++) {
            StringTokenizer st =
                new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            graph[x].add(y);
            graph[y].add(x);
        }
        
        for (int i = 1; i <= cpu; i++) {
            Collections.sort(graph[i]);
        }
        
        dfs(1);
        
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }
}