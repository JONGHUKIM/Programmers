import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x1 = Long.parseLong(st.nextToken());
            long y1 = Long.parseLong(st.nextToken());
            long r1 = Long.parseLong(st.nextToken());
            long x2 = Long.parseLong(st.nextToken());
            long y2 = Long.parseLong(st.nextToken());
            long r2 = Long.parseLong(st.nextToken());

            long dx = x1 - x2;
            long dy = y1 - y2;

            long d2 = dx * dx + dy * dy;          // 중심거리^2
            long sum = r1 + r2;
            long sum2 = sum * sum;                // (r1+r2)^2
            long diff = Math.abs(r1 - r2);
            long diff2 = diff * diff;             // |r1-r2|^2

            int ans;
            if (d2 == 0) { // 중심이 같음
                ans = (r1 == r2) ? -1 : 0;
            } else if (d2 > sum2) { // 너무 멀다
                ans = 0;
            } else if (d2 < diff2) { // 한 원 안에 완전히 포함 (안 만남)
                ans = 0;
            } else if (d2 == sum2 || d2 == diff2) { // 접함(외접/내접)
                ans = 1;
            } else { // 두 점에서 만남
                ans = 2;
            }

            sb.append(ans).append('\n');
        }

        System.out.print(sb.toString());
    }
}
