import java.util.*;

class Solution {
    public int[] solution(int[] numbers, String direction) {
        int[] answer = new int[numbers.length];
        
        if (direction.equals("right")) {
            int lastElement = numbers[numbers.length - 1];
            
            for (int i = numbers.length -1; i > 0; i--) {
                answer[i] = numbers[i - 1];
            }
            
            answer[0] = lastElement;
        } else if (direction.equals("left")) {
            int firstElement = numbers[0];
            
            for (int i = 0; i < numbers.length -1; i++) {
                answer[i] = numbers[i + 1];
            }
            
            answer[numbers.length -1] = firstElement;
        }
        
        return answer;
    }
}