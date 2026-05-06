import java.util.*;
import java.io.*;

public class Main {
    static int N, H, M;
    static int[][] map;
    static int[][] resultMap;
    static boolean[][] visited;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        resultMap = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 2) {
                    visited = new boolean[N][N];
                    int result = bfs(i, j);
                    if(result == 0) {
                        resultMap[i][j] = -1;
                    } else {
                        resultMap[i][j] = result;
                    }
                }
                else resultMap[i][j] = 0;
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                System.out.print(resultMap[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static int bfs(int r, int c) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{r, c, 0});
        visited[r][c] = true;

        while(!deque.isEmpty()) {
            int[] poll = deque.poll();
            int curR = poll[0];
            int curC = poll[1];
            int curDist = poll[2];

            for(int i = 0; i < 4; i++) {
                int nr = curR + dr[i];
                int nc = curC + dc[i];

                if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                if(visited[nr][nc] || map[nr][nc] == 1) continue;

                deque.add(new int[]{nr, nc, curDist + 1});
                visited[nr][nc] = true;
                if(map[nr][nc] == 3) {
                    return curDist + 1;
                }
            }
        }

        return 0;
    }
}