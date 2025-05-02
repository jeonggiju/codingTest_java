import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class C16964_O {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] answer;
    static int idx = 1;
    static int vertexNum;

    private static boolean dfs(int currentVertex){
        visited[currentVertex] = true;
        // 현재 정점에서 방문하지 않은 정점들을 담아둘 용도
        Set<Integer> childSet = new HashSet<>();

        for(int nextVertex : graph[currentVertex]){
            if(!visited[nextVertex]){
                childSet.add(nextVertex);
            }
        }

        int childCount = childSet.size();

        for(int i = 0 ; i < childCount ; ++i){
            if (idx + 1 > vertexNum)
                return false;

            // 현재 DFS 순서에서 다음에 방문해야할 노드를 가져옴
            int nextVertex = answer[++idx];

            // 만일 다음 노드로 가지 못한다면 false 더 이상의 dfs는 의미없음
            if(!childSet.contains(nextVertex))
                return false;

            // 조건이 맞는다면 다음 DFS로 재귀호출
            boolean result = dfs(nextVertex);

            // true가 아니면 그 뒤로 false를 반환
            if(!result)
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        vertexNum = Integer.parseInt(br.readLine());

        graph = new ArrayList[vertexNum + 1];
        for(int i = 1 ; i <= vertexNum ; ++i)
            graph[i] = new ArrayList<>();

        visited = new boolean[vertexNum + 1];
        answer = new int[vertexNum + 1];
        idx = 1;

        for(int i = 0 ; i < vertexNum - 1 ; ++i) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph[from].add(to);
            graph[to].add(from);
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= vertexNum ; ++i)
            answer[i] = Integer.parseInt(st.nextToken());

        // =====================================================

        if(answer[1] != 1) {
            System.out.println(0);
            return;
        }

        if(dfs(1))
            System.out.println(1);
        else
            System.out.println(0);
    }
}
