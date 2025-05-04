import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C15683 {
    static int[][] map;

    static int n,m;
    // 담아둘 cctv의 list들
    static List<CCTV> cctvLs;
    static int[] dRow = {0,1,0,-1};
    static int[] dCol = {1,0,-1,0};
    static int resultValue = Integer.MAX_VALUE;
    static int area;

    public static class CCTV {
        int row;
        int col;
        int type;
        List<Integer> direction = new ArrayList<>();

        CCTV(int row, int col, int type) {
            this.row = row;
            this.col = col;
            this.type = type;
        }

        public void addDir(int dir) {
            direction.add(dir);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        cctvLs = new ArrayList<>(); // cctv를 담아둠, row, col, type, 방향
        area = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 0)
                    area++; // 0의 개수
                // 카메라 추가
                if (map[i][j] != 0 && map[i][j] != 6)
                    cctvLs.add(new CCTV(i,j,map[i][j]));
            }
        }

        dfs(0, new CCTV[cctvLs.size()]);
        System.out.println(resultValue);
    }

    static void dfs(int depth, CCTV[] cctvs) {

        // cctv 개수 만큼 도달
        if (depth == cctvLs.size()) {
            countArea(cctvs, new boolean[n][m]);
            return;
        }
        // cctv를 선택
        CCTV selected = cctvLs.get(depth);

        // 방향 설정
        for (int i = 0; i < 4; i++) {
            CCTV cctv = new CCTV(selected.row, selected.col, selected.type);

            switch (cctv.type) {
                case 1:
                    cctv.addDir(i);
                    cctvs[depth] = cctv;
                    dfs(depth+1, cctvs);
                    break;
                case 2:
                    if (i >= 2) return;
                    cctv.addDir(i);
                    cctv.addDir(i+2);
                    cctvs[depth] = cctv;
                    dfs(depth+1, cctvs);
                    break;
                case 3:
                    cctv.addDir(i);
                    cctv.addDir((i+1) % 4);
                    cctvs[depth] = cctv;
                    dfs(depth+1, cctvs);
                    break;
                case 4:
                    cctv.addDir(i);
                    cctv.addDir((i+1) % 4);
                    cctv.addDir((i+2) % 4);
                    cctvs[depth] = cctv;
                    dfs(depth+1, cctvs);
                    break;
                case 5:
                    if (i > 0) return;
                    cctv.addDir(i);
                    cctv.addDir((i+1) % 4);
                    cctv.addDir((i+2) % 4);
                    cctv.addDir((i+3) % 4);
                    cctvs[depth] = cctv;
                    dfs(depth+1, cctvs);
                    break;
            }
        }
    }

    static void countArea(CCTV[] cctvs, boolean[][] visited) {

        int cnt = 0;
        // cctv의 개수 만큼 반복
        for (int i = 0; i < cctvs.length; i++) {

            CCTV cctv = cctvs[i];
            // 각 cctv 타입에 맞는 방향
            for (int j = 0; j < cctv.direction.size(); j++) {
                int dir = cctv.direction.get(j);
                int nextRow = cctv.row + dRow[dir];
                int nextCol = cctv.col + dCol[dir];

                while (nextRow >= 0 && nextCol >= 0 && nextRow < n && nextCol < m) {

                    // 아직 cctv의 바운드에 해당되지 않음
                    if (map[nextRow][nextCol] == 0) {
                        if (!visited[nextRow][nextCol]) { // 방문하지 않았으면
                            cnt++;
                            visited[nextRow][nextCol] = true;
                        }
                    }

                    // 벽을 만남
                    if (map[nextRow][nextCol] == 6)
                        break;

                    nextRow += dRow[dir];
                    nextCol += dCol[dir];
                }

            }
        }

        resultValue = Math.min(resultValue, area - cnt);
    }
}