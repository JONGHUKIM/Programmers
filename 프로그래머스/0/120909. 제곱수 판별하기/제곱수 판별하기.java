class Solution {
    public int solution(int n) {
        double answer = Math.sqrt(n);
        
        if (answer == (int)Math.sqrt(n)) {
            return 1;
        } else {
            return 2;
        }
    }
}