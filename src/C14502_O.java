import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class C14502_O {

    public static List<Integer> ls = new ArrayList<>();
    static int oneCount = 0;

    public static void bfs(int[][] map) {
        int TwoCount = 0;
        int rowNum = map.length;
        int colNum = map[0].length;

        Deque<Integer[]> qu = new ArrayDeque<>();

        for (int startRow= 0; startRow < rowNum; startRow++) {
            for (int startCol=0; startCol < colNum; startCol++) {
                if (map[startRow][startCol] == 2) {
                    qu.addLast(new Integer[]{startRow, startCol});
                }
            }
        }

        while(!qu.isEmpty()){
            Integer[] currentLocation = qu.removeFirst();
            TwoCount+=1;
            int currentRow = currentLocation[0];
            int currentCol = currentLocation[1];

            // 상
            if(currentRow-1 > -1 && map[currentRow-1][currentCol] != 1 && map[currentRow-1][currentCol] != 2){
                qu.addLast(new Integer[]{currentRow-1, currentCol});
                map[currentRow-1][currentCol] = 2;

            }
            // 하
            if(currentRow+1 < rowNum && map[currentRow+1][currentCol] != 1 && map[currentRow+1][currentCol] != 2){
                qu.addLast(new Integer[]{currentRow+1, currentCol});
                map[currentRow+1][currentCol] = 2;

            }
            // 좌
            if(currentCol-1 > -1 && map[currentRow][currentCol-1] != 1 && map[currentRow][currentCol-1] != 2){
                qu.addLast(new Integer[]{currentRow, currentCol-1});
                map[currentRow][currentCol-1] = 2;


            }
            // 우
            if(currentCol+1 < colNum && map[currentRow][currentCol+1] != 1 && map[currentRow][currentCol+1] != 2){
                qu.addLast(new Integer[]{currentRow, currentCol+1});
                map[currentRow][currentCol+1] = 2;
            }
        }

        ls.add(TwoCount);
    }

    public static void setWall(int wallNum, int[][] map) {
        if (wallNum == 3) {
            int[][] cloneMap = new int[map.length][];
            for (int i = 0; i < map.length; i++) {
                cloneMap[i] = map[i].clone();
            }
            bfs(cloneMap);
            return;
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    setWall(wallNum + 1, map);
                    map[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inp = br.readLine().split(" ");
        int rowNum = Integer.parseInt(inp[0]);
        int colNum = Integer.parseInt(inp[1]);

        int[][] map = new int[rowNum][colNum];

        for(int i = 0 ; i < rowNum ; i++){
            inp = br.readLine().split(" ");

            for(int j = 0 ; j < colNum ; j++){
                map[i][j] = Integer.parseInt(inp[j]);
                if(map[i][j] == 1){
                    oneCount+= 1;
                }
            }
        }

        setWall(0, map);

        int maxValue =  ls.stream().map(el -> rowNum*colNum - el- oneCount -3).max(Comparator.naturalOrder()).orElse(0);
        System.out.println(maxValue);
    }
}
