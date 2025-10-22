import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int sum = 0;
        long[] s = new long[n];
        
        StringTokenizer st =
            new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(a);
        s[0] = a[0];
        for (int i = 1; i < n; i++) {
            s[i] = s[i - 1] + a[i];
        }
        
        for (int i = 0; i < n; i++) {
            sum += s[i];
        }
        
        System.out.println(sum);
        br.close();
    }
}