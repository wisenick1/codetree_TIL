import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[2000001];

        int result = bfs(N);

        System.out.println(result);
    }

    private static int bfs(int r) {
        Deque<int[]> deque = new ArrayDeque<>();
        int cnt = 0;
        deque.add(new int[]{r, cnt});
        visited[r] = true;

        while(!deque.isEmpty()) {
            int[] poll = deque.poll();
            int curR = poll[0];
            int curC = poll[1];

            if(curR == 1) return curC;

            if(curR > 0) {
                int nr = curR - 1;
                if(!visited[nr]) {
                    visited[nr] = true;
                    deque.add(new int[]{nr, curC + 1});
                }
                
                nr = curR + 1;
                if(!visited[nr]) {
                    visited[nr] = true;
                    deque.add(new int[]{nr, curC + 1});
                }

                if(curR % 2 == 0) {
                    nr = curR / 2;
                    if(!visited[nr]) {
                        visited[nr] = true;
                        deque.add(new int[]{nr, curC + 1});
                    }
                }

                if(curR % 3 == 0) {
                    nr = curR / 3;
                    if(!visited[nr]) {
                        visited[nr] = true;
                        deque.add(new int[]{nr, curC + 1});
                    }
                }
            }
        }
        return 0;
    }
}