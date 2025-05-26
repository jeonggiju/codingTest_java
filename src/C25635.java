import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * max heap을 쓰자.
 * 1 2 3 4
 * 4 -> 3 -> 다시 4를 넣어 그럼 중복이 안됨
 */
public class C25635 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b- a);

        String[] inp = br.readLine().split(" ");

        for(int i = 0 ; i < n ; i++){
            pq.add(Integer.parseInt(inp[i]));
        }

        int count = 0;
        while(!pq.isEmpty()){

            Integer maxValue = pq.poll();
            maxValue-= 1;
            count+=1;

            if(pq.isEmpty()){
                break;
            }

            Integer nextMaxValue = pq.poll();
            nextMaxValue -= 1;
            count+=1;

            if(maxValue != 0) pq.add(maxValue);
            if(nextMaxValue != 0) pq.add(nextMaxValue);
        }

        System.out.println(count);
    }
}
