import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class C12873_O {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int MemberNum = Integer.parseInt(bufferedReader.readLine());
        List<Integer> ls = new ArrayList<>();

        for(int i = 1; i <= MemberNum; i++){
            ls.add(i);
        }

        int step = 1;
        int idx = 0;

        while(ls.size() != 1){
            long k = (long)Math.pow(step, 3);
            idx = (int)((idx + k - 1) % ls.size());
            ls.remove(idx);
            step++;
        }

        System.out.println(ls.get(0));
    }
}
