import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        ArrayDeque<int[]> bridge = new ArrayDeque<>();
        int sum = 0;
        int time = 0;
        int idx = 0;
        
        while (idx < truck_weights.length || !bridge.isEmpty()) {
            time++;
            
            if (!bridge.isEmpty() && bridge.peekFirst()[1] == time) {
                sum -= bridge.pollFirst()[0];
            }
            
            if (idx < truck_weights.length && sum + truck_weights[idx] <= weight) {
                int w = truck_weights[idx++];
                sum += w;
                bridge.addLast(new int[]{w, time + bridge_length});
            }
        }
        return time;
    }
}