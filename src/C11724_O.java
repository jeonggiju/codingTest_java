import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class C11724_O {
    public static void bfs(int[][] map, int[] visited, int startNode, int nodeNum){
        Deque<Integer> qu = new ArrayDeque<>();

        qu.addLast(startNode);
        visited[startNode] = 1;

        while(!qu.isEmpty()) {
            int currentNode = qu.removeFirst();

            for(int nextNode = 0 ; nextNode < nodeNum ; nextNode++) {
                if(map[currentNode][nextNode] == 1 && visited[nextNode] == 0) {
                    qu.addLast(nextNode);
                    visited[nextNode] = 1;
                }
            }
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inp = br.readLine().split(" ");
        int nodeNum = Integer.parseInt(inp[0]);
        int edgeNum = Integer.parseInt(inp[1]);

        int[][] map = new int[nodeNum][nodeNum];

        for(int i = 0 ; i < edgeNum ; i++){
            inp = br.readLine().split(" ");
            int row = Integer.parseInt(inp[0])-1;
            int col = Integer.parseInt(inp[1])-1;

            map[row][col] = 1;
            map[col][row] = 1;
        }

        int[] visited = new int[nodeNum]; // init by 0
        int count = 0 ;

        for(int i = 0 ; i < nodeNum ; i++){
            if(visited[i] == 0){
                bfs(map, visited, i, nodeNum);
                count += 1;
            }
        }
        System.out.println(count);
    }
}
