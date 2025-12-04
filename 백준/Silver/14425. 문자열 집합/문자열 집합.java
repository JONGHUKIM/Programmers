import java.util.*;
import java.io.*;

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
        
        int count = 0;
        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            if (set.contains(input)) {
                count++;
            }
        }
        
        bw.write(String.valueOf(count));
        
        bw.flush();
        bw.close();
        br.close();
    }
}