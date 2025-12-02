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
        HashMap<Integer, Integer> nums = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            int key = Integer.parseInt(st.nextToken());
            
            nums.put(key, nums.getOrDefault(key, 0) + 1);
        }
        
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            
            sb.append(nums.getOrDefault(target, 0)).append(" ");
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}