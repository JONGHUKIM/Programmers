class Solution {
    
    private int[] pos(int num) {
        // 0이면 3행 1열
        if (num == 0) {
            return new int[]{3, 1};
        }
        // 키패드 위치 행,열로 전환
        // 1 ~ 9 -> 0 ~ 8
        int idx = num - 1;
        return new int[]{idx / 3, idx % 3};
    }
    
    private int dist(int[] a, int[] b) {
        // 맨패튼 거리 공식
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
    
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        
        // 왼손과 오른손의 현재 위치 (*, #)
        int[] leftPos = new int[]{3, 0};
        int[] rightPos = new int[]{3, 2};
        
        // 주 손은 오른손으로 설정
        boolean rightPref = hand.equals("right");
        
        for (int num : numbers) {
            // 왼쪽 손가락이 누를 수 있는 키패드
            if (num == 1 || num == 4 || num == 7) {
                sb.append("L");
                // 왼쪽 손 위치 업데이트
                leftPos = pos(num);
              // 오른쪽 손가락이 누를 수 있는 키패드  
            } else if (num == 3 || num == 6 || num == 9) {
                sb.append("R");
                // 오른쪽 손 위치 업데이트
                rightPos = pos(num);
            } else {
                // 타겟 번호 설정
                int[] target = pos(num);
                
                // 왼쪽, 오른쪽 손과의 거리 확인
                int dL = dist(leftPos, target);
                int dR = dist(rightPos, target);
                
                // 왼쪽이 오른쪽보다 더 짧다면
                if (dL < dR) {
                    // L 추가
                    sb.append("L");
                    // 왼쪽 손 위치 업데이트
                    leftPos = target;
                  // 오른쪽이 왼쪽보다 더 짧다면
                } else if (dR < dL) {
                    // R 추가
                    sb.append("R");
                    // 오른쪽 손 위치 업데이트
                    rightPos = target;
                } else {
                    // 주 사용손이 오른손이라면 R추가
                    if (rightPref) {
                        sb.append("R");
                        // 오른쪽 손 위치 업데이트
                        rightPos = target;
                      // 왼손이라면
                    } else {
                        sb.append("L");
                        // 왼쪽 손 위치 업데이트
                        leftPos = target;
                    }
                }
            }
        }        
        return sb.toString();
    }
}