class Solution {
    public int solution(int[][] sizes) {
        // 가로, 세로 길이 최댓값
        int maxW = 0;
        int maxH = 0;
        
        // sizes만큼 반복
        for (int card[] : sizes) {
            // 가로길이 최대값과 세로길이 최솟값을 구함
            int w = Math.max(card[0], card[1]);
            int h = Math.min(card[0], card[1]);
            
            maxW = Math.max(maxW, w);
            maxH = Math.max(maxH, h);
        }
        
        // 가로길이와 세로길이를 곱해줌 
        int answer = maxW * maxH;
        
        return answer;
        
    }
}