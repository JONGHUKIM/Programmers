// 복습

import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String[] stArr = s.split(" ");
        
        int[] numbs = new int[stArr.length];
        for (int i = 0; i < stArr.length; i++) {
            numbs[i] = Integer.parseInt(stArr[i]);
        }
        
        Arrays.sort(numbs);
        
        int minNumbs = numbs[0];
        int maxNumbs = numbs[stArr.length - 1];
        
        return minNumbs + " " + maxNumbs;
    }
}