import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * 5
 * -1 0 0 1 1
 * 2
 */
public class C1068_X_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vertexNum = Integer.parseInt(br.readLine());

        int[] graph = new int[vertexNum];
        String[] inp = br.readLine().split(" ");
        Set<Integer> leafSet = new HashSet<>();
        Set<Integer> removeTreeIdxSet = new HashSet<>();

        for(int i = 0 ; i < vertexNum ; i++){
            graph[i] = Integer.parseInt(inp[i]);
        }

        int removeTreeRootIdx = Integer.parseInt(br.readLine());
        graph[removeTreeRootIdx] = -2;
        removeTreeIdxSet.add(removeTreeRootIdx);

        for(int j = removeTreeRootIdx+1 ; j < vertexNum; j++){
            if(removeTreeIdxSet.contains(graph[j])){
                removeTreeIdxSet.add(j);
                graph[j] = -2;
            }
        }

        for(int i = 0 ; i < vertexNum; i++){
            if(graph[i] == -2){
                continue;
            }
            leafSet.add(i);
            leafSet.remove(graph[i]);
        }
        System.out.println(leafSet.size());

    }
}
