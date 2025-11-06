import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            // 기능을 개발 하는데 며칠이 걸리는지 날짜 구하기
            double days = (100 - progresses[i]) / (double) speeds[i];
            int daysUp = (int) Math.ceil(days);
            
            // 함꼐 배포할 기능의 index 찾기
            int j = i + 1;
            for (; j < progresses.length; j++) {
                if (progresses[j] + daysUp * speeds[j] < 100) {
                    break;
                }
            }
            
            // 이번에 배포할 기능의 개수를 추가
            answer.add(j - i);
            
            i = j - 1;
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}