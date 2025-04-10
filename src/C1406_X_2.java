import java.util.*;

public class C1406_X_2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        Deque<Character> left = new ArrayDeque<>();
        Deque<Character> right = new ArrayDeque<>();

        // 초기 문자열 입력
        String str = sc.nextLine();
        for (char c : str.toCharArray()) {
            left.addLast(c);
        }

        // 명령 개수
        int N = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < N; i++) {
            String cmd = sc.nextLine();

            switch (cmd.charAt(0)) {
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
                    left.addLast(cmd.charAt(2));
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : left) sb.append(c);
        for (char c : right) sb.append(c);

        System.out.println(sb.toString());
    }
}
