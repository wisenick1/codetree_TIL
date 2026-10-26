import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[] top = new int[n];
        int[] bottom = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            top[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            bottom[i] = Integer.parseInt(st.nextToken());
        }

        int[] arr = new int[2 * n];

        for(int i = 0; i < n; i++) {
            arr[i] = top[i];
        }

        for(int i = n; i < 2 * n; i++) {
            arr[i] = bottom[i - n];
        }

        while(t-- > 0) {
            int temp = arr[2 * n - 1];

            for(int i = 2 * n - 1; i >= 1; i--) {
                arr[i] = arr[i - 1];
            }

            arr[0] = temp;
        }

        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        for(int i = n; i < 2 * n ; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}