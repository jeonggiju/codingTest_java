import java.io.*;
import java.util.*;

public class C11066 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int num = Integer.parseInt(br.readLine());

            int[] numbers = new int[num];

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < num; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            long[][] dp = new long[num][num]; // dp 테이블

            for (int i = 0; i < num - 1; i++) {
                dp[i][i + 1] = (long)numbers[i] + numbers[i + 1];

                for (int j = i + 2; j < num; j++) {
                    dp[i][j] = dp[i][j - 1] + numbers[j];
                }
            }

//            for(int i = 0 ; i < num ; i++){
//                for(int j = 0 ; j < num ; j++){
//                    System.out.print(dp[i][j] + " ");
//                }
//                System.out.println();
//            }

            for (int n = 2; n < num; n++) { // 부분 길이
                for (int i = 0; i + n < num; i++) { // 시작 인덱스
                    int j = i + n; // 끝 인덱스
                    long minCost = Long.MAX_VALUE;

                    for (int x = i; x < j; x++) { // 분할점
                        long cost = dp[i][x] + dp[x + 1][j];

                        if (cost < minCost) {
                            minCost = cost;
                        }
                    }

                    dp[i][j] += minCost;
                }
            }

            sb.append(dp[0][num - 1]).append('\n');
        }

        System.out.print(sb.toString());
    }
}
