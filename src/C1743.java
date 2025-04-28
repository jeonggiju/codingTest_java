import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C1743 {

    public static int dfs(int[][] map, int startRow ,int startCol){

        int count = 0;

        // 상하좌우
        int[][] direct = {{-1,0},{1,0},{0,-1},{0,1}};
        map[startRow][startCol] = 0; // 방문처리

        for(int[] dir : direct){
            int nextRow = startRow+dir[0];
            int nextCol = startCol+dir[1];

            // 경계 확인
            if (nextRow >= 0 && nextRow < map.length && nextCol >= 0 && nextCol < map[0].length) {
                if (map[nextRow][nextCol] == 1) { // 아직 방문하지 않은 경우
                    count += dfs(map, nextRow, nextCol)+1; // 재귀 호출
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inp = br.readLine().split(" ");
        int rowNum = Integer.parseInt(inp[0]);
        int colNum = Integer.parseInt(inp[1]);
        int garbageNum = Integer.parseInt(inp[2]);

        int[][] map = new int[rowNum][colNum];

        for(int i = 0 ; i < garbageNum; i++){
            inp = br.readLine().split(" ");
            int garbageRow = Integer.parseInt(inp[0])-1;
            int garbageCol = Integer.parseInt(inp[1])-1;
            map[garbageRow][garbageCol] = 1;
        }


        int result = Integer.MIN_VALUE;

        for(int i = 0 ; i < rowNum ; i++){
            for(int j = 0 ; j < colNum ; j++){
                if(map[i][j] == 1){
                    result = Math.max(result, dfs(map, i, j));
                }
            }
        }
        System.out.println(result+1);
    }
}
