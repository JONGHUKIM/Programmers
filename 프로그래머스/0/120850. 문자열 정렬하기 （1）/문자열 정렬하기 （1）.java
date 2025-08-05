import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        
        ArrayList<Integer> numbers = new ArrayList<>();
        
        for (int i = 0; i < my_string.length(); i++) {
            char ch = my_string.charAt(i);
            
            if (Character.isDigit(ch)) {
                numbers.add(ch - '0');
            }
        }
        
        Collections.sort(numbers);
        
        int[] answer = new int[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            answer[i] = numbers.get(i);
        }
        
        return answer;
    }
}