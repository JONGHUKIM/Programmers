import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
            new StringTokenizer(br.readLine());
        
        int num1 = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int num2 = Integer.parseInt(st.nextToken());
        
        int result3 = num1 * (num2 % 10); // 일의 자리
        int result4 = num1 * ((num2 / 10) % 10); // 십의 자리
        int result5 = num1 * (num2 / 100); // 백의 자리
        int result6 = num1 * num2;
        
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);
        System.out.println(result6);
        br.close();
            
    }
}