import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C1937 {
    public static int[][] DP;
    public static int[][] MAP;
    public static int[][] DIRECTION = {{-1,0}, {1,0}, {0,1}, {0,-1}};

    public static int dfs(int row, int col){

        int returnValue = DP[row][col];

        // 방문했음
        if(DP[row][col] > 0){
            return returnValue;
        }

        DP[row][col] = 1;
        int nextRow = 0;
        int nextCol = 0;

        for(int i = 0 ; i < 4 ; i++){
            nextRow = row + DIRECTION[i][0];
            nextCol = col + DIRECTION[i][1];

            // 1. next Location이 범위 안에 들어야 하며
            // 2. 다음칸으로 이동할 수 있어야함(욕심이 쥰내 많은 쿵후팬더니까)
            if(0<= nextRow && nextRow < MAP.length && 0 <= nextCol && nextCol < MAP[0].length && MAP[row][col] < MAP[nextRow][nextCol]){
                DP[row][col] = Math.max(DP[row][col], dfs(nextRow, nextCol) + 1);
            }
        }

        return DP[row][col];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int mapNum = Integer.parseInt(br.readLine());
        MAP = new int[mapNum][mapNum];

        String[] inp;
        for(int i = 0 ; i < mapNum; i ++){
            inp = br.readLine().split(" ");
            for(int j = 0 ; j < mapNum ; j++){
                MAP[i][j] = Integer.parseInt(inp[j]);
            }
        }

        DP = new int[mapNum][mapNum];

        int answer = 0;
        for(int i = 0 ; i < mapNum; i++){
            for(int j = 0 ; j < mapNum ; j++){
                answer = Math.max(answer, dfs(i, j));
            }
        }

        System.out.println(answer);
    }
}
