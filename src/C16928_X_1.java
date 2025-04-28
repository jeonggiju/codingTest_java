import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class C16928_X_1 {
    static int[] map = new int[101];
    static int[] dp = new int[101]; // 0이면 아직 계산 안 함

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inp = br.readLine().split(" ");
        int ladderNum = Integer.parseInt(inp[0]);
        int snakeNum = Integer.parseInt(inp[1]);

        for (int i = 1; i <= 100; i++) {
            map[i] = i;
        }

        for (int i = 0; i < ladderNum; i++) {
            inp = br.readLine().split(" ");
            int from = Integer.parseInt(inp[0]);
            int to = Integer.parseInt(inp[1]);
            map[from] = to;
        }

        for (int i = 0; i < snakeNum; i++) {
            inp = br.readLine().split(" ");
            int from = Integer.parseInt(inp[0]);
            int to = Integer.parseInt(inp[1]);
            map[from] = to;
        }

        Arrays.fill(dp, -1); // 초기화: -1은 아직 방문 안 한 것

        dp[1] = 0; // 1번 칸은 시작점, 0회 이동

        System.out.println(dfs(100));
    }

    public static int dfs(int now) {
        if (now < 1) return Integer.MAX_VALUE / 2; // 0 이하 칸은 갈 수 없음

        if (dp[now] != -1) {
            return dp[now];
        }

        int minMoves = Integer.MAX_VALUE / 2;

        for (int dice = 1; dice <= 6; dice++) {
            int prev = now - dice;
            if (prev < 1) continue;

            prev = map[prev]; // 이전 칸이 사다리/뱀의 출발점이면 이동

            minMoves = Math.min(minMoves, dfs(prev) + 1);
        }

        dp[now] = minMoves;
        return dp[now];
    }
}
