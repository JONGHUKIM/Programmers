import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
                        
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            char prev = 0;
            boolean ok = true;
            boolean[] alpha = new boolean[26];
            
            for (int j = 0; j < s.length(); j++) {
                char cur = s.charAt(j);
                
                if (cur != prev) {
                    if (alpha[cur - 'a']) {
                        ok = false;
                        break;
                    }
                    alpha[cur - 'a'] = true;
                    prev = cur;
                }
            }
            
            if (ok) answer++;
        }
        
        System.out.println(answer);
        br.close();
    }
}