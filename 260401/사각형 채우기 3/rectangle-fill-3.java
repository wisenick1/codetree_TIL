import java.util.*;
import java.io.*;

import java.util.*;
import java.io.*;

public class Main {
    static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[1001];

        dp[1] = 2;
        dp[2] = 7;
        dp[3] = 22;

        for(int i = 4; i <= n; i++) {
            dp[i] = (3 * dp[i - 1] + dp[i - 2] - dp[i - 3]) % MOD;
            if (dp[i] < 0) dp[i] += MOD;
        }

        System.out.println(dp[n]);
    }
}