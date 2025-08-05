class Solution {
    public int solution(int n) {
        
        int answer = 0;
        
        // while 문
        
        // while (0 < n) {
            // answer += n % 10;
            // n = n / 10;
        // }
        
        // for 문
        
        for (; 0 < n; n /= 10) {
            answer += n % 10;
        }
        
        return answer;
    }
}