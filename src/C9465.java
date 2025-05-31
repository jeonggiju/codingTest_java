import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] inp = new int[2][n];
            StringTokenizer st;
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    inp[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            if (n == 1) {
                System.out.println(Math.max(inp[0][0], inp[1][0]));
                continue;
            }

            int[][] dp = new int[2][n];
            dp[0][0] = inp[0][0];
            dp[1][0] = inp[1][0];

            dp[0][1] = inp[1][0] + inp[0][1];
            dp[1][1] = inp[0][0] + inp[1][1];

            for (int i = 2; i < n; i++) {
                dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + inp[0][i];
                dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + inp[1][i];
            }

            System.out.println(Math.max(dp[0][n-1], dp[1][n-1]));
        }
    }
}
