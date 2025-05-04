import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * N, M : 과목의 수, 선수 조건의 수
 * a b : a < b
 */
public class C14567_X {
    public static boolean[] visited;
    public static int[] res;
    public static List<List<Integer>> graph;

    public static void dfs(int currentVertex, int depth){
        visited[currentVertex] = true;
        res[currentVertex] = Math.max(res[currentVertex],depth);

        for(int adj : graph.get(currentVertex)){
            if(!visited[adj]){
                dfs(adj, depth+1);
            }
        }

        visited[currentVertex] = false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inp = br.readLine().split(" ");
        int vertexNum = Integer.parseInt(inp[0]);
        int adjNum = Integer.parseInt(inp[1]);

        res= new int[vertexNum];
        // 0-base
        graph = new ArrayList<>();
        visited = new boolean[vertexNum];
        for(int i = 0 ; i < vertexNum ; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0 ; i < adjNum ; i++){
            inp = br.readLine().split(" ");

            int outEdge = Integer.parseInt(inp[0])-1;
            int inEdge = Integer.parseInt(inp[1])-1;
            graph.get(outEdge).add(inEdge);
        }

        for(int i = 0 ; i < vertexNum ; i++){
            dfs(i, 1);
        }

        for(int i = 0 ; i < vertexNum; i++){
            System.out.print(res[i]);
            if(i != vertexNum-1){
                System.out.print(" ");
            }
        }
    }
}
