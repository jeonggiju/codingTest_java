import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * N: 학생 수
 * M : 비교 횟수
 * a, b : a << b 순서상으로 앞서는 것
 * e.g.
 * 4 2 : N M
 * 4 2 : 4 << 2
 * 3 1 : 3 << 1
 * 대충 그래프로 그려봄
 *
 * 4 -> 2
 * 3 -> 1
 *
 * 결과: 4 2 3 1
 * 의문 : 그러면 결과가 4 3 2 1 됨 문제보니 스페셜 저지임 ㅋ
 */

public class C2252 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inp  = br.readLine().split(" ");

        int vertexNum = Integer.parseInt(inp[0]);
        int edgeNum = Integer.parseInt(inp[1]);
        int[] inDegrees = new int[vertexNum];

        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0 ; i <vertexNum; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0 ; i < edgeNum ; i++){
            inp = br.readLine().split(" ");
            int outDegree = Integer.parseInt(inp[0])-1;
            int inDegree = Integer.parseInt(inp[1])-1;
            graph.get(outDegree).add(inDegree);

            inDegrees[inDegree]++;
        }

        Deque<Integer> qu = new LinkedList<>();

        for(int i = 0 ; i < vertexNum ; i++){
            if(inDegrees[i] == 0){
                qu.addLast(i);
            }
        }

        while(!qu.isEmpty()){
            int currentVertex = qu.removeFirst();
            System.out.print((currentVertex+1) +" ");

            for(int nextVertex : graph.get(currentVertex)){
                inDegrees[nextVertex]--;

                if(inDegrees[nextVertex] == 0){
                    qu.addLast(nextVertex);
                }
            }
        }
    }
}
