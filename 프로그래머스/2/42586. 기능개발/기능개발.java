import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // 큐 선언
        ArrayDeque<Integer> answer = new ArrayDeque<>();
        int n = progresses.length;
        
        int[] days = new int[n];
        // 배포 될 날짜 구하기 ex) 100 - 93 / 1 = 7일
        for (int i = 0; i < n; i++) {
            days[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
        }
        
        // 배포 될 작업의 수 카운트
        int count = 0; 
        // 현재 배포 묶음이 나가기 위해 기다려야 하는 최대 일수
        int maxDay = days[0];
        
        for (int i = 0; i < n; i++) {
            // 현재 기능의 완료일(days[i])이 maxDay 이하면 같은 날 같이 배포 가능
            // 초과하면 지금까지 cnt를 결과에 넣고, 새 묶음을 시작
            if (days[i] <= maxDay) {
                // 같은 배포 날짜에 추가
                count++;
            } else {
                // 이전 같은 날짜에 배포 가능한 기능 저장
                answer.add(count);
                // 새 기능 묶음 1로 시작
                count = 1;
                // 새 묶음의 기준일 갱신
                maxDay = days[i];
            }
        }
        
        // 마지막 배포 묶음 추가
        answer.add(count);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}