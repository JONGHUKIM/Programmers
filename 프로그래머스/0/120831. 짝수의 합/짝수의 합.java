class Solution {
    public int solution(int n) {
        
        int answer = 0;
        
        for (int i = 1; i <= n; i++) {
            if (0 < i && i <= 1000 && i % 2 == 0) {
                answer += i;
            }
        }
        return answer;
    }
}