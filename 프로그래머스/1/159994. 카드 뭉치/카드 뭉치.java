import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        // cards1 큐에 담음
        ArrayDeque<String> cardQue1 = new ArrayDeque<>(Arrays.asList(cards1));
        // cards2 큐에 담음
        ArrayDeque<String> cardQue2 = new ArrayDeque<>(Arrays.asList(cards2));
        // goal 큐에 담음
        ArrayDeque<String> goalQue = new ArrayDeque<>(Arrays.asList(goal));
        
        // goalQue에 문자열이 남아있을 때까지 반복
        while (!goalQue.isEmpty()) {
            // card1과 goal의 맨 위 카드가 맞으면 poll
            // ex) cards1 = "i", goal = "i"
            if (!cardQue1.isEmpty() && cardQue1.peekFirst().equals(goalQue.peekFirst())) {
                cardQue1.pollFirst();
                goalQue.pollFirst();
                
            // card2와 goal의 맨 위 카드가 맞으면 poll
            // ex) cards2 = "want", goal = "want"    
            } else if (!cardQue2.isEmpty() && cardQue2.peekFirst().equals(goalQue.peekFirst())){
                cardQue2.pollFirst();
                goalQue.pollFirst();
            } else {
                // 맞지않으면 break;
                break;
            }            
        }
        
        // goalQue가 비어있으면 Yes 아니면 No return
        return goalQue.isEmpty() ? "Yes" : "No";
    }
}