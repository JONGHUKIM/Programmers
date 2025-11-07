import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        
        for (int i = 0; i < progresses.length; i++) {
            // 날짜를 구하기
            // ex (100 - 93) / 1 = 7
            double days = (100 - progresses[i]) / (double) speeds[i];            
            int daysUp = (int) Math.ceil(days);
            
            // 같이 배포 될 기능 구하기
            int j = i + 1;
            for (; j < progresses.length; j++) {
                // ex1) 30 + 7 * 30 = 240 배포 확정
                // ex2) 55 + 7 * 5 = 90 배포 실패
                if (progresses[j] + daysUp * speeds[j] < 100) {
                    break;
                }
            }
            
            // 배포할 기능을 추가 
            // ex) j = 2, i = 0 --> 2 - 0 = 2
            answer.add(j - i);
            
            // ex) j = 2 --> 2 - 1 = 1
            // i = 1 다시 1부터 루프
            i = j - 1;
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}