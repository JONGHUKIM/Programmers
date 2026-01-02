class Solution {
    
    // 최대 방문 가능 던전 수
    private int answer;
    
    // 방문 여부 체크 배열
    private boolean[] visited;
    
    // 모든 던전을 다 도는 경우를 찾았는지 확인하는 플래그
    private boolean clearedAllDungeons;
    
    public int solution(int k, int[][] dungeons) {
        // 결과값 및 방문 배열 초기화
        answer = 0;
        visited = new boolean[dungeons.length]; // 던전 개수만큼 배열 생성
        
        // DFS 탐색 시작 (현재 깊이 0, 현재 피로도 k)
        dfs(0, k, dungeons);
        
        // 탐색이 끝나면 가장 깊이 들어갔던 횟수 반환
        return answer;
    }
    
    private void dfs(int depth, int remain, int[][] dungeons) {
        // 이미 모든 던전을 다 도는 경로를 찾았다면, 더 이상 탐색하지 않고 종료
        // 성능을 위해 추가
        if (clearedAllDungeons) return;
        
        // 모든 던전을 하나씩 시도
        for (int i = 0; i < dungeons.length; i++) {
            
            // 아직 방문하지 않은 던전이고
            // 현재 피로도가 최소 필요 피로도 이상이어야 함
            if (!visited[i] && remain >= dungeons[i][0]) {
                
                // 방문 처리
                visited[i] = true;
                
                // 소모 피로도를 뺀 나머지 피로도 계산
                int nextRemain = remain - dungeons[i][1];
                
                // 깊이를 1 증가시키고 다음 단계로 이동
                dfs(depth + 1, nextRemain, dungeons);
                
                // 다른 경로를 탐색하기 위해 방문 표시를 지움 -> 백트래킹
                visited[i] = false;
            }
        }
        
        // 이번 경로의 깊이가 기존 최고 기록보다 크다면 갱신
        answer = Math.max(answer, depth);
        
        // 만약 모든 던전을 다 돌았다면 플래그를 켬
        if (answer == dungeons.length) clearedAllDungeons = true; 
    }
}