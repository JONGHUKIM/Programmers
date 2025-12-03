import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =
            new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = 
            new StringTokenizer(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        
        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            
            if (set.contains(target)) {
                sb.append("1 ");
            } else {
                sb.append("0 ");
            }
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
        
    }
}