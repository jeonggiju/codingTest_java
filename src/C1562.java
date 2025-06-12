import java.io.*;
import java.util.*;

public class C1562 {
    public static int N;
    // selected : 0 ~ 9까지 각 숫자가 몇 번 사용됬는지 카운트
    public static int selected[];
    public static long dp[][][];

    public static long dfs(int idx, int prev) {

        int bitmask = 0;

        int check = 1;

        for(int i=0;i<10;i++) {
            if(selected[i] > 0) {
                bitmask += check;
            }
            check*=2;
        }

        if(idx==N) {
            if(bitmask == (1<<10)-1) {
                return 1;
            }else {
                return 0;
            }
        }

        if(prev!=-1) {
            if(dp[bitmask][idx][prev]!=-1) {
                return dp[bitmask][idx][prev];
            }
        }

        long result = 0;
        if(idx==0) {
            for(int i=1;i<=9;i++) {
                selected[i] += 1;
                result += dfs(idx+1,i);
                result %= 1000000000;
                selected[i] -= 1;
            }
        }else {
            if(prev==9) {
                selected[8] += 1;
                result+= dfs(idx+1,8);
                selected[8] -= 1;
            }else if(prev == 0) {
                selected[1] += 1;
                result+= dfs(idx+1,1);
                selected[1] -= 1;
            }else {
                selected[prev+1] += 1;
                result += dfs(idx+1,prev+1);
                selected[prev+1] -= 1;
                selected[prev-1] += 1;
                result += dfs(idx+1,prev-1);
                selected[prev-1] -= 1;
            }
        }
        result %= 1000000000;
        if(prev!=-1) {
            return dp[bitmask][idx][prev] = result;
        }
        return result;
    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        selected = new int[10];
        dp = new long[1<<10][N][10];

        // dp -1로 초기화
        for(int i=0;i<1<<10;i++) {
            for(int j=0;j<N;j++) {
                for(int k=0;k<10;k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        System.out.println(dfs(0,-1));
    }

}