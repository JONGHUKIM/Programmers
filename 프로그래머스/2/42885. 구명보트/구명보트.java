import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        // 사람들을 먼저 무게 순으로 정렬
        Arrays.sort(people);
        
        int boat = 0;
        // 가벼운 사람의 포인터
        int left = 0;
        // 무거운 사람의 포인터
        int right = people.length - 1;
        
        // 두 포인터가 교차할 때까지
        while (left <= right) {
            // 보트는 무조건 한 개이상 사용
            boat++;
            
            // 가벼운 사람과 무거운 사람이 같이 탈 수 있다면
            if (people[left] + people[right] <= limit) {
                // 가벼운 사람도 탑승
                left++;
            }
            // 무거운 사람은 무조건 탑승
            right--;
        }
        
        return boat;
    }
}