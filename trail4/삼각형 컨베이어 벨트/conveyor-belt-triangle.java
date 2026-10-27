import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[] l = new int[n];
        int[] r = new int[n];
        int[] d = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            l[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            r[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            d[i] = Integer.parseInt(st.nextToken());
        }

        while(t-- > 0) {
            int temp = l[n - 1];
            for(int i = n - 1; i > 0; i--) {
                l[i] = l[i - 1];
            }
            l[0] = d[n - 1];

            int temp2 = r[n - 1];
            for(int i = n - 1; i > 0; i--) {
                r[i] = r[i - 1];
            }
            r[0] = temp;

            for(int i = n - 1; i > 0; i--) {
                d[i] = d[i - 1];
            }
            d[0] = temp2;
        }

        for(int k : l) {
            System.out.print(k + " ");
        }
        System.out.println();
        for(int k : r) {
            System.out.print(k + " ");
        }
        System.out.println();
        for(int k : d) {
            System.out.print(k + " ");
        }
        

    }
}