import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        // 수포자 패턴
        int[][] pattern = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        
        // 수포자들의 정답을 확인 할 배열
        int[] scores = new int[3];
        
        // 수포자들과 정답이 맞는지 확인
        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < pattern.length; j++) {
                if (answers[i] == pattern[j][i % pattern[j].length]) {
                    scores[j]++;
                }
            }
        }
        
        // 가장 높은 점수 저장
        int maxScore = Arrays.stream(scores).max().getAsInt();
        
        // 가장 높은 점수를 가진 수포자의 번호를 찾아 리스트에 저장
        ArrayList<Integer> answer = new ArrayList<>();                
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxScore) {
                answer.add(i + 1); // 수포자의 인덱스는 1, 2, 3
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}