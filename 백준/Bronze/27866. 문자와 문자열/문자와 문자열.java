import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine();
        char[] c = s.toCharArray();
        int i = Integer.parseInt(br.readLine());

        System.out.println(c[i - 1]);
        br.close();
        
    }
}


