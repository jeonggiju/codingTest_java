import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 1. DP는 아닌 듯. 그냥 아닌 것 같음
 * 2. DFS를 쓰는데, 그냥 돌면 안될 것 같아. 왜? 이 문제는 골딱이라 그럼. 정점 최대 개수가 100,000개임.
 *  모든 경우의 수를 다 따져서 Math.max 하면 될 것같은데 이거 아닌 것 같음
 * 3. 조건을 달아야할 것같은데... 사이클 형태는 아닌 것 같음
 *  가령 1에서 5까지로 간다고 하면 1->3-> 4-> 2 -> 4-> 2-> ... 4-> 5가 되니까. 그냥 한 번 방문했으면 visited true하면 되겠네. 그러면 어떻게 접근하는게 좋을까?
 * 4. 가중치가 높은 것 순서대로 하나씩 해볼까? 조합을 해야할 것 같은데... 백트래킹을 해야하나?
 * 5. 그려보자...
 */

public class C1167_O {
    public static int[] visited;
    static List<NextVertex>[] graph;
    public static int maxValue = 0;
    public static int[] visitedForSecond;

    public static class NextVertex{
        int nextVertex;
        int weight;

        public NextVertex(int n, int w){
            this.nextVertex = n;
            this.weight = w;
        }
    }

    public static void dfs(int currentVertex, int currentWeight) {
        visited[currentVertex] = 1;
        boolean isLeaf = true;

        for (NextVertex next : graph[currentVertex]) {
            int nextVertex = next.nextVertex;

            if (visited[nextVertex] == 0) {
                isLeaf = false;
                dfs(nextVertex, currentWeight + next.weight);
            }
        }

        if (isLeaf) {
            if (currentWeight > maxValue) {
                maxValue = currentWeight;
                visitedForSecond = visited.clone();
            }
        }

        visited[currentVertex] = 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        visited = new int[num];
        graph = new ArrayList[num];

        for(int i = 0 ; i < num ; i++){
            graph[i] = new ArrayList<>();

            String[] inp = br.readLine().split(" ");

            for (int j = 1; j < inp.length - 1; j += 2){
                int destination = Integer.parseInt(inp[j])-1;
                int weight  = Integer.parseInt(inp[j+1]);

                graph[i].add(new NextVertex(destination,weight));
            }
        }

        int startIdx = 0;
        int max = Integer.MIN_VALUE;

        // 간선이 제일 많은 노드 찾기
        for(int i = 0 ; i < num ; i++){
            int size = graph[i].size();
            if(max < size){
                startIdx = i;
                max = size;
            }
        }

        dfs(startIdx, 0);
        int result = maxValue;
        maxValue = 0;
        visited = visitedForSecond.clone();
        dfs(startIdx, 0);
        System.out.println(result+maxValue);
    }
}
