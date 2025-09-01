import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        double avg = 0;
        int max = 0;
        
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
        
        for (int i = 0; i < a.length; i++) {
            if ( a[i] > max ) {
                max = a[i];
            }
            avg += a[i];
        }
        
        System.out.println(avg * 100 / max / n);
    }
}