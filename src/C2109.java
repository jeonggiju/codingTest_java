import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * n개 의 강연
 * d p : d(날짜) p(강의료)
 *
 */
public class C2109 {
    public static class Class{
        int day;
        int pay;

        public Class(int day, int pay){
            this.day =day;
            this.pay =pay;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] checkDay = new boolean[10000]; // 0-based

        PriorityQueue<Class> pq = new PriorityQueue<>((a, b)->{
            if(a.pay == b.pay){
                return b.day - a.day;
            }
            return b.pay - a.pay;
        });

        for(int i = 0 ; i < n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int pay = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());

            pq.add(new Class(day, pay));
        }

        int day = 0;
        int result = 0;

        while(!pq.isEmpty()){
            Class curClass = pq.poll();

            for(int i=curClass.day-1 ; i>=0 ; i--){
                if(!checkDay[i]){		//가능한 날짜 존재시
                    checkDay[i] = true;	//해당 날짜 강연 진행
                    result += curClass.pay;	//금액 증가
                    break;		//탐색 종료
                }
            }
        }

        System.out.println(result);
    }
}

