import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 3 5       // 손님수,  초밥수
 * 2 1 6     // 1번 손님: 초밥의 수 + 초밥 종류
 * 3 2 3 5   // 2번 손님
 * 1 1       // 3번 손님
 * 3 2 1 4 5 // 초밥이 나오는 순서
 *
 * ** 결과
 * 1 3 0 // 각 손님이 먹는 초밥의 수
 */

public class C28107_O {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer>[] sushi = new ArrayDeque[200001];
        for(int i = 0 ; i < sushi.length ; i++){
            sushi[i] = new ArrayDeque<>();
        }
        String[] s = br.readLine().split(" ");
        int customerCount = Integer.parseInt(s[0]);
        int sushiCount = Integer.parseInt(s[1]);

        // 각 손님의 초밥 주문 순서 담기
        for(int i = 1; i <= customerCount ;i++){
            s = br.readLine().split(" ");
            int orderCount = Integer.parseInt(s[0]);
            for(int j = 1 ; j <= orderCount ; j++){
                int orderSushi = Integer.parseInt(s[j]);
                sushi[orderSushi].addLast(i);
            }
        }

        // 초밥 처리
        s = br.readLine().split(" ");
        int[] result = new int[customerCount];
        for(int i = 0 ; i < sushiCount ; i++){
            int currentSushi = Integer.parseInt(s[i]);
            if (!sushi[currentSushi].isEmpty()) {
                int customerNum = sushi[currentSushi].pollFirst(); // 손님 번호
                result[customerNum - 1] += 1; // 배열 인덱스 맞추기
            }
        }

        for(int i = 0 ; i < result.length ; i++){
            System.out.print(result[i] + " ");
        }
    }
}


