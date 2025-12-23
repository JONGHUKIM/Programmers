import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        HashSet<Integer> resSet = new HashSet<>();
        HashSet<Integer> losSet = new HashSet<>();
        
        for (int i : reserve) {
            resSet.add(i);
        }
        
        for (int i : lost) {
            if (resSet.contains(i)) {
                resSet.remove(i);
            } else {
                losSet.add(i);
            }            
        }
        
        int answer = n - losSet.size();
        
        for (int i = 1; i <= n; i++) {
            if (losSet.contains(i)) {
                if (resSet.contains(i - 1)) {
                    resSet.remove(i - 1);
                    answer++;
                } else if(resSet.contains(i + 1)) {
                    resSet.remove(i + 1);
                    answer++;
                }
            }
        }
        
        return answer;
    }
}