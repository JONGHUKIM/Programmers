class Solution {
    public String solution(String s) {
        String[] words = s.toLowerCase().split(" ");
        StringBuilder sb = new StringBuilder();
        
        for (String word : words) {
            if (word.length() > 0) {
                String firstChar = word.substring(0, 1);
                String rest = word.substring(1);
                
                sb.append(firstChar.toUpperCase()).append(rest).append(" ");
            } else {
                sb.append(" ");
            }
        }
        if (s.endsWith(" ")) {
            return sb.toString();
        } else {
            return sb.toString().trim();
        }
    }
}