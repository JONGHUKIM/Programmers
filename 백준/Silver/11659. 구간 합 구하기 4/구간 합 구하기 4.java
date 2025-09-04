import java.io.*;
import java.util.*;

public class Main {
    public static void main ( String[] args ) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
            new StringTokenizer(br.readLine());
        
        int suno = Integer.parseInt(st.nextToken());
        int quiz = Integer.parseInt(st.nextToken());
        long[] s = new long[suno + 1];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= suno; i++) {
            s[i] = s[i - 1] + Integer.parseInt(st.nextToken());
        }
        
        for (int q = 0; q < quiz; q++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            
            System.out.println(s[j] - s[i - 1]);
        }
    } 
}