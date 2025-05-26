/**
 * e.g.1
 * 8 24 9
 * 2^3, 2^3*3, 3^2
 * 답: 12 3
 * 잘 나눠줘야한다. 기준이 뭘까
 *
 * 문득 든 생각인데
 * 다 합쳐볼까?
 * 2^6일 때고, 3^4이다.
 * 이걸 N개를 나눠줘야한다. 여기서는 n=3이 되겟네
 * 2^2 * 3^1 || 2^2 * 3^1 || 2^2 * 3^1 이렇게 나눠줘야한다.
 * 2^3       || 2^3 * 3   || 3^2 에서 위와 같이 만들려면
 *  2        || 1         || 3
 *
 *  합은 6인데 한번 바뀔 때 2개가 달라지니 /2 해준다.
 *
 *  3
 *
 * 답: 12 3 맞는것 같은디?

 * e.g.2
 * 4 4 1
 * 2^2 2^2 1 다 합치면 다음과 같다.
 * 2^4 여기서 공산주의 맹키로 나눠준다.
 *
 * 2^1  || 2^1 || 2^1
 * 2^2  || 2^2 || 1
 * 1    || 1   || 1
 * 2를 나눈다. => 1.5 => 1 허허 다푼 것같은데요??
 *
 * 답: 2 1
 *
 * 마지막으로 한번 더 해보자.
 * 5
 * 4 5 6 7 8
 *
 * 2^2 || 5 || 2*3 || 7 || 2^3
 * 다 합쳐본다
 * 2^6 * 3^1 * 5 * 7
 * 그러면 2^1 개씩 가져야한다.
 * 2^1 || 2^1 || 2^1 || 2^1 || 2^1
 * 2^2 || 5   || 2*3 || 7   || 2^3
 *  1  ||  1  ||  0  || 1   || 2
 *  합 5 <- 5/2 == 2
 * 2 2
 *
 * 이걸 구현해야함 하;;;
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

/**
 * 입력 : N (1 <= N <= 100)개의 수, 수의 범위 1 <= <= 1000000(백만)
 */
public class C2904 {
    public static List<Integer> primes;

    public static Map<Integer, Integer> toPrimeMap(int n) {
        Map<Integer, Integer> map = new HashMap<>();

        int tmp = n;

        for (int p : primes) {
            while (tmp % p == 0) {
                map.put(p, map.getOrDefault(p,0)+1);
                tmp /= p;
            }
            if (tmp == 1) break;
        }

        return map;
    }

    public static List<Integer> getSoSu(int n){
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime,true);

        isPrime[0] = isPrime[1] = false;

        int limit = (int)Math.sqrt(n);

        for(int i = 2 ; i <= limit ; i++){
            if(!isPrime[i])
                continue;
            for(int j = i * i; j <= n; j+=i){
                isPrime[j] = false;
            }
        }

        List<Integer> primes = new ArrayList<>();

        for(int i = 2 ; i <= n ; i++){
            if(isPrime[i]){
                primes.add(i);
            }
        }
        return primes;
    }
    
    public static int getFromMap(Map<Integer, Integer> map){
        
        int result = 1;
        for(Integer key : map.keySet()){
            result *= (int)Math.pow(key, map.get(key));
        }
        
        return result;
    }

    public static void main(String[] args)throws IOException {
        primes = getSoSu(1000000);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        List<Map<Integer, Integer>> numbers = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        /**
         * 아래와 같이 저장됨
         * 8 24 9
         * {2=3}
         * {2=3, 3=1}
         * {3=2}
         */
        for(int i = 0 ; i < n; i++){
            numbers.add(toPrimeMap(Integer.parseInt(st.nextToken())));
        }

        Map<Integer, Integer> res = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            Map<Integer, Integer> current = numbers.get(i);

            for(Integer key : current.keySet()){
                Integer value = current.get(key);
                res.put(key, value+(res.getOrDefault(key, 0)));
            }
        }

        for(Integer key : res.keySet()){
            res.put(key,res.get(key)/n);
        }

        int moves = 0;
        for (Map<Integer,Integer> curMap : numbers) {
            for (Map.Entry<Integer,Integer> element : res.entrySet()) {
                int key = element.getKey();
                int target = element.getValue();            // floor(sum_i exp_i / N)
                int cur = curMap.getOrDefault(key, 0);
                if (cur < target) {
                    moves += (target - cur);
                }
            }
        }
        System.out.println(getFromMap(res) + " " + moves);
    }
}
