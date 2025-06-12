import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class C1049 {
    public static void main(String[] args) throws IOException {
        int zul;
        int brandCount;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inp = br.readLine().split(" ");

        zul = Integer.parseInt(inp[0]);
        brandCount = Integer.parseInt(inp[1]);

        int[] pack = new int[brandCount];
        int[] one = new int[brandCount];


        for(int i = 0 ; i < brandCount ; i++){
            inp = br.readLine().split(" ");
            pack[i] = Integer.parseInt(inp[0]);
            one[i] = Integer.parseInt(inp[1]);
        }

        int minPackage = Arrays.stream(pack).min().getAsInt();
        int minOne = Arrays.stream(one).min().getAsInt();

        /**
         * 경우
         * maxPackage로 다 채우기
         * maxOne으로 다 채우기
         * 둘다 섞기
         */

        int[] result = new int[3];

        result[0] = minPackage * (int)(Math.ceil((double)zul / 6));
        result[1] = minOne * zul;
        result[2] = minOne*(zul % 6) + minPackage * (int)(Math.floor((double)zul / 6));

        Arrays.sort(result);

        System.out.println(result[0]);


    }
}
