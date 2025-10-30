// 복습

import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        // 플레이어 수 구하기
        int[] challenger = new int[N + 2];
        for (int stage : stages) {
            challenger[stage] += 1; // 각 스테이지에 있는 플레이어 
        }
        
        // 실패율을 구하기 위한 변수 선언
        HashMap<Integer, Double> fails = new HashMap<>();
        double total = stages.length; // 전체 플레이어 수
        
        for (int i = 1; i <= N; i++) { // 스테이지는 1부터
            if (challenger[i] == 0) { // 실패율 0이라면
                fails.put(i, 0.);
            } else {
                fails.put(i, challenger[i] / total); // 실패율 구하기
                total -= challenger[i]; // 다음 스테이지를 위해 현재 스테이지의 인원 감소
            }
        }
        
        // 출력
        return fails.entrySet().stream().sorted((o1, o2) -> 
        o1.getValue().equals(o2.getValue()) ? Integer.compare(o1.getKey(),
        o2.getKey()) : Double.compare(o2.getValue(),
        o1.getValue())).mapToInt(HashMap.Entry::getKey).toArray();
    }
}