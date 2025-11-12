import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayDeque<Integer> answer = new ArrayDeque<>();
        int n = progresses.length;
        
        int[] days = new int[n];
        for (int i = 0; i < n; i++) {
            days[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
        }
        
        int count = 0;
        int maxDay = days[0];
        
        for (int i = 0; i < n; i++) {
            if (days[i] <= maxDay) {
                count++;
            } else {
                answer.add(count);
                count = 1;
                maxDay = days[i];
            }            
        }
        
        answer.add(count);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}