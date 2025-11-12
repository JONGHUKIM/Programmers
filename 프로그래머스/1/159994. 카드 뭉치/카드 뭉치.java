import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        ArrayDeque<String> cardQue1 = new ArrayDeque<>(Arrays.asList(cards1));
        ArrayDeque<String> cardQue2 = new ArrayDeque<>(Arrays.asList(cards2));
        ArrayDeque<String> goalQue = new ArrayDeque<>(Arrays.asList(goal));
        
        while (!goalQue.isEmpty()) {
            if (!cardQue1.isEmpty() && cardQue1.peekFirst().equals(goalQue.peekFirst())) {
                cardQue1.pollFirst();
                goalQue.pollFirst();
            } else if (!cardQue2.isEmpty() && cardQue2.peekFirst().equals(goalQue.peekFirst())) {
                cardQue2.pollFirst();
                goalQue.pollFirst();
            } else {
                break;
            }
        }
        
        return goalQue.isEmpty() ? "Yes" : "No";
    }
}