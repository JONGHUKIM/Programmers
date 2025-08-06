import java.util.*;

class Solution {
    public int solution(String s) {
        String[] words = s.split(" ");
        ArrayList<Integer> nums = new ArrayList();
        int answer = 0;
        
        for (String word : words) {
            if (word.equalsIgnoreCase("Z")) {
                if (!nums.isEmpty()) {
                    int lastNum = nums.remove(nums.size() - 1 );
                    answer -= lastNum;
                }
            } else {
                int numb = Integer.parseInt(word);
                nums.add(numb);
                answer += numb;
            }
        }
        
        return answer;
    }
}