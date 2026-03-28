import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int result = search(arr, k);
            sb.append(result).append('\n');
        }

        System.out.println(sb);

    }

    private static int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] == target) {
                return mid + 1;
            }

            if(arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}