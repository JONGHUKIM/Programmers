import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 여벌 체육복이 있는 학생 선언
        HashSet<Integer> resSet = new HashSet<>();
        // 도난을 당한 학생 선언
        HashSet<Integer> lostSet = new HashSet<>();
        
        for (int i : reserve) {
            resSet.add(i);
        }
        
        for (int i : lost) {
            
            // 여벌 학생이 도난을 당한 경우
            // 빌려 줄 수가 없으므로 resSet에서 제외
            if (resSet.contains(i)) {
                resSet.remove(i);                
            } else {
                // 여벌 X 도난 당한 학생
                lostSet.add(i);
            }
        }
        
        // 전체 학생 중 도난당하지 않았거나 자가 수습한 학생 수
        int answer = n - lostSet.size();
        
        // 그리디 방식 -> 1번 학생부터 순서대로 확인
        // Set 자체는 순서가 없지만 1~n까지 반복문을 돌려 순서를 강제함
        for (int i = 1; i <= n; i++) {
            if (lostSet.contains(i)) {
                // 앞번호에게 먼저 빌려봄
                if (resSet.contains(i - 1)) {
                    resSet.remove(i - 1);
                    answer++; // 빌림 +1
                    // 뒷번호에게 빌려봄
                } else if (resSet.contains(i + 1)) {
                    resSet.remove(i + 1);
                    answer++; // 빌림 +1
                }
            }
        }
        return answer;
    }
}