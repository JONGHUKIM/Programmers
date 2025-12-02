import java.util.*;

class Solution {
    public int solution(int[] nums) {
        // 폰켓몬을 담을 hashSet 선언
        // 중복되는 폰켓몬을 제외
        HashSet<Integer> hash = new HashSet<>();
        
        // 가져갈 수 있는 폰켓몬 
        int max = nums.length / 2;
        
        // hash에 값을 채우면서 중복 제거
        for (int num : nums) {
            hash.add(num);
        }
        
        // 종류 수 vs 가져갈 수 있는 수 중 작은 값
        return Math.min(hash.size(), max);
    }
}