import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =
            new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st =
            new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        HashSet<String> set = new HashSet<>();
        
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }
        
        ArrayList<String> result = new ArrayList<>();
        
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            
            if (set.contains(name)) {
                result.add(name);
            }
        }
        
        Collections.sort(result);
        
        StringBuilder sb = new StringBuilder();
            
        sb.append(result.size()).append("\n");
        
        for (String s : result) {
            sb.append(s).append("\n");
        }
        
        bw.write(sb.toString());
            
        bw.flush();
        bw.close();
        br.close();
    }
}