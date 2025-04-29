import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class C1068_O {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vertexNum = Integer.parseInt(br.readLine());
        int[] graph = new int[vertexNum];

        String[] inp = br.readLine().split(" ");
        for (int i = 0; i < vertexNum; i++) {
            graph[i] = Integer.parseInt(inp[i]);
        }

        int removeNode = Integer.parseInt(br.readLine());

        Set<Integer> removeSet = new HashSet<>();

        // 삭제해야할 노드를 추가
        removeSet.add(removeNode);

        boolean isChanged = true;
        while(isChanged){
            isChanged = false;

            for (int i = 0; i < vertexNum; i++) {
                // i : vertex 번호, graph[i] : parent vertex 번호
                // 1. 중복 삭제 x
                // 2. 부모가 삭제해야할 노드에 포함되어 있는가? -> 자식도 삭제해야함
                if (!removeSet.contains(i) && removeSet.contains(graph[i])) {
                    removeSet.add(i);
                    isChanged = true;
                }
            }
        }


        Set<Integer> leafSet = new HashSet<>();
        for (int i = 0; i < vertexNum; i++) {
            if (removeSet.contains(i)) continue; // 삭제된 노드는 무시
            leafSet.add(i);
        }

        for (int i = 0; i < vertexNum; i++) {
            if (removeSet.contains(i)) continue; // 삭제된 노드는 무시
            leafSet.remove(graph[i]); // 부모인 노드는 리프가 아님
        }

        System.out.println(leafSet.size());
    }
}
