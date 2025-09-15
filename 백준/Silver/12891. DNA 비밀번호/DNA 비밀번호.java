import java.util.*;
import java.io.*;

public class Main {
    // 전역변수 선언
    static int[] checkArr;
    static int[] myArr;
    static int checkSecret;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
            new StringTokenizer(br.readLine());
        
        int s = Integer.parseInt(st.nextToken()); // 문자열 크기
        int p = Integer.parseInt(st.nextToken()); // 부분 문자열 크기
        checkArr = new int[4]; // 비밀번호 배열
        myArr = new int[4]; // 현재 배열
        checkSecret = 0; // myArr과 checkArr이 같으면 ++ 또는 --;
        int result = 0; // checkSecret == 4, ++ 정답
        char[] a; // 문자열 데이터
        
        a = br.readLine().toCharArray(); // 문자열을 읽어와 저장
        st = new StringTokenizer(br.readLine());
        // 비밀번호 배열을 받음 
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if (checkArr[i] == 0) { // 0이면 이미 만족하기 때문에 checkSecret++;
                checkSecret++; 
            }
        }
        
        // 초기 P 부분 문자열을 처리, 초기 슬라이딩 윈도우
        for (int i = 0; i < p; i++) {
            Add(a[i]);
        }
        
        if (checkSecret == 4) {
            result++;
        }
        
        // 슬라이딩 윈도우
        for (int i = p; i < s; i++) {
            Add(a[i]);
            Remove(a[i - p]);
            if (checkSecret == 4) {
                result++;
            }
        }
        System.out.println(result);
        br.close();
        
    }
    
    // Remove 함수 선언 (제거되는 문자를 처리하는 함수)
    private static void Remove (char c) {
        switch (c) {
            case 'A':
                if (myArr[0] == checkArr[0]) {
                    checkSecret--;
                }
                myArr[0]--;
                break;
            case 'C':
                if (myArr[1] == checkArr[1]) {
                    checkSecret--;
                }
                myArr[1]--;
                break;
            case 'G':
                if (myArr[2] == checkArr[2]) {
                    checkSecret--;
                }
                myArr[2]--;
                break;
            case 'T':
                if (myArr[3] == checkArr[3]) {
                    checkSecret--;
                }
                myArr[3]--;
                break;
        }
    }
    
    // Add 함수 선언 ( 새로 들어온 문자를 처리하는 함수)
    private static void Add (char c) {
        switch (c) {
            case 'A':
                myArr[0]++;
                if (myArr[0] == checkArr[0]) {
                    checkSecret++;
                }
                break;
            case 'C':
                myArr[1]++;
                if (myArr[1] == checkArr[1]) {
                    checkSecret++;
                }
                break;
            case 'G':
                myArr[2]++;
                if (myArr[2] == checkArr[2]) {
                    checkSecret++;
                }
                break;
            case 'T':
                myArr[3]++;
                if (myArr[3] == checkArr[3]) {
                    checkSecret++;
                }
                break;
        }
    }
}
