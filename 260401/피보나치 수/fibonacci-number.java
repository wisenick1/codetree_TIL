import java.util.*;
import java.io.*;

public class Main {
    static int[] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        memo = new int[46];

        Arrays.fill(memo, -1);

        System.out.println(fibo(n));
    }

    private static int fibo(int n) {
        if(memo[n] != -1) return memo[n];

        if(n <= 2) memo[n] = 1;
        else memo[n] = fibo(n - 1) + fibo(n - 2);

        return memo[n];

    }
}