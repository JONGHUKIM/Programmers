import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine();
        int[] a = new int[s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            // 9875인경우 1개씩 가져와서 배열에 저장
            a[i] = Integer.parseInt(s.substring(i, i+1));
        }
        
        for (int i = 0; i < s.length(); i++) {
            int max = i; // 현재 가장 큰 값을 i로 임시지정
                // i의 다음번째 자리부터 비교
                for (int j = i + 1; j < s.length(); j++) {
                    if (a[j] > a[max]) {
                        max = j; // 인덱스 값만 찾음
                    }
                }
            if (a[i] < a[max]) {
                int temp = a[i];
                a[i] = a[max];
                a[max] = temp;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            System.out.print(a[i]);
        }
        br.close();
    }
}