import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        // 실패율을 구하는 코드
        // 실패율 : 스테이지에 도달 했으나 클리어하지 못한 플레이어 / 스테이지에 도달한 플레이어
        // 스테이지 개수 N, 멈춰있는 stages, 실패율이 높은 스테이지부터 내림차순 스테이지 번호 리턴
        // N + 1 마지막까지 클리어 한 사용자
        // 실패율이 같은 스테이지가 있따면 작은 번호의 스테이지가 먼저 출력
        // 스테이지에 도달한 유저가 없으면 실패율은 0
        
        // 마지막까지 클리어한 사용자가 N + 1이기 때문에 배열은 N + 2만큼의 공간이 필요함
        // 인덱스 0을 안쓰지만 득이 더 많음 
        // 값 자체를 인덱스 값으로 활용할 수 있음
        int[] player = new int[N + 2];
        for (int stage : stages) {
            player[stage] += 1;
        }
        
        // 스테이지별 실패한 사용자 수 계산을 위한 변수
        HashMap<Integer, Double> fails = new HashMap<>();
        double total = stages.length;
        
        // 실패한 사용자 수 계산
        for (int i = 1; i <= N; i++) { // 스테이지는 1부터
            if (player[i] == 0) {
                fails.put(i, 0.);
            } else {
                fails.put(i, player[i] / total); // 실패율 계산
                total -= player[i]; // 다음 스테이지 실패율을 위해 현재 스테이지의 사용자 수를 뺌                
            }
        }
        // 실패율이 높은 스테이지부터 내림차순 (실패율이 같으면 스테이지 번호 낮은 순)
        return fails.entrySet().stream().sorted((o1, o2) -> 
        o1.getValue().equals(o2.getValue()) ? Integer.compare(o1.getKey(), 
        o2.getKey()) : Double.compare(o2.getValue(), 
        o1.getValue())).mapToInt(HashMap.Entry::getKey).toArray();                    
    }
}