import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] blocks = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            blocks[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int s1 = Integer.parseInt(st.nextToken());
        int e1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int s2 = Integer.parseInt(st.nextToken());
        int e2 = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        int[] temp = new int[n];

        for(int i = s1 - 1; i < e1; i++) {
            blocks[i] = 0;
        }

        int idx = 0;
        for(int i = 0; i < n; i++) {
            if(blocks[i] > 0) {
                temp[idx++] = blocks[i];
            }
        }

        for(int i = 0; i < n; i++) {
            blocks[i] = temp[i];
            temp[i] = 0;
        }

        for(int i = s2 - 1; i < e2; i++) {
            blocks[i] = 0;
        }

        idx = 0;
        for(int i = 0; i < n; i++) {
            if(blocks[i] > 0) {
                temp[idx++] = blocks[i];
            }
        }

        
        for(int i = 0; i < n; i++) {
            blocks[i] = temp[i];
            temp[i] = 0;
        }

        int cnt = 0;
        for(int k : blocks) {
            if(k > 0) cnt++;
        }

        System.out.println(cnt);

        for(int i = 0; i < n; i++) {
            if(blocks[i] > 0) {
                System.out.println(blocks[i]);
            }
        }

    }
}