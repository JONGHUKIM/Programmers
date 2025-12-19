import java.util.*;
import java.io.*;

public class Main {

    // 상, 하, 좌, 우 이동을 위한 방향 배열
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    // 미로의 크기
    private static int n, m;

    // 방문 여부 체크 배열
    private static boolean[][] visited;

    // 미로 정보
    // 1 = 이동 가능, 0 = 이동 불가(벽)
    private static int[][] graph;

    // BFS 구현
    private static int bfs() {

        // BFS 탐색을 위한 큐
        // 큐에는 {x좌표, y좌표, 현재까지 이동한 거리}를 저장
        ArrayDeque<int[]> que = new ArrayDeque<>();

        // 시작점 방문 처리
        visited[0][0] = true;

        // 시작점 (0,0)에서 출발, 시작 칸도 포함하므로 거리 = 1
        que.add(new int[]{0, 0, 1});

        // 큐가 빌 때까지 반복
        while (!que.isEmpty()) {

            // 현재 위치와 거리 정보 꺼내기
            int[] cur = que.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];

            // 도착 지점에 도달한 경우
            // BFS 특성상 처음 도달한 거리가 최단 거리
            if (x == n - 1 && y == m - 1) {
                return dist;
            }

            // 상, 하, 좌, 우 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 미로 범위를 벗어나는 경우는 무시
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }

                // 벽인 경우 이동 불가
                if (graph[nx][ny] == 0) {
                    continue;
                }

                // 이미 방문한 칸은 다시 방문하지 않음
                if (visited[nx][ny]) {
                    continue;
                }

                // 이동 가능한 새로운 칸이므로 방문 처리
                visited[nx][ny] = true;

                // 다음 칸과 거리 +1을 큐에 추가
                que.add(new int[]{nx, ny, dist + 1});
            }
        }

        // 문제 조건상 도착 가능이 보장되지만 안전하게 도착하지 못한 경우 -1 반환
        return -1;
    }

    public static void main(String[] args) throws IOException {

        // 입력을 빠르게 받기 위한 BufferedReader
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        // 출력용 BufferedWriter
        BufferedWriter bw =
            new BufferedWriter(new OutputStreamWriter(System.out));

        // 첫 줄: n(행), m(열)
        StringTokenizer st =
            new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 방문 배열과 미로 배열 초기화
        visited = new boolean[n][m];
        graph = new int[n][m];

        // 미로 입력 받기
        // ex -> 101111 처럼 붙어서 들어오므로 문자열로 받아 char로 처리
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = line.charAt(j) - '0';
            }
        }

        // BFS 실행 결과 출력
        bw.write(String.valueOf(bfs()));

        bw.flush();
        bw.close();
        br.close();
    }
}
