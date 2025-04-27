import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * DP 하게 풀 수 있지 않을까?
 * m = min(m[i-6], m[m-5], m[m-4], m[m-3], m[m-2], m[m-1], m[m-x])+1
 * 뱀의 경우 : 낮은 곳 -> 높은 곳 ( x -> y )
 * 사다리의 경우 : 높은 곳 -> 낮은 곳
 */

public class C16928_X {
    static int[] map = new int[101];
    static int[] dp = new int[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inp =   br.readLine().split(" ");
        int ladderNum = Integer.parseInt(inp[0]);
        int snakeNum = Integer.parseInt(inp[1]);

        for(int i = 0 ; i <= 100; i++){
            map[i] = i;
        }

        // 사다리
        for(int i = 0 ; i < ladderNum ; i++){
            inp = br.readLine().split(" ");
            int from = Integer.parseInt(inp[0]);
            int to = Integer.parseInt(inp[1]);
            map[from] = to;
        }

        // 뱀
        for(int i = 0 ; i < snakeNum ; i++){
            inp = br.readLine().split(" ");
            int from = Integer.parseInt(inp[0]);
            int to = Integer.parseInt(inp[1]);
            map[from] = to;
        }

        Arrays.fill(dp, 10000);
        dp[1]= 0;

        for(int i = 1 ; i <= 100; i++){
            for(int dice = 1 ; dice <= 6; dice++){
                if(i + dice <= 100){
                    int next = map[i+dice];
                    dp[next] = Math.min(dp[next], dp[i]+1);
                }
            }
        }

        System.out.println(dp[100]);
    }
}

