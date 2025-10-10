import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
            new StringTokenizer(br.readLine(), " ");
        
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(br.readLine());
        
        int totalMinute = (a * 60) + b + c;
        
        int hour = (totalMinute / 60) % 24;
        int minute = totalMinute % 60;
        
        System.out.println(hour + " " + minute);
        br.close();
    }
}