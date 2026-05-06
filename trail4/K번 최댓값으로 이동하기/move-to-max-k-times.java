import java.util.*;
import java.io.*;

public class Main {
    static class Point implements Comparable<Point> {
        int r, c, value;

        public Point(int r, int c, int value) {
            this.r = r;
            this.c = c;
            this.value = value;
        }

        @Override
        public int compareTo(Point p) {
            if(value != p.value) return Integer.compare(p.value, value);
            if(r != p.r) return Integer.compare(r, p.r);
            return Integer.compare(c, p.c);
        }
    }

    static int N, K;
    static int[][] map;
    static PriorityQueue<Point> pq;
    static boolean[][] visited;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        int startR = Integer.parseInt(st.nextToken()) - 1;
        int startC = Integer.parseInt(st.nextToken()) - 1;

        while(K-- > 0) {
            visited = new boolean[N][N];
            pq = new PriorityQueue<>();
            checkbfs(startR, startC);

            if(pq.isEmpty()) break;

            Point p = pq.poll();
            startR = p.r;
            startC = p.c;
        }

        System.out.println((startR + 1) + " " + (startC + 1));
        

    }

    private static void checkbfs(int r, int c) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[] {r, c});
        visited[r][c] = true;
        int value = map[r][c];

        while(!deque.isEmpty()) {
            int[] poll = deque.poll();
            int curR = poll[0];
            int curC = poll[1];
            
            for(int i = 0; i < 4; i++) {
                int nr = curR + dr[i];
                int nc = curC + dc[i];

                if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                if(map[nr][nc] >= value || visited[nr][nc]) continue;

                deque.add(new int[]{nr, nc});
                visited[nr][nc] = true;
                pq.add(new Point(nr, nc, map[nr][nc]));
            }
        }
    }
}