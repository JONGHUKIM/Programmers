class Solution {
    public double solution(int[] numbers) {
        double answer = 0;
        
        for (int numb : numbers) {
            answer += numb;
        }
        
        double avg = answer / numbers.length;
        
        return avg;
    }
}