import java.util.*;

class Solution {
    
    private List<int[]> column;
    
    public int[][] solution(int n) {
        // 이동경로를 정확하게 알 수 없기 때문에 ArrayList로 선언
        column = new ArrayList<>();
        
        // n = 원판 
        // 1, 2, 3 = 기둥의 순서
        hanoi(n, 1, 2, 3);
        
        // List -> 배열로 변환
        return column.toArray(new int[column.size()][]);
    }
    
    // hanoi 재귀함수 선언
    private void hanoi(int n, int start, int mid, int end) {
        // 종료조건
        if (n == 1) {
            // 원판이 1개 남았다면 목표기둥으로 이동
            column.add(new int[]{start, end});
            return;
        }
        
        // n - 1개일 때, 시작점에서 보조기둥으로 이동
        hanoi(n - 1, start, end, mid);
        
        // 가장 큰 원판을 목표기둥으로 이동
        column.add(new int[]{start, end});
        
        // 나머지 원판들을 보조기둥에서 목표 기둥으로 이동
        hanoi(n - 1, mid, start, end);
    }
}