import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = 
            new BufferedReader (new InputStreamReader(System.in));
        StringTokenizer st =
            new StringTokenizer (br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int count = 1;
        int sum = 1;
        int s = 1;
        int e = 1;
        
        while (e != n) {
            if (sum == n) {
                count++;
                e++;
                sum = sum + e;
            } else if (sum > n) {
                sum = sum - s;
                s++;

            } else {
                e++;
                sum = sum + e;
            }
        }
        
        System.out.println(count);
        br.close();
    }
}