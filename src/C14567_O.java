import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * N, M : 과목의 수, 선수 조건의 수
 * a b : a < b
 *
 */
public class C14567_O {
    public static boolean[] visited;
    public static List<List<Integer>> graph;
    public static int[] res;
    public static int[] inDegree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inp = br.readLine().split(" ");
        int vertexNum = Integer.parseInt(inp[0]);
        int adjNum = Integer.parseInt(inp[1]);

        // 0-base
        graph = new ArrayList<>();
        visited = new boolean[vertexNum];
        res = new int[vertexNum];
        inDegree = new int[vertexNum];

        for(int i = 0 ; i < vertexNum ; i++){
            graph.add(new ArrayList<>());
            res[i] = 1;
        }

        for(int i = 0 ; i < adjNum ; i++){
            inp = br.readLine().split(" ");

            int outEdge = Integer.parseInt(inp[0])-1;
            int inEdge = Integer.parseInt(inp[1])-1;
            graph.get(outEdge).add(inEdge);
            inDegree[inEdge]++;
        }

        Deque<Integer> qu = new LinkedList<>();
        for(int i = 0 ; i < vertexNum ; i++){
            if(inDegree[i] == 0){
                qu.addLast(i);
            }
        }

        while(!qu.isEmpty()){
            int cur = qu.pollFirst();

            for(int next : graph.get(cur)){
                inDegree[next]--; // 들어오는 차수 제거

                // res 결과 갱신:
                res[next] = res[cur]+1;

                if(inDegree[next] == 0){
                    qu.addLast(next);
                }
            }
        }


        for(int i = 0 ; i < vertexNum; i++){
            System.out.print(res[i]);
            if(i != vertexNum-1){
                System.out.print(" ");
            }
        }
    }
}
