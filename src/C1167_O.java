import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class C1167_O {
    static class NextNode {
        int node;
        int weight;

        public NextNode(int vertex, int weight) {
            this.node = vertex;
            this.weight = weight;
        }
    }

    static List<NextNode>[] graph;
    static boolean[] visited;
    static int maxDist = 0;
    static int farthestNode = 0;

    public static void dfs(int node, int dist) {
        visited[node] = true;
        if (dist > maxDist) {
            maxDist = dist;
            farthestNode = node;
        }

        for (NextNode next : graph[node]) {
            if (!visited[next.node]) {
                dfs(next.node, dist + next.weight);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());

        graph = new ArrayList[V + 1];  // 1-based 인덱싱
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            String[] inp = br.readLine().split(" ");
            int from = Integer.parseInt(inp[0]);

            int idx = 1;
            while (!inp[idx].equals("-1")) {
                int to = Integer.parseInt(inp[idx++]);
                int weight = Integer.parseInt(inp[idx++]);
                graph[from].add(new NextNode(to, weight));
            }
        }

        // =========== 여기까지가 입력 받음 ==========

        visited = new boolean[V + 1];
        dfs(1, 0);

        visited = new boolean[V + 1];
        maxDist = 0;
        dfs(farthestNode, 0);

        System.out.println(maxDist);
    }
}
