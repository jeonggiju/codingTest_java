import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * 제일 큰 값 M
 * 나머지들의 합 N
 * 총 합 S = M + N
 *
 * 1. M > N => 2 * N + 1
 * 2. M <= N => N + M
 *
 * e.g.
 * - 1 1 3 <- 2 3
 *  -> C A C B C (5) <- 2 * 2 + 1
 *
 * - 5 3
 *  -> B B B B (7) <- 3 * 2 + 1
 *
 * - 2 2 2 3 (9)
 *  -> 6, 3 <- 6 + 3
 */
public class C25635_X {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] number = new long[n];
        String[] inp = br.readLine().split(" ");

        long maxValue = Integer.MIN_VALUE;
        long sum = 0;

        for(int i = 0 ; i < n ; i++){
            number[i] = Integer.parseInt(inp[i]);
            maxValue = maxValue < number[i] ? number[i] : maxValue;
            sum += number[i];
        }

        long otherSum = sum - maxValue;

        System.out.println(maxValue > otherSum ? 2*otherSum+1 : sum);

    }
}
