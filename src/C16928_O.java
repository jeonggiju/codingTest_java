import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class C16928_O {
    static int[] map = new int[101];
    static int[] visited = new int[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inp = br.readLine().split(" ");
        int ladderNum = Integer.parseInt(inp[0]);
        int snakeNum = Integer.parseInt(inp[1]);

        for (int i = 1; i <= 100; i++) {
            map[i] = i;
        }

        for (int i = 0; i < ladderNum; i++) {
            inp = br.readLine().split(" ");
            int from = Integer.parseInt(inp[0]);
            int to = Integer.parseInt(inp[1]);
            map[from] = to;
        }

        for (int i = 0; i < snakeNum; i++) {
            inp = br.readLine().split(" ");
            int from = Integer.parseInt(inp[0]);
            int to = Integer.parseInt(inp[1]);
            map[from] = to;
        }

        Deque<Integer> qu = new ArrayDeque<>();
        qu.addLast(1);
        visited[1] = 0; // 시작 위치는 방문했음. 0회 이동.

        while (!qu.isEmpty()) {
            int currentLocation = qu.removeFirst();

            for (int dice = 1; dice <= 6; dice++) {
                int nextLocation = currentLocation + dice;

                if (nextLocation > 100) continue; // 100 넘으면 무시

                nextLocation = map[nextLocation]; // 사다리/뱀 이동

                if (visited[nextLocation] == 0) { // 방문한 적 없으면
                    visited[nextLocation] = visited[currentLocation] + 1;
                    qu.addLast(nextLocation);
                }

                if (nextLocation == 100) {
                    System.out.println(visited[nextLocation]);
                    return;
                }
            }
        }
    }
}
