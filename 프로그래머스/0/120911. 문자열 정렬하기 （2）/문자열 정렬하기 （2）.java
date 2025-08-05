import java.util.*;

class Solution {
    public String solution(String my_string) {
        
        String toLowerCase = my_string.toLowerCase();
        
        char[] charArray = toLowerCase.toCharArray();
        
        Arrays.sort(charArray);
        
        return new String(charArray);
    }
}