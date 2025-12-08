import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        
        // 제목 가져오기
        int N = Integer.parseInt(br.readLine());
        HashSet<String> title = new HashSet<>();
        
        for (int i = 0; i < N; i++) {
            title.add(br.readLine());
        }
        
        // 가사 가져오기
        int M = Integer.parseInt(br.readLine());
        // N의 절반 이상일 때 스탑
        int target = (N + 1) / 2;
        // 정답을 외칠 타이밍을 저장하는 변수
        int count = 0;
        
        for (int i = 1; i <= M; i++) {
            String lyrics = br.readLine();
            
            if (title.contains(lyrics)) {
                // 가사가 포함이 되어있으면 count++
                count++;
                // 중복 카운트 방지
                title.remove(lyrics);
            }
            
            // 절반이상 찾았는지 확인
            if (count >= target) {
                // 현재의 위치 출력
                System.out.println(i);
                return;
            }
        }
    }
}