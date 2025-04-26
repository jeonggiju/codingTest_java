import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class C4963_O {

    public static void bfs(int[][] map, int startRow, int startCol){
        Deque<Integer[]> qu = new ArrayDeque<>();

        int rowBound = map.length;
        int colBound = map[0].length;

        qu.addLast(new Integer[]{startRow, startCol});
        map[startRow][startCol] = 0;

        while(!qu.isEmpty()){
            Integer[] currentLocation = qu.removeFirst();
            int currentRow = currentLocation[0];
            int currentCol = currentLocation[1];

            // 상
            if(currentRow - 1 > -1 && map[currentRow-1][currentCol] == 1){
                map[currentRow-1][currentCol] = 0;
                qu.addLast(new Integer[]{currentRow-1, currentCol});
            }

            // 상오
            if(currentRow -1 > -1 && currentCol+1 < colBound && map[currentRow-1][currentCol+1] == 1){
                map[currentRow-1][currentCol+1] = 0;
                qu.addLast(new Integer[]{currentRow-1, currentCol+1});
            }
            // 오
            if(currentCol+1 < colBound && map[currentRow][currentCol+1] == 1){
                map[currentRow][currentCol+1] = 0;
                qu.addLast(new Integer[]{currentRow, currentCol+1});
            }
            // 하오
            if(currentRow+1 < rowBound && currentCol+1 <colBound && map[currentRow+1][currentCol+1] == 1){
                map[currentRow+1][currentCol+1] = 0;
                qu.addLast(new Integer[]{currentRow+1, currentCol+1});
            }
            // 하
            if(currentRow+1 < rowBound && map[currentRow+1][currentCol] == 1){
                map[currentRow+1][currentCol] = 0;
                qu.addLast(new Integer[]{currentRow+1, currentCol});
            }
            // 하왼
            if(currentRow+1 < rowBound && currentCol-1 > -1 && map[currentRow+1][currentCol-1] == 1){
                map[currentRow+1][currentCol-1] = 0;
                qu.addLast(new Integer[]{currentRow+1, currentCol-1});
            }
            // 왼
            if(currentCol-1 > -1 && map[currentRow][currentCol-1] == 1){
                map[currentRow][currentCol-1] = 0;
                qu.addLast(new Integer[]{currentRow, currentCol-1});
            }
            // 상왼
            if(currentRow-1 > -1 && currentCol-1 > -1 && map[currentRow-1][currentCol-1] == 1){
                map[currentRow-1][currentCol-1] = 0;
                qu.addLast(new Integer[]{currentRow-1, currentCol-1});
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String[] inp = br.readLine().split(" ");

            int colNum = Integer.parseInt(inp[0]);
            int rowNum = Integer.parseInt(inp[1]);

            if(rowNum == 0 && colNum == 0)
                break;

            int[][] map = new int[rowNum][colNum];

            for(int i = 0 ; i < rowNum ; i++){
                inp = br.readLine().split(" ");
                for(int j = 0 ; j < colNum; j++){
                    map[i][j] = Integer.parseInt(inp[j]);
                }
            }

            int count =  0;

            for(int i = 0 ; i < rowNum ; i++){
                for(int j = 0 ; j < colNum; j++){
                    if(map[i][j] == 1){
                        bfs(map, i, j);
                        count++;
                    }
                }
            }

            System.out.println(count);

        }
    }
}
