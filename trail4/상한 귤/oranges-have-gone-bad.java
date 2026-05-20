import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static List<int[]> rotten;
    static int[][] map;
    static boolean[][] visited;
    static int[][] resultMap;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        rotten = new ArrayList<>();
        map = new int[N][N];
        resultMap = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    resultMap[i][j] = 0;
                    rotten.add(new int[] {i, j});
                }
                if(map[i][j] == 0) resultMap[i][j] = -1;
            }
        }

        for(int i = 0; i < rotten.size(); i++) {
            visited = new boolean[N][N];
            for(int j = 0; j < rotten.size(); j++) {
                visited[rotten.get(j)[0]][rotten.get(j)[1]] = true;
            }
            bfs(rotten.get(i)[0], rotten.get(i)[1]);
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(resultMap[i][j] == 0) {
                    resultMap[i][j] = -2;
                    for(int k = 0; k < rotten.size(); k++) {
                        if(rotten.get(k)[0] == i && rotten.get(k)[1] == j) resultMap[i][j] = 0;
                    }
                }
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                System.out.print(resultMap[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static void bfs(int r, int c) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{r, c});
        visited[r][c] = true;

        while(!deque.isEmpty()) {
            int[] poll = deque.poll();
            int curR = poll[0];
            int curC = poll[1];

            for(int i = 0; i < 4; i++) {
                int nr = curR + dr[i];
                int nc = curC + dc[i];

                if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if(visited[nr][nc] || resultMap[nr][nc] == -1) continue;

                if(resultMap[nr][nc] == 0) {
                    resultMap[nr][nc] = resultMap[curR][curC] + 1;
                    visited[nr][nc] = true;
                    deque.add(new int[] {nr, nc});
                } else {
                    resultMap[nr][nc] = Math.min(resultMap[curR][curC] + 1, resultMap[nr][nc]);
                    visited[nr][nc] = true;
                    deque.add(new int[] {nr, nc});
                }
            }
        }
    }
}