class Solution {
    public int solution(int[] numbers, int k) {
        int ball = 0;
        int answer = 0;
        
        for (int i = 0; i < k -1; i++) {
            ball = (ball + 2) % numbers.length;
        }
        
        answer = numbers[ball];
        
        return answer;
    }
}