import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];        
        
        StringTokenizer st =
            new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        
        int v = Integer.parseInt(br.readLine());
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            if (v == a[i]) {
                count++;
            }
        }
        
        System.out.println(count);
        br.close();
    }
}