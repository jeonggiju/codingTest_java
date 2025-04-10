import java.util.*;
import java.io.*;

// 시간 초과
public class C12873_X {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int MemberNum = Integer.parseInt(bufferedReader.readLine());
        Deque<Integer> dq = new ArrayDeque<>();

        for(int i = 0; i < MemberNum; i++){
            dq.addLast(i+1);
        }

        int step = 1;
        while(dq.size() != 1){
            for(int i = 1 ; i < Math.pow(step, 3) ; i++){
                dq.addLast(dq.removeFirst());
            }
            step++;

            dq.removeFirst();
        }

        System.out.println(dq.removeFirst());
    }
}
