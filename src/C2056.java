import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C2056 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];

        int res = 0;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            dp[i] = time;
            for (int j = 0; j < num; j++) {
                int temp = Integer.parseInt(st.nextToken());

                dp[i] = Math.max(dp[i], dp[temp] + time);
            }

            res = Math.max(res, dp[i]);
        }

        System.out.println(res);
    }

}