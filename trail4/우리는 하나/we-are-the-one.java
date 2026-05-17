import java.util.*;
import java.io.*;

public class Main {
    static int N, K, U, D;
    static int[][] map;
    static boolean[][] visited;
    static List<Integer> choosed = new ArrayList<>();
    static int result;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        result = 0;
        chooseCity(0, 0);

        System.out.println(result);

    }

    
    private static void chooseCity(int start, int cnt) {
        if(cnt == K) {
            visited = new boolean[N][N];
            for(int i = 0; i < choosed.size(); i++) {
                int m = choosed.get(i);
                bfs(m / N, m % N);
            }

            int count = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(visited[i][j]) count++;
                }
            }

            result = Math.max(count, result);
            return;
        }

        for(int i = start; i < N * N; i++) {
            choosed.add(i);
            chooseCity(start + 1, cnt + 1);
            choosed.remove(choosed.size() - 1);
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

                if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                if(visited[nr][nc]) continue;
                if(Math.abs(map[curR][curC] - map[nr][nc]) < U || Math.abs(map[curR][curC] - map[nr][nc]) > D) continue;

                deque.add(new int[]{nr, nc});
                visited[nr][nc] = true;

            }
        }
    }
}