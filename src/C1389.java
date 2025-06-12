import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class C1389 {

    public static int[][] graph;

    public static void floydWarshall(int n, int[][] dist) {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] < Integer.MAX_VALUE && dist[k][j] < Integer.MAX_VALUE
                            && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inp = br.readLine().split(" ");
        int vertexC = Integer.parseInt(inp[0]);
        int edgeN = Integer.parseInt(inp[1]);

        graph = new int[vertexC][vertexC];
        for(int i = 0 ; i < vertexC ; i++){
            Arrays.fill(graph[i], Integer.MAX_VALUE);
        }

        for(int i = 0 ; i < edgeN ; i++){
            inp = br.readLine().split(" ");
            int departNode = Integer.parseInt(inp[0])-1;
            int destinationNode = Integer.parseInt(inp[1])-1;
            graph[departNode][destinationNode] = 1;
            graph[destinationNode][departNode] = 1;
        }

        floydWarshall(vertexC, graph);

        int[] result = new int[vertexC];

        for(int i = 0 ; i < vertexC ; i++){
            for(int j = 0 ; j < vertexC ; j++){
                if(graph[i][j] == Integer.MAX_VALUE){
                    continue;
                }else{
                    result[i] += graph[i][j];
                }
            }
        }

        int r = 0;
        for (int i = 1; i < vertexC; i++) {
            if (result[i] < result[r]) {
                r = i;
            }
        }

        System.out.println(r+1);

    }
}
