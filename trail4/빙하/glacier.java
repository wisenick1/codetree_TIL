import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int meltedCnt;
    static int[][] map;
    static boolean[][] visited;
    static boolean[][] isMeltingWater;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;

        while(!checkAllMelt()) {
            meltedCnt = 0;
            isMeltingWater = new boolean[N][M];
            visited = new boolean[N][M];
            isMeltingWater[0][0] = true;
            checkWaterbfs(0, 0);

            visited = new boolean[N][M];
            for(int i = 1; i < N - 1; i++) {
                for(int j = 1; j < M - 1; j++) {
                    if(!visited[i][j] && map[i][j] == 1) bfs(i, j);
                }
            }
            time++;
        }

        System.out.println(time + " " + meltedCnt);

    }

    private static boolean checkAllMelt() {
        for(int i = 1; i < N - 1; i++) {
            for(int j = 1; j < M - 1; j++) {
                if(map[i][j] == 1) return false;
            }
        }
        return true;
    }

    private static void checkWaterbfs(int r, int c) {
        Deque<int[]> deque = new ArrayDeque<>();
        visited[r][c] = true;
        deque.add(new int[]{r, c});

        while(!deque.isEmpty()) {
            int[] poll = deque.poll();
            int curR = poll[0];
            int curC = poll[1];

            for(int i = 0; i < 4; i++) {
                int nr = curR + dr[i];
                int nc = curC + dc[i];

                if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                if(visited[nr][nc] || map[nr][nc] == 1) continue;
                if(map[nr][nc] == 0) {
                    deque.add(new int[]{nr, nc});
                    isMeltingWater[nr][nc] = true;
                    visited[nr][nc] = true;
                }
            }
        }
    }

    private static void bfs(int r, int c) {
        Deque<int[]> deque = new ArrayDeque<>();
        visited[r][c] = true;
        deque.add(new int[]{r, c});

        while(!deque.isEmpty()) {
            int[] poll = deque.poll();
            int curR = poll[0];
            int curC = poll[1];

            for(int i = 0; i < 4; i++) {
                int nr = curR + dr[i];
                int nc = curC + dc[i];

                if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                if(visited[nr][nc]) continue;
                if(map[nr][nc] == 0 && isMeltingWater[nr][nc]) {
                    map[curR][curC] = 0;
                    meltedCnt++;
                    break;
                }
                if(map[nr][nc] == 1) {
                    deque.add(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }
    }
}