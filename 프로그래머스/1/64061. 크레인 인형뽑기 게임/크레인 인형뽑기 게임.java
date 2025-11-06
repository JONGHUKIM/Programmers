import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        // 인형 2개가 만나면 얻는 점수
        int scores = 0;
        // 바구니 역할을 하는 스택
        ArrayDeque<Integer> basket = new ArrayDeque<>();
                
        // 1. 크레인 이동(move) 순서대로 탐색
        for (int move : moves) {
            // moves 배열은 1부터 시작하므로 실제 인덱스는 0부터 보정
            int col = move - 1;
            
            // 2. 해당 열에서 가장 위 인형 탐색
            for (int row = 0; row < board.length; row++) {
                
                // 3. 인형이 존재하면 처리
                if (board[row][col] != 0) {
                    int doll = board[row][col]; // 인형 저장
                    board[row][col] = 0; // 뽑은 위치는 0으로 초기화
                    
                    // 4. 바구니 맨 위 인형과 같으면 제거 후 점수 추가
                    if (!basket.isEmpty() && basket.peek() == doll) { 
                        basket.pop();
                        scores += 2;
                    } else {
                        // 다른 인형인 경우 바구니에 저장
                        basket.push(doll);
                    }
                    break; // 한 번 뽑으면 다음 move로
                }
            }
        }
        
        return scores; // 누적된 점수 반환
    }
}