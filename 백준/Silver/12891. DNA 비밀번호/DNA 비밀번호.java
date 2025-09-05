import java.io.*;
import java.util.*;

public class Main {
    static int idx(char c) { // A,C,G,T -> 0,1,2,3
        return (c=='A') ? 0 : (c=='C') ? 1 : (c=='G') ? 2 : 3;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        char[] a = br.readLine().toCharArray();

        int[] need = new int[4];
        st = new StringTokenizer(br.readLine());
        int missing = 0;
        for (int i = 0; i < 4; i++) {
            need[i] = Integer.parseInt(st.nextToken());
            missing += need[i];
        }

        // 초기 윈도우 [0, p-1]
        for (int i = 0; i < p; i++) {
            int t = idx(a[i]);
            if (need[t] > 0) missing--;
            need[t]--;
        }

        int result = (missing == 0) ? 1 : 0;

        // 슬라이딩
        for (int i = p; i < s; i++) {
            int out = idx(a[i - p]);
            if (++need[out] > 0) missing++;   // 빠져나가며 부족해지면 증가

            int in = idx(a[i]);
            if (need[in] > 0) missing--;      // 들어오며 채워지면 감소
            need[in]--;

            if (missing == 0) result++;
        }

        System.out.println(result);
        br.close();
    }
}
