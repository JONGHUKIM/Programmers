class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for (int i = 1; i <= n; i++) {
            int disvorCount = 0;
            for (int j = 1; j <= n; j++) {
                if (i % j == 0) {
                    disvorCount++;
                }
            }
            if (disvorCount >= 3) {
                answer++;
            }
        }
        
        return answer;
    }
}