import java.util.*;
import java.io.*;

public class Main {
    
    static int[] checkArr;
    static int[] myArr;
    static int checkS;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
            new StringTokenizer(br.readLine());
        
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        char[] a;
        int result = 0;
        checkArr = new int[4];
        myArr = new int[4];
        checkS = 0;
        
        a = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if (checkArr[i] == 0) {
                checkS++;
            }
        }
        
        for (int i = 0; i < p; i++) {
            Add(a[i]);
        }
        
        if (checkS == 4) {
            result++;
        }
        
        for (int i = p; i < s; i++) {
            Add(a[i]);
            Remove(a[i-p]);
            if(checkS == 4) {
                result++;
            }
        }
        System.out.println(result);
        br.close();
    }
    
    private static void Remove(char c) {
        switch (c) {
            case 'A':
                if (checkArr[0] == myArr[0]) {
                    checkS--;
                }
                myArr[0]--;
                break;
            case 'C':
                if (checkArr[1] == myArr[1]) {
                    checkS--;
                }
                myArr[1]--;
                break;
            case 'G':
                if (checkArr[2] == myArr[2]) {
                    checkS--;
                }
                myArr[2]--;
                break;
            case 'T':
                if (checkArr[3] == myArr[3]) {
                    checkS--;
                }
                myArr[3]--;
                break;
        }
    }
    
    private static void Add(char c) {
        switch (c) {
            case 'A':
                myArr[0]++;
                if (checkArr[0] == myArr[0]) {
                    checkS++;
                }
                break;
            case 'C':
                myArr[1]++;
                if (checkArr[1] == myArr[1]) {
                    checkS++;
                }
                break;
            case 'G':
                myArr[2]++;
                if (checkArr[2] == myArr[2]) {
                    checkS++;
                }
                break;
            case 'T':
                myArr[3]++;
                if (checkArr[3] == myArr[3]) {
                    checkS++;
                }
                break;
        }
    }
}
