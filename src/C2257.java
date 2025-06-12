import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class C2257 {
    public static Map<Character, Integer> map = Map.of('H', 1, 'C', 12, 'O', 16);
    public static Deque<Integer> stack = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] inp = br.readLine().toCharArray();

        for (int i = 0; i < inp.length; i++) {
            char ch = inp[i];

            if (ch == '(') { // (
                stack.addLast(-1);
            } else if (map.containsKey(ch)) { // O, H, C
                stack.addLast(map.get(ch));
            } else if (ch == ')') {
                int sum = 0;

                while (!stack.isEmpty()) {
                    int top = stack.removeLast();
                    if (top == -1)
                        break;
                    sum += top;
                }

                stack.addLast(sum);
            } else { // O3와 같은 경우
                int mul = ch - '0';
                int last = stack.removeLast();
                stack.addLast(last * mul); // 곱해서 다시 push
            }
        }

        int result = 0;
        while (!stack.isEmpty()) result += stack.removeLast();
        System.out.println(result);
    }
}
