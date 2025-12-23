// BFS

import java.util.*;

class Solution {
    
    private int[] numbers;
    private int target;
    
    private int bfs() {
        
        int count = 0;
        
        ArrayDeque<int[]> que = new ArrayDeque<>();
        
        que.add(new int[]{0, 0});
        
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int index = cur[0];
            int sum = cur[1];
            
            if (index == numbers.length) {
                if (sum == target) {
                    count++;
                }
                continue;
            }
            
            que.add(new int[]{index + 1, sum + numbers[index]});
            que.add(new int[]{index + 1, sum - numbers[index]});
        }
        return count;
    }
    
    public int solution(int[] numbers, int target) {
        
        this.numbers = numbers;
        this.target = target;
        
        return bfs();
    }
}