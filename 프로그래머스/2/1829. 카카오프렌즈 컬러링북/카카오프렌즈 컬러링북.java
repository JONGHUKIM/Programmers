class Solution {
    
    // 상하좌우 이동을 위한 좌표 변화량
    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};
    
    // 전역 변수 선언
    // numberOfArea: 총 영역의 개수
    // maxSizeOfOneArea: 가장 큰 영역의 크기
    // m, n: 지도의 행과 열 크기
    // tempSize: 현재 탐색 중인 영역의 크기
    private int numberOfArea, maxSizeOfOneArea, m, n, tempSize;
    
    // 지도 데이터와 방문 여부 배열
    private int[][] map;
    private boolean[][] visited;    
    
    // DFS 탐색 함수
    private void dfs(int x, int y) {
        // 현재 좌표 방문 처리
        visited[x][y] = true;
        
        // 현재 영역의 크기 1 증가
        tempSize++;
        
        // 4방향(상하좌우) 탐색 시작
        for (int i = 0; i < 4; i++) {
            
            // 다음 이동할 좌표 계산
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            // 지도 범위를 벗어나면 무시
            if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
            
            // 이미 방문한 곳이면 무시
            if (visited[nx][ny]) continue;
            
            // 현재 위치와 같은 색깔일 때만 이동해서 계속 탐색
            if (map[x][y] == map[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }
    
    public int[] solution(int m, int n, int[][] picture) {
        // 전역 변수 초기화
        // 이전 테스트 케이스의 값이 남지 않도록 초기화가 필수
        this.m = m;
        this.n = n;
        
        // 원본 그림 데이터를 map에 연결
        map = picture;
        visited = new boolean[m][n];
        
        numberOfArea = 0;
        maxSizeOfOneArea = 0;
        
        // 지도의 모든 칸을 하나씩 확인
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                // 색칠된 부분이고, 아직 방문하지 않았다면
                // 새로운 영역의 시작점으로 판단
                if (map[i][j] != 0 && !visited[i][j]) {
                    
                    // 총 영역 개수 1 증가
                    numberOfArea++;
                    
                    // 이번 영역의 크기를 세기 위해 0으로 초기화
                    tempSize = 0;
                    
                    // 연결된 같은 색깔 영역을 모두 찾음
                    dfs(i, j);
                    
                    // 기존 최대값과 비교하여 더 큰 값으로 갱신
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, tempSize);
                }
            }
        }

        // 결과 배열 생성 및 반환
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}