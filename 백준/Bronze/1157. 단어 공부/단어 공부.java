import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine().toUpperCase();
        char answer = '?';
        int[] count = new int[26];
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c - 'A']++;
        }
        
        for (int i = 0; i < 26; i++) {
            if (count[i] > max) {
                max = count[i];
                answer = (char) (i + 'A');
            } else if (count[i] == max) {
                answer = '?';
            }
        }
        
        System.out.println(answer);
    }
}