import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // 트럭의 무게, 내려오는 시간을 저장하는 큐 배열 선언
        ArrayDeque<int[]> bridge = new ArrayDeque<>();
        int sum = 0; // 총 무게
        int time = 0;
        int idx = 0; // 트럭의 인덱스
        
        // 대기 트럭이 있거나, 다리위에 트럭이 남아 있다면 반복
        while (idx < truck_weights.length || !bridge.isEmpty()) {
            time++; // 1초 증가
            
            // 이번 초에 내릴 트럭이 있다면 먼저 내리기
            if (!bridge.isEmpty() && bridge.peekFirst()[1] == time) {
                sum -= bridge.pollFirst()[0];                
            }
            
            // 대기하는 트럭이 있고, 다리의 무게가 여유가 있으면 트럭 올리기
            if (idx < truck_weights.length && sum + truck_weights[idx] <= weight) {
                int w = truck_weights[idx++];
                sum += w;
                bridge.addLast(new int[]{w, time + bridge_length});
            }
        }
        return time;
    }
}