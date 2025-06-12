import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 전체 방의 개수:  3n^2 - 3n + 1
 *  n = 1 --> 1
 *  n = 2 --> 7
 *  n = 3 --> 19
 *
 * 한 변의 길이 : N
 *
 * 행의 개수 : 2n - 1
 *
 * 한 행의 방의 개수 : 2n - 1 - | i - n |
 *  i의 범위 1 <= i < 2n
 *
 * e.g.
 * 1 1 1 0 0
 * 1 1 1 1 0
 * 1 1 1 1 1
 * 1 1 1 1 0
 * 1 1 1 0 0
 *
 * 방향:
 *  - 현재 위치(i, j)
 * Q : i-1, j-1
 * E : i-1, j
 * A : i, j-1
 * D : i, j+1
 * Z : i+1, j-1
 * C : i+1, j
 * 그리디? 6개의 방향으로 많이 남은 대로 가면되는거 아닌가? 아님
 * dp? 아님
 * 분할?
 *
 */
public class C28285 {

    // Q E A D Z C
    public static int[][] dir = new int[][]{{-1, -1}, {-1, 0}, {0, -1}, {0, 1},{1,-1},{1,0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inp = br.readLine().split(" ");
        int N = Integer.parseInt(inp[0]);
        int targetRow = Integer.parseInt(inp[1]);
        int targetCol = Integer.parseInt(inp[2]);


        // 1-base로
        int startRow = 2*N-1;
        int startCol = 2*N-1;

        /**
         * N은 4
         * 방의 개수 : 37
         * 이동 횟수의 총합 : 37
         * 5     // 11          // 18                 // 3
         * E // C Z A Q // Q Z CC DD EE QQ A // Q DD CCC ZZZ AAA QQQ EEE // CCC 3n^2 - 3n + 1
         */

        /**
         * 각 단계를 넘어갈 때
         */

        int numberOfRoom = 3 * N * N - 3 * N + 1;
        int moveCount;

        for(int i = 0 ; i < numberOfRoom ; i++){
            int currentRow = startRow;
            int currentCol = startCol;

            if(currentRow == targetRow && currentCol == targetCol){
                moveCount = i;
                break;
            }

        }



    }
}
