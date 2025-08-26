import java.util.*;

class Solution {
    public String solution(String s) {
        String[] stArr = s.split(" ");
        
        int[] numbs = new int[stArr.length];
        for (int i = 0; i < stArr.length; i++) {
            numbs[i] = Integer.parseInt(stArr[i]);
        }
        
        Arrays.sort(numbs);
        
        int minNumb = numbs[0];
        int maxNumb = numbs[numbs.length - 1];
        
        return minNumb + " " + maxNumb;
    }
}