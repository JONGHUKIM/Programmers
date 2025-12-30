import java.util.*;
import java.io.*;

public class Main {
    
    // 상하좌우(동서남북) 이동을 위한 좌표 변화량 배열
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    
    // 배추밭 지도 (1: 배추, 0: 빈 땅)
    private static int[][] map;
    // 방문 여부 체크
    private static boolean[][] visited;
    
    // 가로, 세로 크기
    private static int M, N;
    
    // 연결된 배추들을 모두 찾아다니는 함수 DFS 선언
    private static void dfs(int x, int y) {
        // 현재 위치를 방문 처리
        visited[x][y] = true;
        
        // 상하좌우 4방향 탐색
        for (int i = 0; i < 4; i++) {
            // 다음 이동할 좌표 계산
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            // 지도를 벗어나는 경우 무시 (인덱스 에러 방지)
            if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
            
            // 이미 방문한 곳이면 무시
            if (visited[nx][ny]) continue;
            
            // 배추가 없는 땅이면 무시
            if (map[nx][ny] == 0) continue;
            
            // 연결된 배추가 있다면 재귀 호출로 계속 파고듦
            dfs(nx, ny);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        
        BufferedWriter bw = 
            new BufferedWriter(new OutputStreamWriter(System.out));
        
        // 테스트 케이스 개수 T 입력
        int T = Integer.parseInt(br.readLine());
        
        // T만큼 반복 실행
        for (int h = 0; h < T; h++) {
            
            StringTokenizer st = 
                new StringTokenizer(br.readLine());
            
            M = Integer.parseInt(st.nextToken()); // 가로 길이
            N = Integer.parseInt(st.nextToken()); // 세로 길이
            int K = Integer.parseInt(st.nextToken()); // 배추 개수
            
            // 테스트 케이스마다 맵과 방문 기록을 새로 초기화해야 함
            map = new int[M][N];
            visited = new boolean[M][N];
            
            // 배추 위치 입력받아 지도에 표시
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1; // 배추 심기
            }
            
            int answer = 0; // 필요한 지렁이 개수
            
            // 지도 전체를 돌면서 탐색 시작
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    // 배추가 있고, 아직 방문하지 않은 곳이라면 새로운 배추 발견
                    if (map[i][j] == 1 && !visited[i][j]) {
                        answer++; // 지렁이 한 마리 추가
                        dfs(i, j); // 연결된 모든 배추를 방문 처리
                    }
                }
            }
            // 결과 출력
            bw.write(answer + "\n");
        }
        
        // 남은 데이터 출력 및 리소스 해제
        bw.flush();
        bw.close();
        br.close();
    }
}