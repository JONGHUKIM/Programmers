import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
            new StringTokenizer(br.readLine());
        
        // 큐 선언
        ArrayDeque<Integer> q = new ArrayDeque<>();
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        // 데이터 큐에 넣기
        for (int i = 1; i <= n; i++) {
            q.add(i);            
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        
        // 큐에 사람이 남아있다면 반복
        while (!q.isEmpty()) {
            // k번째 사람을 빼야하니 k - 1명을 빼야함
            // k번째 일때 반복문 멈춤
            for (int i = 0; i < k - 1; i++) {
                q.add(q.poll());
            }
            
            // k번째 사람을 뽑아서 sb에 삽입
            sb.append(q.poll());
            
            // 사람이 남아있다면 쉼표 추가
            if (!q.isEmpty()) {
                sb.append(", ");
            }
        }
        
        sb.append(">");
        System.out.println(sb.toString());
        br.close();        
    }
}