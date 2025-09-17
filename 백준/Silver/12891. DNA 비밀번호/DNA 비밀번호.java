import java.util.*;
import java.io.*;

public class Main {
    
    static int[] myArr;
    static int[] checkArr;
    static int checkSecret;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
            new StringTokenizer(br.readLine());
        
        int s = Integer.parseInt(st.nextToken()); // 문자열
        int p = Integer.parseInt(st.nextToken()); // 부분 문자열
        checkArr = new int[4]; // 비밀번호 배열
        myArr = new int[4]; // 현재 배열
        checkSecret = 0; // checkSecret == 4, result++
        int result = 0;
        char[] a; // 문자 데이터
        
        // 문자 데이터 받기
        a = br.readLine().toCharArray();
        // 비밀번호 배열 받기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if (checkArr[i] == 0) {
                checkSecret++;
            }
        }
        
        // 초기 윈도우 설정
        for (int i = 0; i < p; i++) {
            Add(a[i]);
        }       
        
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