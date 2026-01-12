import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String line;
        
        while ((line = br.readLine()) != null) {
            StringTokenizer st =
                new StringTokenizer(line);            
        
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int sum = a + b;
            
            sb.append(sum).append("\n");
        }
        
        System.out.println(sb.toString());
        br.close();
    }
}