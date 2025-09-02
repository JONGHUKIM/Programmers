import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        int max = 0;
        int sum = 0;
        
        for (int i = 0; i < a.length; i++) {
            a[i] += sc.nextInt();
        }
        
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
            sum += a[i];
        }
        
        System.out.println(sum * 100.0 / max / n);
    }
}