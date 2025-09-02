import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String sNum = sc.next();
        char[] ch = sNum.toCharArray();
        
        int sum = 0;
        
        for (int i = 0; i < ch.length; i++) {
            sum += ch[i] - '0';
        }
        
        System.out.println(sum);
        
    }
}