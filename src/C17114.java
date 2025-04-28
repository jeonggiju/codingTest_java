import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class C17114 {
    static int[][] nextDir =  {
            {1,0,0,0,0,0,0,0,0,0,0},
            {-1,0,0,0,0,0,0,0,0,0,0},
            {0,1,0,0,0,0,0,0,0,0,0},
            {0,-1,0,0,0,0,0,0,0,0,0},
            {0,0,1,0,0,0,0,0,0,0,0},
            {0,0,-1,0,0,0,0,0,0,0,0},
            {0,0,0,1,0,0,0,0,0,0,0},
            {0,0,0,-1,0,0,0,0,0,0,0},
            {0,0,0,0,1,0,0,0,0,0,0},
            {0,0,0,0,-1,0,0,0,0,0,0},
            {0,0,0,0,0,1,0,0,0,0,0},
            {0,0,0,0,0,-1,0,0,0,0,0},
            {0,0,0,0,0,0,1,0,0,0,0},
            {0,0,0,0,0,0,-1,0,0,0,0},
            {0,0,0,0,0,0,0,1,0,0,0},
            {0,0,0,0,0,0,0,-1,0,0,0},
            {0,0,0,0,0,0,0,0,1,0,0},
            {0,0,0,0,0,0,0,0,-1,0,0},
            {0,0,0,0,0,0,0,0,0,1,0},
            {0,0,0,0,0,0,0,0,0,-1,0},
            {0,0,0,0,0,0,0,0,0,0,1},
            {0,0,0,0,0,0,0,0,0,0,-1},
    };


    public static int bfs(int[][][][][][][][][][][] map, int[] mapNum) {
        int m = mapNum[0], n = mapNum[1], o = mapNum[2], p = mapNum[3], q = mapNum[4], r = mapNum[5], s = mapNum[6], t = mapNum[7], u = mapNum[8], v = mapNum[9], w = mapNum[10];

        Deque<int[]> qu = new ArrayDeque<>();

        for (int a = 0; a < w; a++) {
            for (int b = 0; b < v; b++) {
                for (int c = 0; c < u; c++) {
                    for (int d = 0; d < t; d++) {
                        for (int e = 0; e < s; e++) {
                            for (int f = 0; f < r; f++) {
                                for (int g = 0; g < q; g++) {
                                    for (int h = 0; h < p; h++) {
                                        for (int i = 0; i < o; i++) {
                                            for (int j = 0; j < n; j++) {
                                                for (int k = 0; k < m; k++) {
                                                    if (map[k][j][i][h][g][f][e][d][c][b][a] == 1) {
                                                        qu.add(new int[]{k, j, i, h, g, f, e, d, c, b, a});
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        int day = 0;

        while (!qu.isEmpty()) {
            int size = qu.size();

            for (int sIdx = 0; sIdx < size; sIdx++) {
                int[] cur = qu.poll();

                for (int[] dir : nextDir) {
                    int nk = cur[0] + dir[0];
                    int nj = cur[1] + dir[1];
                    int ni = cur[2] + dir[2];
                    int nh = cur[3] + dir[3];
                    int ng = cur[4] + dir[4];
                    int nf = cur[5] + dir[5];
                    int ne = cur[6] + dir[6];
                    int nd = cur[7] + dir[7];
                    int nc = cur[8] + dir[8];
                    int nb = cur[9] + dir[9];
                    int na = cur[10] + dir[10];

                    if (nk >= 0 && nk < m && nj >= 0 && nj < n && ni >= 0 && ni < o && nh >= 0 && nh < p &&  ng >= 0 && ng < q && nf >= 0 && nf < r && ne >= 0 && ne < s &&
                            nd >= 0 && nd < t && nc >= 0 && nc < u && nb >= 0 && nb < v && na >= 0 && na < w) {

                        if (map[nk][nj][ni][nh][ng][nf][ne][nd][nc][nb][na] == 0) {
                            map[nk][nj][ni][nh][ng][nf][ne][nd][nc][nb][na] = 1;
                            qu.add(new int[]{nk, nj, ni, nh, ng, nf, ne, nd, nc, nb, na});
                        }
                    }
                }
            }

            if (!qu.isEmpty()) {
                day++;
            }
        }

        for (int a = 0; a < w; a++) {
            for (int b = 0; b < v; b++) {
                for (int c = 0; c < u; c++) {
                    for (int d = 0; d < t; d++) {
                        for (int e = 0; e < s; e++) {
                            for (int f = 0; f < r; f++) {
                                for (int g = 0; g < q; g++) {
                                    for (int h = 0; h < p; h++) {
                                        for (int i = 0; i < o; i++) {
                                            for (int j = 0; j < n; j++) {
                                                for (int k = 0; k < m; k++) {
                                                    if (map[k][j][i][h][g][f][e][d][c][b][a] == 0) {
                                                        return -1;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return day;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inp = br.readLine().split(" ");
        int[] mapNum = new int[11];
        for(int i = 0 ; i < 11 ; i++){
            mapNum[i] = Integer.parseInt(inp[i]);
        }

        int m = mapNum[0], n = mapNum[1], o = mapNum[2], p = mapNum[3], q = mapNum[4];
        int r = mapNum[5], s = mapNum[6], t = mapNum[7], u = mapNum[8], v = mapNum[9], w = mapNum[10];

        int [][][][][][][][][][][] map = new int[m][n][o][p][q][r][s][t][u][v][w];

        int total = m * n * o * p * q * r * s * t * u * v * w;

        List<Integer> inputs = new ArrayList<>();

        while (inputs.size() < total) {
            String[] line = br.readLine().split(" ");
            for (String num : line) {
                    inputs.add(Integer.parseInt(num));
            }
        }

        int idx = 0;
        for (int a = 0; a < w; a++) {
            for (int b = 0; b < v; b++) {
                for (int c = 0; c < u; c++) {
                    for (int d = 0; d < t; d++) {
                        for (int e = 0; e < s; e++) {
                            for (int f = 0; f < r; f++) {
                                for (int g = 0; g < q; g++) {
                                    for (int h = 0; h < p; h++) {
                                        for (int i = 0; i < o; i++) {
                                            for (int j = 0; j < n; j++) {
                                                for (int k = 0; k < m; k++) {
                                                    map[k][j][i][h][g][f][e][d][c][b][a] = inputs.get(idx++);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }


        int result =  bfs(map, mapNum);
        System.out.println(result);
    }
}
