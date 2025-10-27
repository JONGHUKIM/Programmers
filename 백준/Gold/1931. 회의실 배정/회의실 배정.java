import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[][] meetings = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st =
                new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()); 
            int e = Integer.parseInt(st.nextToken());
            meetings[i][0] = s;
            meetings[i][1] = e;
        }
        
        Arrays.sort(meetings, (o1, o2) -> {        
                   if (o1[1] == o2[1]) {
                       return Integer.compare(o1[0], o2[0]);
                   }
                       return Integer.compare(o1[1], o2[1]);
        });
        
        int count = 0;
        int last = -1;
        
        for (int i = 0; i < n; i++) {
            if (meetings[i][0] >= last) {
                count++;
                last = meetings[i][1];
            }            
        }
        System.out.println(count);
        br.close();
    }
}