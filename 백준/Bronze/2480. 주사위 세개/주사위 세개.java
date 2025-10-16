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
        
        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());
        int third = Integer.parseInt(st.nextToken());
        
        int result = 0;
        
       if (first == second && first == third && second == third) {
           result = 10000 + (first * 1000); 
       } else if (first == second || first == third) {
           result = 1000 + (first * 100);
       } else if (second == third) {
            result = 1000 + (second * 100);
        } else {
           result = Math.max(first, Math.max(second, third)) * 100;
       }
        
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
           
    }
}