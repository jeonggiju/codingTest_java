import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class C6603 {

    // 0-based
    public static boolean[] isVisited;
    public static int[] numbers;
    public static int[] c = new int[6];

    public static void dfs(int currentNode, int depth){
        if(depth == 6){
            System.out.println(Arrays.toString(c));
            return;
        }

        isVisited[currentNode] = true;
        c[depth] = numbers[currentNode];

        for(int i = 0 ; i < numbers.length ; i++){
            if(!isVisited[i]){
                dfs(i, depth+1);
                isVisited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String[] inp = br.readLine().split(" ");
            int k = Integer.parseInt(inp[0]);

            if(k == 0) break;
            numbers = new int[k];
            isVisited = new boolean[k];

            for(int i = 1 ; i < inp.length ; i++){
                numbers[i-1] = Integer.parseInt(inp[i]);
                isVisited[i-1] = false;
            }

            for(int i = 0; i < k ; i++){
                dfs(i, 0);
            }

            System.out.println();
        }


    }
}
