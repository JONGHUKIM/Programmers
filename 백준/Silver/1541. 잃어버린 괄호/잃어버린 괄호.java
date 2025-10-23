import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine();
        String[] parts = s.split("-");
        int result = sumGroup(parts[0]);
        
        for (int i = 1; i < parts.length; i++) {
            result -= sumGroup(parts[i]);
        }
        
        System.out.println(result);
        br.close();
    }
    
    private static int sumGroup(String group) {
        String[] tokens = group.split("\\+");
        int sum = 0;
        
        for (String t : tokens) {
            if (!t.isEmpty()) {
                sum += Integer.parseInt(t);
            }
        }
        
        return sum;
    }
}