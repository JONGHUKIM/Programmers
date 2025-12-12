import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =
            new BufferedWriter(new OutputStreamWriter(System.out));
        
        // 출입 기록 수 n 입력 받기
        int n = Integer.parseInt(br.readLine());
        
        // 현재 회사에 있는 사람을 저장할 HashMap 선언
        // Key : 이름, Value : 상태
        HashMap<String, String> map = new HashMap<>();
            
        // n번 반복하며 로그 처리
        for (int i = 0; i < n; i++) {
            // Baha Enter 공백으로 기준을 나눔
            StringTokenizer st = new StringTokenizer(br.readLine());
        
            String name = st.nextToken();
            String status = st.nextToken();
            
            // enter면 맵에 추가하고 아니면 맵에서 제거
            if (status.equals("enter")) {
                map.put(name, status);
            } else {
                map.remove(name);
            }
        }
        
        // 맵에 남아 있는 사람만 list에 저장
        ArrayList<String> list = new ArrayList<>(map.keySet());
        
        // 사전 순의 역순으로 출력
        Collections.sort(list, Collections.reverseOrder());
        
        // 결과 출력
        for (String name : list) {
            bw.write(name + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}