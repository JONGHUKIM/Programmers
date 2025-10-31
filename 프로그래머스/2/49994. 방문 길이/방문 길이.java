import java.util.*;

class Solution {
    
    // 좌표를 벗어나는지 확인하는 변수
    private static boolean isValidMove(int nx, int ny) {
        return 0 <= nx && nx < 11 & 0 <= ny && ny < 11;
    }
    
    // Character -> UDLR, int[] -> 이동거리
    private static final HashMap<Character, int[]> location = new HashMap<>();
    
    private static void initLocation() {
        location.put('U', new int[]{0, 1});
        location.put('D', new int[]{0, -1});
        location.put('L', new int[]{1, 0});
        location.put('R', new int[]{-1, 0});
    }
        
    public int solution(String dirs) {
        // 메서드 호출
        initLocation();
        
        // 음수에서 양수로 쉬프트
        int x = 5, y = 5;
        
        // 중복을 체크하기 위해 HashSet 선언
        HashSet<String> answer = new HashSet<>();
        
        // 주어진 명령어로 이동 
        for (int i = 0; i < dirs.length(); i++) {
            int[] offset = location.get(dirs.charAt(i));
            int nx = x + offset[0];
            int ny = y + offset[1];
            
            // 좌표를 벗어났는지 확인
            if (!isValidMove(nx, ny)) {
                continue;
            }
            
            // A -> B, B -> A 이동 방향 계산
            // 각 좌표의 정확한 계산을 위해 공백 추가
            answer.add(x + " " + y + " " + nx + " " + ny);
            answer.add(nx + " " + ny + " " + x + " " + y);
            
            // 좌표 갱신
            x = nx;
            y = ny;
        }
        return answer.size() / 2;
    }
}