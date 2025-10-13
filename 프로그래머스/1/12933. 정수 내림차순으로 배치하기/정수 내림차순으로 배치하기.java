// 복습

import java.util.*;

class Solution {
    public long solution(long n) {
        String s = String.valueOf(n);
        
        Character[] ch = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            ch[i] = s.charAt(i);
        }
        
        Arrays.sort(ch, Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        
        for (char c : ch) {
            sb.append(c);
        }
        
        return Long.parseLong(sb.toString());
    }
}