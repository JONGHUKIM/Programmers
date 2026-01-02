import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine().trim();
        
        if (s.isEmpty()) {
            System.out.println(0);
            return;
        }
        
        StringTokenizer st =
            new StringTokenizer(s);        
                
        System.out.println(st.countTokens());
    }
}