import java.io.*;
import java.util.*;

public class C1406_O {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Character> left = new ArrayDeque<>();
        Deque<Character> right = new ArrayDeque<>();

        System.out.println();
        // 초기 문자열 입력
        String str = br.readLine();
        for (char c : str.toCharArray()) {
            left.addLast(c);
        }

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            switch (input.charAt(0)) {
                case 'L':
                    if (!left.isEmpty()) {
                        right.addFirst(left.pollLast());
                    }
                    break;
                case 'D':
                    if (!right.isEmpty()) {
                        left.addLast(right.pollFirst());
                    }
                    break;
                case 'B':
                    if (!left.isEmpty()) {
                        left.pollLast();
                    }
                    break;
                case 'P':
                    left.addLast(input.charAt(2));
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : left) sb.append(c);
        for (char c : right) sb.append(c);

        System.out.println(sb.toString());
    }
}
