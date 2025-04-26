import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;


/**
 * 1 : 익음
 * 0 : 안익음
 * -1 : 토마토가 없음!!!
 */
public class C7569_O {
    static Deque<int[]> dq = new ArrayDeque<>();

    public static void bfs(int[][][] map){
        int heightBound = map.length;
        int rowBound = map[0].length;
        int colBound = map[0][0].length;

        while(!dq.isEmpty()){
            int[] currentLocation = dq.removeFirst();
            int currentHeight = currentLocation[0];
            int currentRow = currentLocation[1];
            int currentCol = currentLocation[2];

            // 위
            if(currentHeight-1 > -1 && map[currentHeight-1][currentRow][currentCol] == 0){
                dq.addLast(new int[]{currentHeight-1, currentRow, currentCol});
                map[currentHeight-1][currentRow][currentCol] = map[currentHeight][currentRow][currentCol]+ 1;
            }

            // 아래
            if(currentHeight+1 < heightBound && map[currentHeight+1][currentRow][currentCol] == 0){
                dq.addLast(new int[]{currentHeight+1, currentRow, currentCol});
                map[currentHeight+1][currentRow][currentCol] = map[currentHeight][currentRow][currentCol]+ 1;
            }

            // 앞
            if(currentRow+1 < rowBound && map[currentHeight][currentRow+1][currentCol] == 0){
                dq.addLast(new int[]{currentHeight, currentRow+1, currentCol});
                map[currentHeight][currentRow+1][currentCol] = map[currentHeight][currentRow][currentCol]+ 1;
            }

            // 뒤
            if(currentRow-1 > -1 && map[currentHeight][currentRow-1][currentCol] == 0){
                dq.addLast(new int[]{currentHeight, currentRow-1, currentCol});
                map[currentHeight][currentRow-1][currentCol] = map[currentHeight][currentRow][currentCol]+ 1;
            }

            // 왼
            if(currentCol-1 > -1 && map[currentHeight][currentRow][currentCol-1] == 0){
                dq.addLast(new int[]{currentHeight, currentRow, currentCol-1});
                map[currentHeight][currentRow][currentCol-1] = map[currentHeight][currentRow][currentCol]+ 1;
            }

            // 오
            if(currentCol+1 < colBound && map[currentHeight][currentRow][currentCol+1] == 0){
                dq.addLast(new int[]{currentHeight, currentRow, currentCol+1});
                map[currentHeight][currentRow][currentCol+1] = map[currentHeight][currentRow][currentCol]+ 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inp = br.readLine().split(" ");
        int colNum = Integer.parseInt(inp[0]);
        int rowNum = Integer.parseInt(inp[1]);
        int heightNum = Integer.parseInt(inp[2]);

        int[][][] map = new int[heightNum][rowNum][colNum];

        for(int i = 0 ; i < heightNum; i++){
            for(int j = 0 ; j < rowNum; j++){
                inp = br.readLine().split(" ");
                for(int k = 0 ; k < colNum ; k++){
                    map[i][j][k] = Integer.parseInt(inp[k]);
                }
            }
        }

        for(int i = 0 ; i < heightNum; i++){
            for(int j = 0 ; j < rowNum; j++){
                for(int k = 0 ; k < colNum ; k++){
                    if(map[i][j][k] == 1){
                        dq.addLast(new int[]{i,j,k});
                    }
                }
            }
        }

        bfs(map);


        int Day = Integer.MIN_VALUE;
        for(int i = 0 ; i < heightNum; i++){
            for(int j = 0 ; j < rowNum; j++){
                for(int k = 0 ; k < colNum ; k++){
                    if(map[i][j][k] == 0){
                        System.out.println(-1);
                        return;
                    }
                    Day = Math.max(Day,map[i][j][k]);
                }
            }
        }

        System.out.println(Day-1);
    }
}
