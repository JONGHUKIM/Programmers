import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
            new StringTokenizer(br.readLine());
        
        int y = Integer.parseInt(st.nextToken());
        
        int year = y - 543;
        
        System.out.println(year);
        br.close();
    }
}