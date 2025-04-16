import java.io.*;
import java.util.*;

/**
 * B < C -> BC
 * BC < D -> BCD
 * BCD > A -> DCBA
 * DCBA < F -> DCBAF
 *
 * BDCAF -> ABCDF
 * B
 * BD
 *
 */
public class C1464_O {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        Deque<Character> dq = new ArrayDeque<>();
        dq.add(S.charAt(0));

        for (int i = 1; i < S.length(); i++) {
            char current = S.charAt(i);

            if (current <= dq.peekFirst()) { // 현재 BCD 이고 다음이 A 같은 경우 -> ABCD 로만듬
                dq.addFirst(current);
            } else {
                dq.addLast(current);
            }
        }

        StringBuilder sb = new StringBuilder();
        int size = dq.size();
        for (int i = 0 ; i < size ; i++) {
            sb.append(dq.removeFirst());
        }

        System.out.println(sb.toString());
    }
}
