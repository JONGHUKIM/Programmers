import java.util.*;

class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        Set<Character> seen = new HashSet<>();
        
        for ( char c : my_string.toCharArray()) {
            if (!seen.contains(c)) {
                sb.append(c);
                seen.add(c);
            }
        }
        
        return sb.toString();
    }
}