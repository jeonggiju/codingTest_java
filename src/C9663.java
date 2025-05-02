import java.util.Scanner;

public class C9663 {
    public static int N;
    // 퀸은 true 로 표현
    public static boolean[][] map;
    // 좌상, 위, 우상
    public static int count = 0;

    /**
     * 현재 깊이(row)에서 퀸을 둘 수 있는가를 확인
     * @param depth : dfs 깊이, 사실상 현재 row
     * @param currentCol : 현재 col
     * @return : 만일 퀸을 둘 수 있다면 true, 그렇지 않다면 false
     */
    public static boolean isAvailable(int depth, int currentCol){

        int currentRow = depth;
        // 이동 가능 여부 확인
        // 1) 같은 열 위로
        for (int i = 0; i < currentRow; i++) {
            if (map[i][currentCol]) return false;
        }

        // 2) 왼쪽 위 대각선
        for (int i = 1; currentRow - i >= 0 && currentCol - i >= 0; i++) {
            if (map[currentRow - i][currentCol - i]) return false;
        }

        // 3) 오른쪽 위 대각선
        for (int i = 1; currentRow - i >= 0 && currentCol + i < N; i++) {
            if (map[currentRow - i][currentCol + i]) return false;
        }

        return true;
    }

    public static void dfs(int depth){

        if(depth == N){
            count++;
            return;
        }

        for(int i = 0 ; i < N ; i++){
            if(isAvailable(depth, i)){
                map[depth][i] = true;
                dfs(depth+1);
                map[depth][i] = false;
            }
        }
    }

    public static void main(String[] args) {
        N = new Scanner(System.in).nextInt();
        map = new boolean[N][N];
        dfs(0);

        System.out.println(count);
    }
}
