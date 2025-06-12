import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C2630 {

    public static int[][] graph;
    public static int white = 0;
    public static int blue = 0;

    public static boolean isRight(int length, int startRow, int startCol){
        int base = graph[startRow][startCol];

        for(int i = startRow ; i < length+startRow ; i++){
            for(int j = startCol ; j < length+startCol ; j++){
                if(graph[i][j] != base){
                    return false;
                }
            }
        }
        return true;
    }


    public static void recursive(int startRow, int startCol ,int length){
        if(isRight(length, startRow, startCol)){
            if(graph[startRow][startCol]==1){
                blue++;
            }else{
                white++;
            }

            return;
        }

        recursive(startRow, startCol, length/2);
        recursive(startRow+length/2, startCol, length/2);
        recursive(startRow, startCol+length/2, length/2);
        recursive(startRow+length/2, startCol+length/2, length/2);
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        graph = new int[n][n];

        for(int i = 0 ; i < n ; i++){
            String[] inp = br.readLine().split(" ");
            for(int j = 0 ; j < n ; j++){
                graph[i][j] = Integer.parseInt(inp[j]);
            }
        }

        recursive(0, 0, n);


        System.out.println(white);
        System.out.println(blue);


    }
}
