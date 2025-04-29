import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class C24479_O {
    static int order = 1;

    public static void dfs(List<Integer>[] graph,int[] visited ,int startNode){
        visited[startNode] = order; // 방문여부 체크

        for(int nextVertex : graph[startNode]){
            // 인접 vertex가 방문되지 않았다면,
            if(visited[nextVertex] == 0){
                order++;
                dfs(graph, visited, nextVertex);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inp = br.readLine().split(" ");
        int vertexNum = Integer.parseInt(inp[0]);
        int edgeNum = Integer.parseInt(inp[1]);
        int startNode = Integer.parseInt(inp[2])-1;

        List<Integer>[] graph = new ArrayList[vertexNum];

        for(int i = 0 ; i < vertexNum ; i++){
            graph[i] = new ArrayList<>();
        }

        int[] visited = new int[vertexNum];

        for(int i = 0 ; i < edgeNum ; i++){
            inp =  br.readLine().split(" ");
            int departNode = Integer.parseInt(inp[0])-1;
            int destinationNode = Integer.parseInt(inp[1])-1;
            graph[departNode].add(destinationNode);
            graph[destinationNode].add(departNode);
        }

        for(int i = 0 ; i < vertexNum ; i++){
            graph[i].sort(Comparator.naturalOrder());
        }

        dfs(graph, visited, startNode);
        for(int i = 0 ; i < vertexNum; i++){
            System.out.println(visited[i]);
        }
    }
}
