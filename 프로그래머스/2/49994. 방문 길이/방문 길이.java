import java.util.*;

class Solution {
    
    // 좌표 평면을 벗어나는지 체크하는 메서드
    private static boolean isValidMove(int nx, int ny) {
        return 0 <= nx && nx < 11 && 0 <= ny && ny < 11;
    }
    
    // 다음 좌표 결정을 위한 해시맵 생성
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
        
        // 배열은 음수 인덱스를 사용을 못하기 때문에 양수로 쉬프트
        int x = 5, y = 5;        
        
        // 중복된 결과를 제외하려면 HashSet이 효과적
        HashSet<String> answer = new HashSet<>();
        
        // 주어진 명령어로 움직이면서 좌표 저장
        for (int i = 0; i < dirs.length(); i++) {
            int[] offset = location.get(dirs.charAt(i));
            int nx = x + offset[0];
            int ny = y + offset[1];            
            
            // 벗어난 좌표는 인정하지 않음 
            if (!isValidMove(nx, ny)) {
                continue;
            }
            
            // A에서 B로 간 경우 B에서 A도 추가(총 경로의 개수는 방향성이 없음)
            // 각 좌표를 정확하게 구분하기 위해 공백을 추가 
            answer.add(x + " " + y + " " + nx + " " + ny);
            answer.add(nx + " " + ny + " " + x + " " + y);
            // 좌표를 이동했으므로 업데이트
            x = nx;
            y = ny;
            
        }
        
        // HashSet의 크기는 2배로 증가하여 2로 나눠줘야 실제 개수가 됨
        return answer.size() / 2;
    }
}