// 복습

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for (; n > 0; n /= 10) {
            answer += n % 10;
        }
        
        while(n > 0) {
            answer += n % 10;
            n = n / 10;
        }
        
        return answer;
    }
}