import java.util.*;

class Solution {
    public String solution(String s) {
        Map<Character, Integer> charCount = new HashMap<>();
        
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        
        ArrayList<Character> uniqueChar = new ArrayList<>();
        
        for (char c : charCount.keySet()) {
            if (charCount.get(c) == 1) {
                uniqueChar.add(c);
            }
        }
        
        Collections.sort(uniqueChar);
        
        StringBuilder sb = new StringBuilder();
        
        for (char c : uniqueChar) {
            sb.append(c);
        }
        
        return sb.toString();
    }
}