public class Solution {
    public int solution(int n) {
        int sum = 0;
        String s = n + "";
        char[] c = s.toCharArray();
        
        for (int i = 0; i < c.length; i++) {
            sum += c[i] - '0';
        }
        
        return sum;
    }
}