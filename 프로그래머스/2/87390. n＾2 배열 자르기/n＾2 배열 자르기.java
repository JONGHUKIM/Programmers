class Solution {
    public int[] solution(int n, long left, long right) {
        // 구하려는 배열 길이 구하기
        int len = (int)(right - left + 1);
        int[] answer = new int[len];
        
        // 인덱스 선언
        int idx = 0;
        // 배열의 왼쪽부터 오른쪽까지 모든 인덱스 탐색
        for (long i = left; i <= right; i++) {
            int row = (int)(i / n); // 2차원 행으로 변환
            int col = (int)(i % n); // 2차원 열로 변환
            
            // 2차원 배열의 규칙, 각 위치의 값은 max(열, 행) + 1
            // idx++ -> 현재 인덱스에 값을 저장 후 다음 위치로 이동
            answer[idx++] = (int)(Math.max(row, col) + 1);
        }
        
        return answer;
    }
}