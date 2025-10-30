// 복습

import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        // 수포자들의 패턴
        int[][] pattern = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        
        // 수포자들의 점수를 저장할 배열 선언
        int[] scores = new int[3];
        
        // 정답과 패턴이 일치하는지 확인
        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < pattern.length; j++) {
                if (answers[i] == pattern[j][i % pattern[j].length]) {
                    scores[j]++;
                }
            }
        }
        
        // 가장 높은 점수를 찾음
        int maxScore = Arrays.stream(scores).max().getAsInt();
        
        // 수포자 중 가장 높은 점수를 받은 수포자를 리스트에 추가
        ArrayList<Integer> score = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxScore) {
                score.add(i + 1);
            }
        }
        
        // 결과 값 출력
        return score.stream().mapToInt(Integer::intValue).toArray();
        
    }
}