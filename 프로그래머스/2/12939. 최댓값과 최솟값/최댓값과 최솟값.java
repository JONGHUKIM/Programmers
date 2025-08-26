import java.util.*;

class Solution {
    public String solution(String s) {
        String[] sArr = s.split(" ");
        int[] nums = new int[sArr.length];
        
        for (int i = 0; i < sArr.length; i++) {
            nums[i] = Integer.parseInt(sArr[i]);
        }
        
        Arrays.sort(nums);
        
        int min = nums[0];
        int max = nums[nums.length - 1];
        
        return min + " " + max;
    }
}