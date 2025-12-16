import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =
            new BufferedWriter(new OutputStreamWriter(System.out));
        
        int t = Integer.parseInt(br.readLine());
        
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            
            Map<String, Integer> wear = new HashMap<>();
            
            for (int i = 0; i < n; i++) {
                StringTokenizer st =
                    new StringTokenizer(br.readLine());
                
                String name = st.nextToken();
                String type = st.nextToken();
                
                wear.put(type, wear.getOrDefault(type, 0) + 1);
            }
            
            int answer = 1;
            
            for (int count : wear.values()) {
                answer *= (count + 1);
            }
            bw.write((answer - 1) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}