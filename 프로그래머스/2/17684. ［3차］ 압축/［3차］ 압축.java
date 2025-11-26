import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> answerList = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        
        int idx = 1;
        for (char c = 'A'; c <= 'Z'; c++) {
            String s = String.valueOf(c);
            map.put(s, idx++);            
        }
        
        int start = 0;
        
        while (start < msg.length()) {
            String w = "";
            int end = start + 1;
            
            while (end <= msg.length() && 
                  map.containsKey(msg.substring(start, end))) {
                w = msg.substring(start, end);
                end++;
            }
            
            answerList.add(map.get(w));
            
            if (end <= msg.length()) {
                String wc = msg.substring(start,end);
                map.put(wc, idx++);
            }
            
            start += w.length();
        }
        
        int[] answer = new int[answerList.size()];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}