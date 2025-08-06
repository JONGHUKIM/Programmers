class Solution {
    public int solution(int n) {
        int i = 1;
        long factorial = 1;
        
        while (true) {
            factorial *= i;
            
            if (factorial > n) {
                return i - 1;
            } else if (factorial == n) {
                return i;
            }
            i++;
        }
    }
}