import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        char[] c = s.toCharArray();
        
        Arrays.sort(c);
        for (int i = c.length - 1; i >= 0; i--) {
            sb.append(c[i]);
        }
        System.out.println(sb.toString());
        br.close();
    }
}