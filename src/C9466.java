import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class C9466 {
    static int[] graph;
//    static boolean[] visited;
    static int count;

    public static void dfs(int current, Set<Integer> path) {
//        visited[current] = true;
        path.add(current);

        int next = graph[current];

        if (!path.contains(next)) {
            dfs(next, path);
        }
//      else if (path.contains(next)) {
        else{
            int temp = next;

            while (true) {
                count++;
                temp = graph[temp];
                
                // 원점
                if (temp == next) 
                    break;
            }
        }
//        path.remove(current);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseNum = Integer.parseInt(br.readLine());

        while (testCaseNum-- > 0) {
            int n = Integer.parseInt(br.readLine());
            graph = new int[n];
//            visited = new boolean[n];
            count = 0;

            String[] line = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                graph[i] = Integer.parseInt(line[i]) - 1;
            }

            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (!set.contains(i)) {
                    dfs(i, set);
                }
            }

            System.out.println(n - count);
        }
    }
}
