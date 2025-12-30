import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        
        // 우선 순위 큐 선언 (자동으로 작은 숫자를 정렬 해줌)
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        // 큐에 스코빌을 넣음
        for (int s : scoville) {
            q.add(s);
        }
        
        int answer = 0;
        
        // 가장 맵지 않은 음식이 K보다 작을 때까지 반복
        while (q.peek() < K) {
            // 음식 1개일 때 K를 못 넘기면 return
            if (q.size() < 2) {
                return -1;
            }
            
            // 가장 작은 음식 꺼내기
            int first = q.poll();
            int second = q.poll();
            
            // 새로운 음식 만들기
            int newFood = first + (second * 2);
            
            // 음식 추가
            q.add(newFood);
            answer++;
        }
        
        
        return answer;
    }
}