class Solution {
    public int solution(int[][] sizes) {
        // 모든 명함을 수용하기 위한 가로, 세로의 최대값
        int maxW = 0;
        int maxH = 0;
        
        // 각 명함을 순회
        for (int[] card : sizes) {
            // 명함을 회전시켜
            // 긴 변을 가로, 짧은 변을 세로로 통일
            int w = Math.max(card[0], card[1]);
            int h = Math.min(card[0], card[1]);
            
            // 가로, 세로 각각의 최대값 갱신
            maxW = Math.max(maxW, w);
            maxH = Math.max(maxH, h);
        }
        
        // 최소 지갑 크기 = 가로 최대값 × 세로 최대값
        int answer = maxW * maxH;
        
        return answer;
    }
}
