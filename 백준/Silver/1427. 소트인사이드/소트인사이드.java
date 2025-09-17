import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        
        String n = br.readLine();
        char[] c = n.toCharArray();
        
        Arrays.sort(c);
        StringBuilder sb = new StringBuilder();
        for(int i = c.length - 1; i >= 0; i--) {
            sb.append(c[i]);
        }
        System.out.print(sb.toString());
        br.close();
    }
}