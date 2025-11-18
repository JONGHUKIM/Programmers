import java.util.*;

class Solution {
    
    ArrayList<String> answerList = new ArrayList<>();
    HashMap<String, Integer> map = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        for (int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();   
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }
        
        for (int courseLength : course) {
            
            for (String order : orders) {
                combination("", order, courseLength);
            }
            
            if (!map.isEmpty()) {
                ArrayList<Integer> countList = new ArrayList<>(map.values());
                int max = Collections.max(countList);
                
                if (max > 1) {
                    for (String key : map.keySet()) {
                        if (map.get(key) == max) {
                            answerList.add(key);                            
                        }
                    }
                }
                map.clear();
            }
        }
        
        Collections.sort(answerList);
        
        String[] answer = new String[answerList.size()];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
    
    private void combination(String order, String alpha, int count) {
        if (count == 0) {
            map.put(order, map.getOrDefault(order, 0) + 1);
            return;
        }
        
        for (int i = 0; i < alpha.length(); i++) {
            char now = alpha.charAt(i);
            String nextAlpha = alpha.substring(i + 1);
            combination(order + now, nextAlpha, count - 1);
        }
    }
}