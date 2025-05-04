import java.math.BigInteger;
import java.util.Scanner;

public class C1914 {
    public static StringBuilder sb = new StringBuilder();

    public static void hanoi(int n, int startRod, int destinationRod, int assistanceRod){
        if(n == 1){
            // 디스크 1개일 때 직접 이동을 출력
            sb.append(startRod).append(" ").append(destinationRod).append("\n");
            return;
        }


        hanoi(n-1, startRod, assistanceRod, destinationRod);
        sb.append(startRod).append(" ").append(destinationRod).append("\n");
        hanoi(n-1, assistanceRod, destinationRod, startRod);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        BigInteger count = BigInteger.valueOf(2).pow(n).subtract(BigInteger.ONE);
        System.out.println(count);


        if(n <= 20){
            hanoi(n, 1, 3, 2);
            System.out.print(sb.toString());
        }

    }
}
