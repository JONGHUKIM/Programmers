import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int max = 0;
        int sum = 0;
        
        StringTokenizer st =
            new StringTokenizer(br.readLine());
        
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 0; i < n; i++) {
            if (a[i] > max) {
                max = a[i];
            }
            sum += a[i];
        }
        double result = (double) sum * 100.0 / max / n;
        
        System.out.println(result);
        br.close();
        
    }
}