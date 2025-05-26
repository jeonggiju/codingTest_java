import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;


/**
 * 그리디 알고리즘이니 최적부분 구조를 구해야한다.
 * ???
 * 없어...
 *
 * 배열 두 개가 필요할 것 같은데 메모리도 512MB인거보면 가능 가능 ssap가능 아 근데 시간이 너무 적어...
 *
 * 예를 들자 0 0 0 1 1 4 K = 2
 * 첫 번쨰
 * 값을 인덱스로 하고 가령
 * 0 1 2 3 4
 * 3 2 0 0 1
 *
 * arr[0] = 3 > k(2) 이니 페스
 * arr[1] = 2 = k(2) 이니 가능.
 *
 * 이렇게 mex의 최소값을 구할 수 있음
 *
 * 최대값은 안구해지네
 *
 * 이거 아닌듯 깔끔하지 않아. 다시.
 * 에초에 시간 제한이 0.5초임 1초에 10^8이라 안됨 아 시간 생각하지마
 * ================================
 * 예를 들자 0 0 0 1 1 4 K = 2
 * mex의 최솟값을 구하는 건 가능함
 * 0의 개수가 3개임
 * 1의 개수가 2개니 <= K 이니 가능가능 쌉가능
 *
 * mex의 최댓값이 문제임 뭐지
 * HashMap을 쓸까? -> 아냐 시간 터짐
 *
 * 안구해짐
 * 아
 * 그리디 알고리즘이 더 어려워 ...
 *
 *
 */
public class C33714 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        int[] numbers = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int[] frequency = new int[N+1]; // 왜 N+1이지? 
        for (int x : numbers) {
            if (0 <= x && x <= N) {
                frequency[x]+=1;
            }
        }

        int originMex = 0;
        while (originMex <= N && frequency[originMex] > 0) {
            originMex++;
        }

        // minMex 찾기
        int missing = 0;
        int minMex = originMex;
        for (int i = 0; i < originMex; i++) {
            if (frequency[i] == 0)
                missing++;
            if ((long)missing + frequency[i] <= K) {
                minMex = i;
                break;
            }
        }

        // maxMex 찾기
        Arrays.sort(numbers); // 오름차순 정렬
        long remainK = K;
        int prev = -1;
        long maxMex = -1;

        for (int current : numbers) {
            // 현재의 위치와 이전의 위치가 동일한 경우
            if (current < 0 || current == prev)
                continue;
            int gap = current - prev - 1;

            if (remainK < gap) {
                maxMex = prev + 1L + remainK;
                break;
            }

            remainK -= gap;
            prev = current;
        }

        if (maxMex < 0) {
            maxMex = prev + 1L + remainK;
        }

        System.out.println(minMex);
        System.out.println(maxMex);
    }
}
