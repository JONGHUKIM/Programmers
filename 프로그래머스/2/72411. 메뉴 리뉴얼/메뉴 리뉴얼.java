import java.util.*;

class Solution {
    
    Map<String, Integer> map = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
                
        // 알파벳순으로 주문들 정렬
        for (int i = 0; i < orders.length; i++) {
            char[] a = orders[i].toCharArray();
            Arrays.sort(a);
            orders[i] = String.valueOf(a);
        }
        
        ArrayList<String> answerList = new ArrayList<>();
        
        // 코스 요리 메뉴 개수 하나씩 돌면서 처리
        for (int courseLength : course) {
            
            // 모든 손님 주문을 보면서 courseLength짜리 조합을 만듦
            for (String order : orders) {
                // 조합을 만드는 재귀 함수
                combination("", order, courseLength);
            }
            
            // 조합이 완성되면
            if (!map.isEmpty()) {
                // Map에 저장된 숫자들만 불러옴 
                // ex -> AC = 5, AB = 5 values값만 
                ArrayList<Integer> countList = new ArrayList<>(map.values());
                int max = Collections.max(countList);
                
                // 최소 2명 이상의 손님에게서 주문된 구성만 찾기
                if (max > 1) {
                    for (String key : map.keySet()) {
                        if (map.get(key) == max) {
                            answerList.add(key);
                        }
                    }
                }
                // 다음 코스 길이(3개)를 셀 때는 새로 시작해야 함
                map.clear();
            }
        }
        
        return answerList.stream()
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