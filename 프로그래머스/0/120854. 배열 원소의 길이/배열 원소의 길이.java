import java.util.*;

class Solution {
    public int[] solution(String[] strlist) {
        ArrayList<Integer> answerList = new ArrayList<>();
        
        for (String str : strlist) {
            int strLength = str.length();
            answerList.add(strLength);
        }
        
        return answerList.stream().mapToInt(i -> i).toArray();
    }
}