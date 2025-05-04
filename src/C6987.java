import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * true case
 *   A B C D E F
 * A x 1 1 1 1 1
 * B 0 x 1 1 0 1
 * C 0 0 x 1 0 1
 * D 0 0 0 x 0 0
 * E 0 1 1 1 x 1
 * F 0 0 0 1 0 x
 * - 만일 A->B가 있다면 B->A는 존재해선 안된다.
 * - 한 팀당 5번의 경기를 수행한다.
 * - 승: out degree
 * - 패: in degree
 * - 무 : in, out degree
 *
 * ===========================
 * 전체 경기 수 : 15
 * A팀의 결과 3가지 : 승, 패, 무
 * 전체 경우의 수: 3^15
 * 승리
 *   A B C D E F
 * V 5 3 2 0 4 1
 * D 0 0 0 0 0 0
 * L 0 2 3 5 1 4
 */
public class C6987 {
    public static int[][] matches = {{0,1},{0,2}, {0,3}, {0,4}, {0,5},
                                     {1,2}, {1,3}, {1,4}, {1,5},
                                     {2,3}, {2,4}, {2,5},
                                     {3,4}, {3,5},
                                     {4,5}
                                    };


    public static boolean dfs(int idx, int[][] criteria){
        if(idx == 15){
            for(int i = 0; i < criteria.length; i++){
                for(int j = 0; j < criteria[0].length; j++){
                    if(criteria[i][j] != 0){
                        return false;
                    }
                }
            }
            return true;
        }

        int a = matches[idx][0];
        int b = matches[idx][1];

        // a가 이김, b가 짐
        // 0 : 승리 횟수, 1 : 비긴 횟수, 2: 패배 횟수
        if(criteria[0][a] > 0 && criteria[2][b] > 0){
            criteria[0][a] -= 1;
            criteria[2][b] -= 1;
            if(dfs(idx+1, criteria)){
                return true;
            }
            criteria[0][a] += 1;
            criteria[2][b] += 1;
        }


        // a와 b 비김
        if(criteria[1][a] > 0 && criteria[1][b] > 0){
            criteria[1][a] -= 1;
            criteria[1][b] -= 1;
            if(dfs(idx+1, criteria)){
                return true;
            }
            criteria[1][a] += 1;
            criteria[1][b] += 1;
        }
        // b가 이김, a가 짐
        if(criteria[2][a] > 0 && criteria[0][b] > 0){
            criteria[2][a] -= 1;
            criteria[0][b] -= 1;
            if(dfs(idx+1, criteria)){
                return true;
            }
            criteria[2][a] += 1;
            criteria[0][b] += 1;
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] criteria = new int[3][6];
        StringBuilder sb= new StringBuilder();

        int count = 4;
        while(count-- > 0 ){
            String[] inp = br.readLine().split(" ");

            for(int i = 0 ; i < 6; i++){
                // 승리(빅뱅의 승리 아님)
                criteria[0][i] = Integer.parseInt(inp[3*i]);
                // 무승부
                criteria[1][i] = Integer.parseInt(inp[3*i + 1]);
                // 패배(빅뱅의 패배임)
                criteria[2][i] = Integer.parseInt(inp[3*i + 2]);
            }

            sb.append(dfs(0, criteria) ? '1' : '0').append(' ');
        }
        System.out.println(sb.toString().trim());
    }
}
