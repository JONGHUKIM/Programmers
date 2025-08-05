import java.util.*;

class Solution {
    public int[] solution(int n) {
        ArrayList<Integer> oddList = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) {
            if (i % 2 == 1) {
                oddList.add(i);
            }
        }
        return oddList.stream().mapToInt(Integer::intValue).toArray();
    }
}