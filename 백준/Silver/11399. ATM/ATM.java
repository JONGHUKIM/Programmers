import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =
            new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int sum = 0;
        int[] s = new int[n];
        
        StringTokenizer st = 
            new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(a);
        s[0] = a[0];
        for (int i = 1; i < n; i++) {
            s[i] = s[i-1] + a[i];
        }
        for (int i = 0; i < n; i++) {
            sum += s[i];
        }
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
        br.close();
    }
}