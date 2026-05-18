import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static int r1, c1, r2, c2;
    static int[][] map;
    static int[][][] dist;
    static boolean[][][] visited;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N][K + 1];
        dist = new int[N][N][K + 1];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken()) - 1;
        c1 = Integer.parseInt(st.nextToken()) - 1;

        st = new StringTokenizer(br.readLine());
        r2 = Integer.parseInt(st.nextToken()) - 1;
        c2 = Integer.parseInt(st.nextToken()) - 1;

        bfs(r1, c1);

        boolean isPossible = false;
        int result = N * N + 1;

        for(int i = 0; i <= K; i++) {
            if(visited[r2][c2][i]) {
                isPossible = true;
                result = Math.min(result, dist[r2][c2][i]);
            }
        }

        System.out.println(isPossible ? result : -1);

    }

    private static void bfs(int r, int c) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{r, c, 0});
        visited[r][c][0] = true;

        while(!deque.isEmpty()) {
            int[] poll = deque.poll();
            int curR = poll[0];
            int curC = poll[1];
            int curW = poll[2];

            for(int i = 0; i < 4; i++) {
                int nr = curR + dr[i];
                int nc = curC + dc[i];

                if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;

                if(map[nr][nc] == 1 && curW < K && !visited[nr][nc][curW + 1]) {
                    deque.add(new int[]{nr, nc, curW + 1});
                    visited[nr][nc][curW + 1] = true;
                    dist[nr][nc][curW + 1] = dist[curR][curC][curW] + 1;
                }

                if(map[nr][nc] == 0 && !visited[nr][nc][curW]) {
                    deque.add(new int[]{nr, nc, curW});
                    visited[nr][nc][curW] = true;
                    dist[nr][nc][curW] = dist[curR][curC][curW] + 1;
                }
            }
        }       
    }
}