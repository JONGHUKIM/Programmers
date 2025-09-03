import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = 
            new BufferedReader (new InputStreamReader(System.in));
        StringTokenizer st = 
            new StringTokenizer (br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        int sum = 0;
        int max = 0;
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        for (int i =0; i < n; i++) {
            if (a[i] > max ) {
                max = a[i];
            }
            
            sum += a[i];
        }
        
        System.out.println(sum * 100.0 / max / n);
    }
}