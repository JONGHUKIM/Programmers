import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        sb.append(s).append("??!");
        
        System.out.println(sb.toString());
        
        br.close();
        
    }
}