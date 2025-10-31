class Solution {
    public double solution(int[] numbers) {
        double avg = 0.0;
        
        for (int num : numbers) {
            avg += num;
        }
        
        double answer = avg / numbers.length;
        
        return answer;
    }
}