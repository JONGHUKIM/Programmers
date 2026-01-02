import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
            new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();
        
        int lenA = a.length();
        int lenB = b.length();
        
        int answer = Integer.MAX_VALUE;
        
        // a의 시작점을 옮기면서 비교
        // i = 0일 때
        // B : adbdfsb
        // A : abab
        
        // i = 1일 때
        // B : adbdfsb
        // A :  abab
        for (int i = 0; i <= lenB - lenA; i++) {
            int diff = 0;
            for (int j = 0; j < lenA; j++) {
                // 현재 위치의 a문자와 b의 문자를 비교
                if (a.charAt(j) != b.charAt(i + j)) {
                    diff++;
                }
            }
            answer = Math.min(answer, diff);
        }
        System.out.println(answer);
        br.close();
    }
}