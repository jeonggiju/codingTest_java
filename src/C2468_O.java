import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class C2468_O {
    static int  count = 0;
    static int maxCount = Integer.MIN_VALUE;

    public static void bfs(int[][] map, int height, int startRow, int startCol){
        int rowBound = map.length;
        int colBound = map[0].length;

        Deque<Integer[]> qu = new ArrayDeque<>();
        qu.addLast(new Integer[]{startRow, startCol});
        map[startRow][startCol] = 0;

        while(!qu.isEmpty()){
            Integer[] currentLocation = qu.removeFirst();
            int curRow = currentLocation[0];
            int curCol = currentLocation[1];

            // 상
            if(curRow - 1 > -1 && map[curRow-1][curCol] >= height){
                qu.addLast(new Integer[]{curRow-1, curCol});
                map[curRow-1][curCol] = 0;
            }

            // 하
            if(curRow +1 < rowBound && map[curRow+1][curCol] >= height){
                qu.addLast(new Integer[]{curRow+1, curCol});
                map[curRow+1][curCol] = 0;
            }

            // 좌
            if(curCol - 1 > -1 && map[curRow][curCol-1] >= height){
                qu.addLast(new Integer[]{curRow, curCol-1});
                map[curRow][curCol-1] = 0;
            }

            // 우
            if(curCol + 1 < colBound && map[curRow][curCol+1] >= height){
                qu.addLast(new Integer[]{curRow, curCol+1});
                map[curRow][curCol+1] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];

        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i++){
            String[] inp = br.readLine().split(" ");
            for(int j = 0 ; j < n ; j++){
                map[i][j] = Integer.parseInt(inp[j]);
                max = Math.max(max, map[i][j]);
            }
        }

        for(int height = 1; height <= max ; height++){
            int[][] currentMap = new int[n][n];
            count = 0;
            for (int i = 0; i < n; i++) {
                currentMap[i] = map[i].clone();
            }

            for(int i = 0 ; i < n; i++){
                for(int j = 0 ; j < n ; j++){
                    if(currentMap[i][j] >= height){
                        bfs(currentMap, height, i, j);
                        count++;
                    }
                }
            }

            maxCount = Math.max(count, maxCount);
        }

        System.out.println(maxCount);
    }
}
