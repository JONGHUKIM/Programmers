import java.util.*;
import java.math.BigInteger;
import java.io.*;

public class Main {
    
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =
            new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        BigInteger count = new BigInteger("2").pow(n).subtract(BigInteger.ONE);
        bw.write(count.toString());
        bw.write("\n");
        
        if (n <= 20) {
            hanoi(n, 1, 2, 3);
            bw.write(sb.toString());
        }
        bw.flush();
        bw.close();
        br.close();
    }
    
    private static void hanoi(int n, int start, int mid , int end) {
        if (n == 1) {
            sb.append(start).append(" ").append(end).append("\n");
            return;
        }
        
        hanoi(n - 1, start, end, mid);
        
        sb.append(start).append(" ").append(end).append("\n");
        
        hanoi(n - 1, mid, start, end);
    }
}