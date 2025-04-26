import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 배추 : 1
 *
 */

public class C1012_O {

    static void search(boolean[][] map, int startRow , int startCol){
        Deque<Integer[]> qu = new ArrayDeque<>();

        qu.addLast(new Integer[]{startRow, startCol});
        map[startRow][startCol] = false;
        int rowBound = map.length;
        int colBound = map[0].length;

        while(!qu.isEmpty()){
            Integer[] cur = qu.removeFirst();

            // 위 경계 확인
            if(cur[0]-1 >= 0 && map[cur[0] - 1][cur[1]]){
                map[cur[0]-1][cur[1]] = false;
                qu.addLast(new Integer[]{cur[0]-1, cur[1]});
            }

            // 오른쪽 경계 확인
            if(cur[1]+1 != colBound && map[cur[0]][cur[1]+1]){
                map[cur[0]][cur[1]+1] = false;
                qu.addLast(new Integer[]{cur[0], cur[1]+1});
            }

            // 왼쪽 경계 확인
            if(cur[1]-1 >= 0 && map[cur[0]][cur[1]-1]){
                map[cur[0]][cur[1]-1] = false;
                qu.addLast(new Integer[]{cur[0], cur[1]-1});
            }

            // 아래 경계 확인
            if(cur[0]+1 != rowBound && map[cur[0] + 1][cur[1]]){
                map[cur[0]+1][cur[1]] = false;
                qu.addLast(new Integer[]{cur[0]+1, cur[1]});
            }
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;


        int testCaseNumber = Integer.parseInt(br.readLine());
        for(int i = 0; i < testCaseNumber; i++){

            count = 0;
            String[] inp = br.readLine().split(" ");
            int rowNum = Integer.parseInt(inp[0]);
            int colNum = Integer.parseInt(inp[1]);
            int cabbageNum = Integer.parseInt(inp[2]);

            boolean map[][] = new boolean[rowNum][colNum];

            for(int a = 0; a < cabbageNum; a++){
                inp = br.readLine().split(" ");
                int row = Integer.parseInt(inp[0]);
                int col = Integer.parseInt(inp[1]);

                map[row][col] = true;
            }

            for(int p = 0 ; p < rowNum ; p++){
                for(int q = 0 ; q < colNum ; q++){
                    if(map[p][q]){
                        count += 1;
                        search(map, p, q);
                    }
                }
            }

            System.out.println(count);
        }


    }
}
