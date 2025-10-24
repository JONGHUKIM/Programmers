// 복습

import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int cameras = 0;
        
        // 진출 지점 기준 오름차순 정렬
        Arrays.sort(routes, (o1, o2) -> Integer.compare(o1[1], o2[1]));
        
        // 마지막으로 설치한 카메라 값
        int last = Integer.MIN_VALUE;
        
        for (int[] route : routes) {
            int start = route[0];
            int end = route[1];
                        
            // 현재 구간이 이미 last(카메라)에 걸리면 스킵
            if (start <= last && last <= end) {
                continue;
            }
            
            // 구간에 안 걸리면, 이 구간의 끝점에 카메라 새로 설치
            last = end;
            cameras++;
        }
        
        return cameras;
    }
}