import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =
            new BufferedWriter(new OutputStreamWriter(System.out));
        
        int total = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st =
                new StringTokenizer(br.readLine());
            
            int price = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            
            sum += price * count;
        }
        if (total == sum) {
            bw.write(String.valueOf("Yes"));
        } else {
            bw.write(String.valueOf("No"));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}