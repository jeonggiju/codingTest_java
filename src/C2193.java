import java.util.Scanner;


/**
 * 1 -> 10 -> 100  -> 1000 -> 10000
 *                         -> 10001
 *                 -> 1001 -> 10010
 *                         -> 10011(x)
 *         -> 101  -> 1010 -> 10100
 *                         -> 10101
 *                 -> 1011(x)
 *   -> 11(x)
 */

/**
 *
 */

public class C2193 {

    public static int[] arr;
    public static int n;
    public static int count = 0;

    public static void back(int idx, int value){

        if (idx == n) {
            count++;
            return ;
        }

        arr[idx] = value;

        // 앞이 1인경우
        if(arr[idx-1]==1){
            back(idx+1, 0);
        }else{ // 0인 경우
            back(idx+1,1);
            back(idx+1,0);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        arr[0] = 1;

        back(1,0);

        System.out.println(count);
    }
}
