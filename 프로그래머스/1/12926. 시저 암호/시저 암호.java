class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        
        // 새로운 문자 = ((현재문자 - 시작문자 + n) % 26 + 시작문자)
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == ' ') {
                sb.append(c);
                continue;
            }
            
            if (Character.isLowerCase(c)) {
                char shifted = (char) ((c - 'a' + n) % 26 + 'a');
                sb.append(shifted);
            } else if (Character.isUpperCase(c)) {
                char shifted = (char) ((c - 'A' + n) % 26 + 'A');
                sb.append(shifted);
            }
        }
        
        return sb.toString();
    }
}