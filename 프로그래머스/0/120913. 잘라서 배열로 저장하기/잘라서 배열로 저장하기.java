import java.util.*;

class Solution {
    public String[] solution(String my_str, int n) {
        ArrayList<String> result = new ArrayList<>();
        
        for (int i = 0; i < my_str.length(); i += n) {
            int endIndex = Math.min(i + n, my_str.length());
            result.add(my_str.substring(i, endIndex));
        }
        
        return result.toArray(new String[result.size()]);
    }
}