import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int max = 0;
        int sum = 0;        
        int[] a = new int[n];
        double result = 0.0;
        
        StringTokenizer st =
            new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            if (a[i] > max) {
                max = a[i];
            }
            sum += a[i];
        }
        result = sum * 100.0 / max / n;
        System.out.println(result);
        br.close();
    }
}