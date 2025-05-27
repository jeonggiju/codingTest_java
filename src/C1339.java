    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.Arrays;

    public class C1339 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int num = Integer.parseInt(br.readLine());

            long[] importances = new long[26];
            String[] inp = new String[num];

            for(int i = 0 ; i < num ; i++){
                inp[i] = br.readLine();
            }

            // 각 알파벳의 중요도 계산하기
            for(String str : inp){
                char[] chArr = str.toCharArray();
                long importance = (long)Math.pow(10, chArr.length);

                for(char ch : chArr){
                    importances[ch-'A'] += importance;
                    importance/=10;
                }
            }

            Integer[] idx = new Integer[26];
            for (int i = 0; i < 26; i++) idx[i] = i;
            Arrays.sort(idx, (a, b) -> Long.compare(importances[b], importances[a]));

            long ans = 0;
            int digit = 9;

            for (int i = 0; i < 26 && digit >= 0; i++) {
                if (importances[idx[i]] == 0)
                    break;
                ans += importances[idx[i]] * digit--;
            }

            System.out.println(ans/10);
        }
    }
