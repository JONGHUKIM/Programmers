import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
            new StringTokenizer(br.readLine(), " ");
        
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(br.readLine());
        
        b = b + c;
        
        if (b >= 60) {
            a = a + ( b / 60);
            b = b % 60;
        }
        
        if ( a >= 24) {
            a = a % 24;
        }
        
        System.out.println(a + " " + b);
        br.close();
    }
}