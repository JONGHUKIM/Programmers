import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            double days = (100 - progresses[i]) / (double) speeds[i];
            int daysUp = (int) Math.ceil(days);
            
            int j = i + 1;
            for (; j < progresses.length; j++) {
                if (progresses[j] + daysUp * speeds[j] < 100) {
                    break;
                }
            }
            
            answer.add(j - i);
            
            i = j - 1;
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}