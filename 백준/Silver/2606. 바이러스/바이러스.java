import java.util.*;
import java.io.*;

public class Main {
    
    static int cpu, network;
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static int count = 0;
    
    private static void dfs(int index) {
        visited[index] = true;
        
        for (int next : graph[index]) {
            if(!visited[next]) {
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
        
        cpu = Integer.parseInt(br.readLine());
        network = Integer.parseInt(br.readLine());
        
        visited = new boolean[cpu + 1];
        graph = new ArrayList[cpu + 1];
        for (int i = 1; i <= cpu; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < network; i++) {
            StringTokenizer st =
                new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            graph[x].add(y);
            graph[y].add(x);
        }
        
        dfs(1);
        
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
        
    }
}