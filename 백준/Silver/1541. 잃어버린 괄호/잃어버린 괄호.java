import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in))           ;
        
        String s = br.readLine();
        String[] parts = s.split("-");
        
        String[] first = parts[0].split("\\+");
        int result = 0;
        for (String num : first) {
            if (!num.isEmpty()) result += Integer.parseInt(num);
        }
        
        for (int i = 1; i < parts.length; i++) {
            String[] nums = parts[i].split("\\+");
            int temp = 0;
            for (String num : nums) {
                if (!num.isEmpty()) temp += Integer.parseInt(num);
            }
            result -= temp;
        }
        
        System.out.println(result);
        br.close();
    }
}