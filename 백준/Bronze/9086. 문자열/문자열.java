import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            
            char first = s.charAt(0);
            char last = s.charAt(s.length() - 1);
            sb.append(first).append(last).append("\n");
        }
        System.out.println(sb.toString());
        
        br.close();
    }
}


