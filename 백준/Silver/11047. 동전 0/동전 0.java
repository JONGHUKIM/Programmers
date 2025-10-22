import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
            new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coin = new int[n];
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(coin);
        for (int i = n - 1; i >= 0; i--) {
            if (coin[i] <= k) {
                count += k / coin[i]; // 몫만큼 동전 사용
                k %= coin[i]; // 남은 잔돈
            }
            if (k == 0) { // 잔액이 없으면 반복문 종료 
                break;
            }
        }
        System.out.println(count);
        br.close();        
    }
}