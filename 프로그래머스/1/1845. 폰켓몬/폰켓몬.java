import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        
        int max = nums.length / 2;
        
        for (int num : nums) {
            set.add(num);
        }
        
        return Math.min(set.size(), max);
    }
}