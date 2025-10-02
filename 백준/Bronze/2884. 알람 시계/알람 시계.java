import java.util.*;
import java.io.*;

public class Main {        
    
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
            new StringTokenizer(br.readLine());
                
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        m = m - 45;
        
        if (m < 0) {
            h = h - 1;
            m = m + 60;
        }
        if (h < 0) {
            h = 23;
        }
        
        System.out.println(h + " " + m);
        br.close();
    }
}