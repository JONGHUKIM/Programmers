import java.util.*;
import java.io.*;

public class Main {
    
    // 전역변수 선언
    static int[] myArr;
    static int[] checkArr;
    static int checkSecret;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
            new StringTokenizer(br.readLine());
        
        int s = Integer.parseInt(st.nextToken()); // 문자열 크기
        int p = Integer.parseInt(st.nextToken()); // 부분 문자열 크기
        char[] a; // 문자열 데이터
        checkArr = new int[4]; // 비밀번호 배열
        myArr = new int[4]; // 현재 문자 배열
        checkSecret = 0; // checkSecert == 4, result++; 조건에 맞는지 검사 
        int result = 0; // 정답
        
        // 문자 데이터를 입력 받음
        a = br.readLine().toCharArray();
        // 비밀번호 데이터를 입력 받음
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            // 0이면 조건에 충족, checkSecret++;
            if (checkArr[i] == 0) {
                checkSecret++;
            }
        }
        
        // 초기 슬라이딩 윈도우, 초기 부분 문자열(p) 처리
        for (int i = 0; i < p; i++) {
            Add(a[i]);
        }
        
        // checkSecret == 4, result++
        if (checkSecret == 4) {
            result++;
        }
        
        // 슬라이딩 윈도우
        for (int i = p; i < s; i++) {
            Add(a[i]);
            Remove(a[i-p]);
            if (checkSecret == 4) {
                result++;
            }
        }
        System.out.println(result);
        br.close();
    }
    
    // 제거 되는 문자를 처리하는 Remove 함수 선언
    private static void Remove(char c) {
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
    
    // 추가 되는 문자를 처리하는 Add 함수 선언
    private static void Add(char c) {
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
