import java.util.*;

class Solution {
    
    Map<String, Integer> map = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        
        for (int i = 0; i < orders.length; i++) {
            char[] a = orders[i].toCharArray();
            Arrays.sort(a);
            orders[i] = String.valueOf(a);
        }
        
        for (int courseLength : course) {
            
            for (String order : orders) {
                combination("", order, courseLength);
            }
            
            if (!map.isEmpty()) {
                List<Integer> countList = new ArrayList<>(map.values());
                int max = Collections.max(countList);
                
                if (max > 1) {
                    for (String key : map.keySet()) {
                        if (map.get(key) == max) {
                            answer.add(key);
                        }
                    }
                }
                map.clear();
            }
        }
        
        return answer.stream()
                     .sorted()
                     .toArray(String[]::new);
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