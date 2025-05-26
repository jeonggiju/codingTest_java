import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * D : 노래의 길이
 * V : 다운로드 걸리는 시간
 * -> 2 1  ==>  1
 * -> 1 5  ==> -4
 * -> 3 3  ==>  0
 * -> 2 4  ==> -2
 * Length   : 2 1 3 2
 * Download : 1 5 3 4
 * - 8 13 -> 6 12 -> 5 7 -> 2 4 -> 0 0
 *
 */
public class C3216 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int[] length = new int[num];
        int[] download = new int[num];

        for(int i = 0 ; i < num ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            length[i] = Integer.parseInt(st.nextToken());
            download[i] = Integer.parseInt(st.nextToken());
        }

        long x = 0;
        long sumDownload = 0, sumLength = 0;
        for (int i = 0; i < num; i++) {
            sumDownload += download[i];
            x = Math.max(x, sumDownload - sumLength);
            sumLength += length[i];
        }
        System.out.println(x);




    }
}
