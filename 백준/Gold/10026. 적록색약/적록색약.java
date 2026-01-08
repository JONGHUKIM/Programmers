import java.util.*;
import java.io.*;

public class Main {
    
    // 상하 좌우 이동을 위한 배열 선언
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    
    // R,G,B 형식으로 맵이 채워짐
    private static char[][] map;
    // 방문했는지 확인하는 boolean 타입 선언
    private static boolean[][] visited;
    private static int n;
    
    // dfs 선언
    private static void dfs(int x, int y, boolean cb) {
        // 현재 방문 처리
        visited[x][y] = true;
        // 현재 칸의 색(비교 기준)
        char cur = map[x][y];
        
        // 상하좌우 탐색
        for (int i = 0; i < 4; i++) {
            // 다음 위치
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            // 지도를 벗어나는 경우
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
            
            // 이미 방문한 곳이라면
            if (visited[nx][ny]) continue;
            
            // 다음 색의 위치
            char next = map[nx][ny];
            
            if (!cb) {
                // 색약자가 아닌 경우 (현재 컬러와 다음 컬러가 같은 경우)
                if (next == cur) {
                    dfs(nx, ny, cb);
                }
            } else {
                // 색약자인 경우 현재 컬러가 B인 경우 다음 컬러도 B
                if (cur == 'B') {
                    if (next == 'B') {
                        dfs(nx, ny, cb);
                    }
                } else { // 현재 컬러가 B가 아닌 R, G인 경우
                    if (next == 'R' || next == 'G') {
                        dfs(nx, ny, cb);
                    }
                } 
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =
            new BufferedWriter(new OutputStreamWriter(System.out));
        
        n = Integer.parseInt(br.readLine());
        // 색약인지 아닌지 확인하는 변수, 기본 값은 정상
        boolean isColorBlind = false;
        
        // 맵과 방문 초기화
        map = new char[n][n];
        visited = new boolean[n][n];
        
        int nc = 0; // 정상인 사람 수 (normal count)
        int bc = 0; // 색약 사람 수 (blind count)
        
        // 맵을 채움
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        
        // 정상인이 볼 수 있는 그룹 dfs
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, isColorBlind);
                    nc++;
                }
            }
        }
        
        // 정상인의 그룹을 확인 했으니 색약자 탐색을 위해 초기화
        visited = new boolean[n][n];
        isColorBlind = true;
        
        // 색약자가 볼 수 있는 그룹 dfs
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, isColorBlind);
                    bc++;
                }
            }
        }
        
        bw.write(nc + " " + bc);
        bw.flush();
        bw.close();
        br.close();
    }
}