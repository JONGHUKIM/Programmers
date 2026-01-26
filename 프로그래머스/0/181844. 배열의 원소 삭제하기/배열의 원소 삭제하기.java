import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        HashSet<Integer> deleteSet = new HashSet<>();
        for (int x : delete_list) {
            deleteSet.add(x);
        }
        
        for (int num : arr) {
            if (!deleteSet.contains(num)) {
                answer.add(num);
            }
        }
        
        // 스트림
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}