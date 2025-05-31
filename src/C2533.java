import java.io.*;
import java.util.*;

public class C2533 {
    public static boolean[] visited;
    public static int[][] dp;
    public static List<List<Integer>> adj;

    public static void dfs(int current){
        visited[current] = true;
        dp[current][0] = 0;
        dp[current][1] = 1;

        List<Integer> adjj = adj.get(current);
        for(int next : adjj){
            if(visited[next]){
                continue;
            }
            dfs(next);
            dp[current][1] += Math.min(dp[next][0], dp[next][1]);
            dp[current][0] += dp[next][1];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        adj = new ArrayList<>();
        int number = Integer.parseInt(st.nextToken());
        visited = new boolean[number];
        dp = new int[number][2];

        for(int i = 0; i < number; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < number - 1; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            adj.get(from).add(to);
            adj.get(to).add(from);
        }

        dfs(0);
        System.out.println(Math.min(dp[0][0], dp[0][1]));
    }

}
