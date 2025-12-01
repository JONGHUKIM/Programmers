import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 줄: N과 X 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        
        // 둘째 줄: 수열 A의 N개 숫자
        st = new StringTokenizer(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            
            if (a < X) {
                sb.append(a).append(" ");
            }
        }
        
        // 결과 출력
        System.out.println(sb.toString());
    }
}
