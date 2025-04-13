import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class C17298_O {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int len = Integer.parseInt(br.readLine());

        int[] nums = new int[len];
        int[] result = new int[len];

        String[] inputs = br.readLine().split(" ");
        for(int i = 0; i < len; i++){
            nums[i] = Integer.parseInt(inputs[i]);
        }

        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < len; i++){
            // 스택에 인덱스를 넣고, 현재 값이 더 크면 해당 인덱스의 오큰수로 설정
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                int idx = stack.pop();
                result[idx] = nums[idx];
            }
        }

    }
}
