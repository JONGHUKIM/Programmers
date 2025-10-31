import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        // 각 스테이지 플레이어 수 구하기
        int[] challenger = new int[N + 2];
        for (int stage : stages) {
            challenger[stage] += 1;
        }
        
        HashMap<Integer, Double> fails = new HashMap<>();
        double total = stages.length; // 전체 사용자
        
        // 실패율 구하기
        for (int i = 1; i <= N; i++) {
            if (challenger[i] == 0) {
                fails.put(i, 0.);
            } else {
                fails.put(i, challenger[i] / total);
                total -= challenger[i];
            }
        }
        return fails.entrySet().stream().sorted((o1, o2) -> 
        o1.getValue().equals(o2.getValue()) ? Integer.compare(o1.getKey(),
        o2.getKey()) : Double.compare(o2.getValue(), 
        o1.getValue())).mapToInt(HashMap.Entry::getKey).toArray();
    }        
}