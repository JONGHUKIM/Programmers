import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int cameras = 0;
        
        Arrays.sort(routes, (o1, o2) -> Integer.compare(o1[1], o2[1]));
        
        int last = Integer.MIN_VALUE;
        
        for (int[] route : routes) {
            int start = route[0];
            int end = route[1];
            
            if (start <= last && last <= end) {
                continue;
            }
            
            last = end;
            cameras++;
        }
        
        return cameras;
    }
}