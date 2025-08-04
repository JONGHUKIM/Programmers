class Solution {
    public int solution(int n) {
        
        int answer = 0;
        
        for (int i = 2; i <= n; i+=2) {
            if (0 < i && i <= 1000) {
                answer += i;
            }
        }
        return answer;
    }
    
    
}