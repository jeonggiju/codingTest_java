import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C16928  {
    public static boolean[][] visited;
    public static int[] dRow = {-1, 1, 0, 0};
    public static int[] dCol = {0, 0, -1, 1};

    public static void dfs(int[][] map, int currentRow, int currentCol, int targetRow, int targetCol, int targetNumber, int depth){
        visited[currentRow][currentCol] = true;

        for (int dir = 0; dir < 4; dir++) {
            int nextRow = currentRow + dRow[dir];
            int nextCol = currentCol + dCol[dir];

            // 범위 밖 체크
            if (nextRow < 0 || nextCol < 0 || nextRow >= map.length || nextCol >= map[0].length) 
                continue;

            //  방문한 지역인 경우
            if(visited[nextRow][nextCol]){
                // 어 근데 처음 시작지인 경우
                if(depth >= 4 && nextRow == targetRow && nextCol == targetCol){
                    System.out.println("Yes");
                    System.exit(0);
                }
                // 아니네
                continue;
            }

            // 값이 다른 경우
            if (map[nextRow][nextCol] != targetNumber) {
                continue;
            }

            dfs(map, nextRow, nextCol, targetRow, targetCol, targetNumber, depth+1);
        }
        visited[currentRow][currentCol] = false;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inp = br.readLine().split(" ");
        int rowNum = Integer.parseInt(inp[0]);
        int colNum = Integer.parseInt(inp[1]);

        int[][] map = new int[rowNum][colNum];
        visited = new boolean[rowNum][colNum];

        for(int i = 0 ; i < rowNum; i++){
            char[] cInp = br.readLine().toCharArray();
            for(int j = 0 ; j < colNum ; j++){
                map[i][j] = cInp[j]-'A';
            }
        }
        for(int i = 0 ; i < rowNum; i++){
            for(int j = 0 ; j < colNum ; j++){
                if(visited[i][j]){
                    continue;
                }
                dfs(map, i, j, i, j, map[i][j],1);
            }
        }

        System.out.print("No");
    }
}
