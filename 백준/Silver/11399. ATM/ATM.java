import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] s = new int[n];
        
        StringTokenizer st =
            new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 0; i < n; i++) {
            int insert_index = i;
            int insert_value = a[i];
            for (int j = i - 1; j >= 0; j--) {
                if(a[j] < a[i]) {
                    insert_index = j + 1;
                    break;
                }
                if (j == 0) {
                    insert_index = 0;
                }
            }
            for (int j = i; j > insert_index; j--) {
                a[j] = a[j-1];
            }
            a[insert_index] = insert_value;
        }
        s[0] = a[0];
        for (int i = 1; i < n; i++) {
            s[i] = s[i-1] + a[i];
        } 
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += s[i];
        }
        System.out.println(sum);
        br.close();
    }
}