import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C24479_X_1 {
    public static void dfs(int[][] graph,int[] visited ,int startNode, int depth){
        visited[startNode] = depth; // 방문여부 체크

        for(int i = 0; i < graph.length; i++){
            // 인접 vertex가 방문되지 않았다면,
            if(visited[i] ==0  && graph[startNode][i]== 1){
                dfs(graph, visited, i, depth+1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inp = br.readLine().split(" ");
        int vertexNum = Integer.parseInt(inp[0]);
        int edgeNum = Integer.parseInt(inp[1]);
        int startNode = Integer.parseInt(inp[2])-1;

        int [][] graph = new int[vertexNum][vertexNum];
        int[] visited = new int[vertexNum];

        for(int i = 0 ; i < edgeNum ; i++){
            inp =  br.readLine().split(" ");
            int departNode = Integer.parseInt(inp[0])-1;
            int destinationNode = Integer.parseInt(inp[1])-1;
            graph[departNode][destinationNode] = 1;
            graph[destinationNode][departNode] = 1;
        }

        dfs(graph, visited, startNode, 1);
        for(int i = 0 ; i < vertexNum; i++){
            System.out.println(visited[i]);
        }
    }
}
