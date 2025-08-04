class Solution {
    public double solution(int[] numbers) {
        double answer = 0;
        
        for (int number : numbers) {
            answer += number;
        }
        
        double avg = answer / numbers.length;
        
        return avg;
    }
}