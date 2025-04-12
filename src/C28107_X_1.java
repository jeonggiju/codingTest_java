import java.util.*;
import java.io.*;

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
public class C28107_X_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, List<Integer>> m = new HashMap<>();

        String[] arr = br.readLine().split(" ");
        int customerCount = Integer.parseInt(arr[0]);
//        int sushiCount = Integer.parseInt(arr[1]);
        int[] result = new int[customerCount];

        for(int i = 1 ; i <= customerCount ; i++) {
            List<Integer> sushies = new ArrayList<>();

            String[] str =  br.readLine().split(" ");
            int sushiForEachCustomer = Integer.parseInt(str[0]);
            for(int j = 1; j <= sushiForEachCustomer ; j++) {
                sushies.add(Integer.parseInt(str[j]));
            }
            m.put(i, sushies);
        }

        String[] sushies = br.readLine().split(" ");
        for(int i = 0; i < sushies.length; i++) { // 나오는 스시 하나씩 처리
            int currentSushi = Integer.parseInt(sushies[i]);

            for(int j = 1 ; j <= m.size(); j++){ // map 을 순회
                List<Integer> currentCustomerSushies = m.get(j);
                if(currentCustomerSushies.contains(currentSushi)) {
                    result[j-1] += 1;
                    currentCustomerSushies.remove(Integer.valueOf(currentSushi)); // remove(index)
                    break;
                }
            }
        }

        for(int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
