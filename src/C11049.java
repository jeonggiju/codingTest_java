import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C11049 {
    static int n, INF = Integer.MAX_VALUE;
    static int[] numbers;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        numbers = new int[n + 1];
        StringTokenizer st = null;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            numbers[i] = a;
            numbers[i + 1] = b;
        }

        dp = new int[n][n];

        for (int length = 2; length < n + 1; length++) { // 길이
            for (int start = 0; start < n - length + 1; start++) { // 구간 시작점
                dp[start][start + length - 1] = INF;

                for (int k = start; k < start + length - 1; k++) { // 중간 지점 k

                    int value = dp[start][k] + dp[k + 1][start + length - 1] + (numbers[start] * numbers[k + 1] * numbers[start + length]);

                    dp[start][start + length - 1] = Math.min(dp[start][start + length - 1], value);
                }

            }
        }
        System.out.println(dp[0][n - 1]);
    }
}