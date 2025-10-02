import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());        
        
        for (int i = 1; i <= 9; i++) {
            int result = n * i;
            System.out.println(n + " * " + i + " = " + result);
        }
        br.close();
    }
}


