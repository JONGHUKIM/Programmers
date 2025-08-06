import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
        int[] copyEmergency = Arrays.copyOf(emergency, emergency.length);
        Arrays.sort(copyEmergency);
        
        for (int i = 0; i < emergency.length; i++) {
            for (int j = 0; j < copyEmergency.length; j++) {
                if (emergency[i] == copyEmergency[j]) {
                    answer[i] = emergency.length - j;
                    break;
                }
            }
        }
        
        return answer;
    }
}