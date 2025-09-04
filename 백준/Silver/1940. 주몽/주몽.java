import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader (new InputStreamReader(System.in));
        StringTokenizer st =
            new StringTokenizer (br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer (br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        
        st = new StringTokenizer (br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(a);
        
        int i = 0;
        int j = n - 1;
        int count = 0;
        
        while (i < j) {
            if (a[i] + a[j] > m) {
                j--;
            } else if (a[i] + a[j] < m) {
                i++;
            } else {
                count++;
                i++;
                j--;
            }
        }
        System.out.println(count);
        br.close();
    }
}