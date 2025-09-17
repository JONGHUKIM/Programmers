import java.util.*;
import java.io.*;

// 선택정렬
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine();
        int[] a = new int[s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            a[i] = Integer.parseInt(s.substring(i, i + 1));
        }
        for (int i = 0; i < s.length(); i++) {
            int max = i;
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

// String s = br.readLine();
// char[] c = s.toCharArray();

// StringBuilder sb = new StringBuilder();
// Arrays.sort(c);
// for (int i = c.length - 1; i >= 0; i--) {
//    sb.append(c[i]);
// }

// System.out.println(sb.toString());
// br.close();