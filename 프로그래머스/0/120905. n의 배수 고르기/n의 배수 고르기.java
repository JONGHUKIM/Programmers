import java.util.*;

class Solution {
    public int[] solution(int n, int[] numlist) {
        ArrayList<Integer> answerList = new ArrayList<>();
        
        for (int num : numlist) {
            if (num % n == 0) {
                answerList.add(num);
            }
        }
        return answerList.stream().mapToInt(i -> i).toArray();
    }
}