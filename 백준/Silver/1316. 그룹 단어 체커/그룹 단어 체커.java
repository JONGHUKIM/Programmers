import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        
        int answer = 0;
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            
            boolean[] check = new boolean[26];
            boolean ok = true;
            char prev = 0;
            
            for (int j = 0; j < s.length(); j++) {
                char cur = s.charAt(j);
                
                if (cur != prev) {
                    if (check[cur - 'a']) {
                        ok = false;
                        break;
                    }
                    check[cur -'a'] = true;
                    prev = cur;
                }
            }
            if (ok) answer++;
        }
        
        System.out.println(answer);
    }
}