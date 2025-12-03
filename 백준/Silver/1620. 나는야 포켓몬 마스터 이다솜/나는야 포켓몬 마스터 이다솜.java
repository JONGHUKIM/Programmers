import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =
            new BufferedWriter(new OutputStreamWriter(System.out));
               
        StringTokenizer st =
            new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken()); 
        
        // 이름으로 번호를 찾을 때 사용 (키: 이름, 값: 번호)
        Map<String, Integer> pokeMap = new HashMap<>();
        
        // 번호로 이름을 찾을 때 사용 (인덱스: 번호, 값: 이름)
        String[] nameArr = new String[N + 1];
        
        // 입력 받고 저장
        // 배열의 시작이 1부터 시작하기때문에 i = 1부터 시작
        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            
            pokeMap.put(name, i); // 피카츄 -> 25번에 저장
            nameArr[i] = name; // 25번 배열에 피카츄 저장
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            
            // 입력된 값이 숫자인지 문자인지 판단해야 함
            // 첫 글자가 숫자인지 확인하는 방법이 가장 빠름
            if (isNumber(line)) {
                // 숫자라면 -> 배열에서 이름을 꺼냄
                int idx = Integer.parseInt(line);
                sb.append(nameArr[idx]);
            } else {
                // 문자라면 -> 맵에서 번호를 꺼냄
                sb.append(pokeMap.get(line));
            }
            sb.append("\n");
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    
    // 문자열이 숫자인지 판별하는 메서드
    private static boolean isNumber(String s) {        
        // 첫 글자가 0~9라면 숫자로 판단
        return Character.isDigit(s.charAt(0));
    }
}