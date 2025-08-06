import java.util.*;

class Solution {
    public int solution(int[] array, int n) {
        Arrays.sort(array);
        
        int answer = array[0];
        int diff = Math.abs(array[0] - n);
        
        for (int i = 0; i < array.length; i++) {
            int currentDiff = Math.abs(array[i] - n);
            
            if (currentDiff < diff) {
                diff = currentDiff;
                answer = array[i];
            } else if (currentDiff == diff) {
                if ( array[i] < answer) {
                    answer = array[i];
                }
            }
        }
        
        return answer;
    }
}