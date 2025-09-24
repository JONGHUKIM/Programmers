import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        Number[] a = new Number[n];
        
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            a[i] = new Number(num, i);
        }                        
        
        Arrays.sort(a);
        int max = 0;
        
        for (int i = 0; i < n; i++) {
            if (max < a[i].index - i) {
                max = a[i].index - i;
            }
        }
        
        System.out.println(max + 1);
        br.close();
        
    }
    
    private static class Number implements Comparable<Number> {
        int value;
        int index;
        
        public Number(int value, int index) {
            this.value = value;
            this.index = index;
        }
        
        public int compareTo(Number o) {
            return this.value - o.value;
        }
    }
}