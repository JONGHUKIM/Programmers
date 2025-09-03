import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = 
            new BufferedReader (new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        char[] c = s.toCharArray();
        int sum = 0;
        
        for (int i = 0; i < c.length; i++) {
            sum += c[i] - '0';
        }
        
        System.out.println(sum);
        br.close();
    }
}