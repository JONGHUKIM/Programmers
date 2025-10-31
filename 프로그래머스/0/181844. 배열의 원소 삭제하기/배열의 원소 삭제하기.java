import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        // 중복된 배열 제거를 위한 HashSet 선언
        HashSet<Integer> deleteSet = new HashSet<>();
        for (int x : delete_list) {
            deleteSet.add(x);
        }
        
        for (int num : arr) {
            if (!deleteSet.contains(num)) {
                answer.add(num);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}