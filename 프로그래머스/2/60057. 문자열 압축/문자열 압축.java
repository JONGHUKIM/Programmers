class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        // aa
        for (int i = 1; i <= s.length() / 2; i++) {
            int len = s.length();
            int cur = 0;
            
            while (cur + i <= s.length()) {
                String unit = s.substring(cur, cur + i);
                
                int cnt = 0;
                
                cur += i;
                
                while (cur + i <= s.length()) {
                    if (unit.equals(s.substring(cur, cur + i))) {
                        cnt++;
                        cur += i;
                    } else {
                        break;
                    }
                }
                
                if (cnt > 0) {
                    len -= i * cnt;
                    
                    if (cnt < 9) len += 1;
                    else if (cnt < 99) len += 2;
                    else if (cnt < 999) len += 3;
                    else len += 4;
                }
            }            
            answer = Math.min(answer, len);
        }        
        return answer;
    }
}